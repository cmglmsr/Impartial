<template>
  <div>
    <Navbar></Navbar>
    <div class="container-fluid" style="height: 100%">
      <div class="row no-shadow" style="width: 110%; height: 100%">
        <div class="col-2" style="display: inline">
          <Res_sidebar></Res_sidebar>
        </div>
        <div :class="columnClass" style="display: inline; height: 100%">
          <Tab_nav
            :tabs="['Left', 'Center', 'Right']"
            :selected="selected"
            @selected="setSelected"
          ></Tab_nav>
          <div class="row no-shadow adjustment">
            <News_card
              v-for="news in newsWithBookmarks"
              :key="news.id"
              :image-url="news.img"
              :date="news.publishDate ? formatDate(news.publishDate) : 'N/A'"
              :source="news.source"
              :header="news.title"
              :content="news.content"
              :news-id="news.id"
              :rate="news.rating"
              :isBookmarked="news.marked"
              :generatedArticles="news.correspondingNews"
              :alignment="news.alignment"
              @show-comment-popup="showCommentPopup(news.id)"
              @show-genAI-popup="showGenAIPopup(news.id)"
              @rate-news="rateNews(news.id, $event)"
              @show-classification-reasoning-popup="
                showClassificationReasoningPopup(news.id)
              "
              class="mb-5"
            ></News_card>
          </div>
          <!--SPINNER COMPONENT-->
          <div v-if="loading && !allNews" class="text-center mt-3">
            <div class="spinner-border text-primary" role="status">
              <span class="visually-hidden">Loading...</span>
            </div>
          </div>
        </div>
        <add_comment_popup
          :id="commentArticleId"
          :header="header"
          :commentPopup="comment_popup"
          @submit-comment="submitComment"
          @close-popup="closePopup"
        ></add_comment_popup>
        <view_genAI_options
          :article = "selectedArticle"
          :genAIPopup="genAI_popup"
          @choose-side="chooseSide"
          @close-popup="closePopup"
        ></view_genAI_options>
        <show_classification_reasoning_popup
          :article = "selectedArticle"
          :classificationReasoningPopup="classification_reasoning_popup"
          @close-popup="closePopup"
        ></show_classification_reasoning_popup>
        <div
          class="col-3 d-none d-md-block"
          style="background-color: #11101d; display: inline; height: fit-content;"
        >
          <Latest_headings
            :latestNews = "latestNews"
          ></Latest_headings>
        </div>
      </div>
    </div>
    <error_popup></error_popup>
  </div>
</template>

<script setup>
import Sidebar from "../components/sidebar/Sidebar.vue";
import Latest_headings from "../resp_components/latest_headings/Latest_headings.vue";
import Tab_nav from "../resp_components/tabs/Tab_nav.vue";
import Navbar from "../components/navbar/Navbar.vue";
import Res_sidebar from "../resp_components/sidebar/Res_sidebar.vue";
import News_card from "../resp_components/main_feed/news_card.vue";
import add_comment_popup from "../resp_components/popups/add_comment_popup.vue";
import view_genAI_options from "../resp_components/popups/view_genAI_options.vue";
import show_classification_reasoning_popup from "../resp_components/popups/show_classification_reasoning_popup.vue";
</script>

<script>
import "./feed.css";
import "primeicons/primeicons.css";
import { axiosInstance, noAuthAxiosInstance } from "@/utils";
import moment from "moment/moment";
import { eventBus } from "../event-bus";
import error_popup from "../resp_components/popups/error_popup.vue";
export default {
  name: "main-page",
  data() {
    return {
      selected: "Center",
      alignment: "",
      comment_popup: false,
      genAI_popup: false,
      classification_reasoning_popup: false,
      comments: ["comment1", "comment2"],
      header: "",
      newComment: "",
      newsList: [],
      latestNews: [],
      bookmarksList: [],
      ratingsList: [],
      pageNum: 0,
      loading: false,
      isWide: false,
      allNews: false,
      commentArticleId: 0,
      selectedArticle: undefined,
      generatedArticles: []
    };
  },
  components:{
    error_popup
  },
  computed: {
    columnClass() {
      return this.isWide ? "col-10" : "col-7";
    },
    newsWithBookmarks() {
      const filteredNews = this.newsList.filter((news) => {
        return (
          news.alignment !== null &&
          news?.alignment.toLowerCase() === this.selected.toLowerCase()
        );
      });
      const mappedArticles = filteredNews.map((article) => {
          const newsId = article.id;
          const correspondingNews = this.generatedArticles.filter((news) => news.id === newsId);
          return { ...article, correspondingNews };
      });
      if (Array.isArray(this.bookmarksList)) {
        return mappedArticles.map((news) => {
          const marked = this.bookmarksList.some(
            (bookmark) => bookmark.id === news.id
          );
          const ratingObj = this.ratingsList.find(
            (rating) => rating.newsArticle.id === news.id
          );
          const rating = ratingObj ? ratingObj.rating : 0;
          return { ...news, marked, rating };
        });
      } else return mappedArticles;
    },
  },
  async mounted() {
    await this.loadPosts();
    window.addEventListener("scroll", this.handleScroll);
    this.checkWindowSize();
    window.addEventListener("resize", this.checkWindowSize);
    const bookmarksResponse = await axiosInstance.get(`/user/bookmarks`);
    console.log(bookmarksResponse);
    const ratingsResponse = await axiosInstance.get(`/user/ratings`);
    console.log(ratingsResponse);
    this.bookmarksList = bookmarksResponse.data;
    this.ratingsList = ratingsResponse.data;
  },
  beforeDestroy() {
    window.removeEventListener("scroll", this.handleScroll);
    window.removeEventListener("resize", this.checkWindowSize);
  },
  methods: {
    checkWindowSize() {
      const windowWidth = window.innerWidth;
      this.isWide = windowWidth <= 768;
    },
    async loadPosts() {
      if (this.loading) return;

      this.loading = true;
      try {
        const resp = await noAuthAxiosInstance.get(
          `/news?pageNum=${this.pageNum}&pageSize=10`
        );
        if (resp.data.length <= 5) {
            this.latestNews = resp.data
        }
        else {
          this.latestNews = resp.data.slice(0, 5)
          this.newsList = resp.data.slice(5, resp.data.length + 1);
        }
        this.pageNum++;
      } finally {
        this.loading = false;
      }
    },
    async handleScroll() {
      if (
        window.scrollY + window.innerHeight >=
          document.body.scrollHeight - 50 &&
        !this.loading &&
        !this.allNews
      ) {
        this.loading = true;
        const resp = await noAuthAxiosInstance.get(
          `/news?pageNum=${this.pageNum}&pageSize=10`
        );
        if (resp.data.length === 0) {
          this.loading = false;
          this.allNews = true;
          return;
        }
        await new Promise((resolve) => setTimeout(resolve, 800));
        this.newsList = [...this.newsList, ...resp.data];
        this.pageNum++;
        this.loading = false;
      }
    },
    formatDate(dateInput, format = "DD.MM.YYYY") {
      return moment(dateInput).format(format);
    },
    set_alignment(tab_alignment) {
      this.alignment = tab_alignment;
      console.log(this.alignment);
    },
    setSelected(tab) {
      this.selected = tab;
    },
    showCommentPopup(id) {
      this.comment_popup = true;
      this.commentArticleId = id;
    },
    showGenAIPopup(id) {
      this.selectedArticle = this.newsList.find(news => news.id === id)
      this.genAI_popup = true;
    },
    showClassificationReasoningPopup(id) {
      this.selectedArticle = this.newsList.find(news => news.id === id)
      this.classification_reasoning_popup = true;
    },
    closePopup() {
      this.comment_popup = false;
      this.genAI_popup = false;
      this.classification_reasoning_popup = false;
      this.newComment = ""
      this.commentArticleId = 0
      this.selectedArticle = undefined
    },
    submitComment() {
      this.commentArticleId = "";
      this.comment_popup = false;
    },
    chooseSide(targetAlignment, articleId, generatedText) {
      this.generatedArticles.push({id:articleId, content:generatedText, newAlignment:targetAlignment})
    },

    async rateNews(id, e) {
      try {
        const resp = await axiosInstance.post(`/news/rate/${this.id}`, {
          rating: currStarId,
        });
        this.rate = currStarId;
      } catch (err) {
        eventBus.emit("api-error", "An unexpected error occurred. Please try again later.");
      }
    },
  },
};
</script>

<style scoped>
.adjustment {
  width: 75%;
  height: 60%;
  margin-top: 1vw;
  margin-left: 5.3vw;
}
@media screen and (max-width: 768px) {
  .adjustment {
    width: 90%;
    height: 60%;
    margin-top: 1vw;
    margin-left: -0.5vw;
  }
}

.h2-title {
  font-size: 15px;
}

.side-buttons {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
}

.side-btn {
  background-color: #11101d;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
  border-radius: 5px;
}

.side-btn:hover {
  background-color: #09090f;
}

.side-btn:focus {
  outline: none;
}

.add-comment-popup {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 9999;
  display: flex;
  justify-content: center;
  align-items: center;
}

.add-comment-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
}

.add-comment-popup-content {
  position: relative;
  width: 90%;
  max-width: 500px;
  background: #fff;
  padding: 25px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
}

.users-comment-to-post {
  margin-bottom: 15px;
}

.comment-input {
  width: 100%;
  height: 100px;
  resize: vertical;
  margin-bottom: 15px;
}

.add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.add-comment-submit-btn,
.add-comment-close-btn {
  background: transparent;
  color: #11101d;
  border: 2px solid #11101d;
  padding: 8px 16px;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s, border-color 0.3s;
}

.add-comment-submit-btn:hover,
.add-comment-close-btn:hover {
  background-color: #11101d;
  color: #fff;
}

@media screen and (max-width: 768px) {
  .add-comment-popup-content {
    padding: 15px;
  }
}

.name {
  font-size: 24px;
  font-weight: 600;
  margin-top: 16px;
  color: #11101d;
}

.name-list-element {
  font-size: 18px;
  font-weight: 800;
  margin-top: 10px;
  color: #11101d;
}

.Navbar-text {
  font-family: "Poppins", sans-serif;
  color: #fff;
  font-size: 1.2vw;
  text-align: center;
  font-weight: 400;
  padding-top: 1vw;
  padding-right: 7vw;
}

.stars {
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
  gap: 1vw;
  margin-top: 10vw;
  padding-right: 40vw;
  padding-left: -40vw;
}

.stars i {
  color: #e6e6e6;
  font-size: 2vw;
  cursor: pointer;
}

.icon-buttons {
  text-decoration: none;
  padding: 0.9vw 1.2vw;
  border: none;
  border-radius: 2vw;
  font-weight: 600;
  font-size: 0.9vw;
  background-color: #e0efff;
  margin-left: 3vw;
  margin-bottom: -3vw;
  color: #11101d;
}

.p-content {
  height: auto !important;
  font-size: "3vw";
  color: #11101d;
  line-height: 150%;
}

.name {
  font-size: 24px;
  font-weight: 600;
  margin-top: 16px;
  color: #11101d;
}

.card-details {
  padding: 1.5vw 1.5vw 2vw;
}

.tag {
  margin-top: 0.5vw;
  margin-left: 0.5vw;
  padding: 0.5vw 0.5vw;
  border: 0.2vw solid #e5eaed;
  border-radius: 1vw;
  font-size: 1vw;
  font-weight: 600;
  color: #11101d;
  width: auto;
  align-items: center;
}

.clicked1 {
  color: #a42323;
}

.star_clicked {
  color: #11101d;
  font-size: 30px;
  cursor: pointer;
}

.generate-ai-popup {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
}

.add-comment-popup {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
}

.generate-ai-popup .generate-ai-overlay {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  opacity: 1;
  transition: opacity 100ms ease-in-out 200ms;
}

.add-comment-popup .add-comment-overlay {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  opacity: 1;
  transition: opacity 100ms ease-in-out 200ms;
}

.generate-ai-popup .generate-ai-popup-content {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 95%;
  max-width: 450px;
  background: #fff;
  padding: 25px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
  transition: all 300ms ease-in-out;
}

.add-comment-popup .add-comment-popup-content {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 95%;
  max-width: 450px;
  background: #fff;
  padding: 25px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
  transition: all 300ms ease-in-out;
}

.generate-ai-popup .generate-ai-popup-content h2 {
  margin: 10px 0px;
  font-size: 25px;
  color: #11101d;
  text-align: center;
}

.add-comment-popup .add-comment-popup-content h2 {
  margin-top: 15px;
  margin-bottom: 60px;
  font-size: 25px;
  color: #11101d;
  text-align: center;
}

.generate-ai-popup .generate-ai-popup-content .generate-ai-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
}

.generate-ai-popup .generate-ai-popup-content .generate-ai-controls-close {
  display: flex;
  margin-left: 38%;
  margin-top: 20px;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-close {
  display: flex;
  margin-left: 38%;
  margin-top: 20px;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-versions
  button {
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 15px;
  border-radius: 20px;
  cursor: pointer;
}

.generate-ai-popup
  .generate-ai-popup-content
  .generate-ai-controls-close
  button {
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 15px;
  border-radius: 20px;
  cursor: pointer;
}

.generate-ai-popup
  .generate-ai-popup-content
  .generate-ai-controls-versions
  button {
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 15px;
  border-radius: 20px;
  cursor: pointer;
}

.generate-ai-popup
  .generate-ai-popup-content
  .generate-ai-controls-close
  .generate-ai-close-btn {
  background: transparent;
  color: #11101d;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-close
  .add-comment-close-btn {
  background: transparent;
  color: #11101d;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-versions
  .add-comment-submit-btn {
  background: #11101d;
  color: #fff;
}

.generate-ai-popup
  .generate-ai-popup-content
  .generate-ai-controls-versions
  .generate-ai-submit-btn {
  background: #11101d;
  color: #fff;
}

.popup.active {
  top: 0px;
  transition: top 0ms ease-in-out 0ms;
}

.popup.active .overlay {
  opacity: 1;
  transition: all 300ms ease-in-out;
}

.pop.active .popup-content {
  transform: translate(-50%, -50%) scale(1);
  opacity: 1;
}

.input-field {
  display: flex;
  flex-direction: column;
  position: relative;
}

.login-input {
  height: 45px;
  width: 100%;
  background: transparent;
  border: none;
  border-bottom: 1px solid rgba(0, 0, 0, 0.2);
  outline: none;
  margin-bottom: 40px;
  color: #40414a;
}

.input-field .login-label {
  position: absolute;
  top: 10px;
  left: 10px;
  pointer-events: none;
  transition: 0.5s;
}

.name-popup {
  font-size: 18px;
  font-weight: 600;
  margin-top: 12px;
  padding-bottom: 19px;
  color: #11101d;
  text-align: center;
}
</style>
