<template>
  <div>
    <Navbar></Navbar>
    <div class="container-fluid">
      <div class="row no-shadow" style="width: 110%; height: 100%">
        <div class="col-2" style="display: inline">
          <Res_sidebar></Res_sidebar>
        </div>
        <div class="col-7" style="display: inline">
          <Tab_nav
            :tabs="['Left', 'Center', 'Right']"
            :selected="selected"
            @selected="setSelected"
          ></Tab_nav>
          <div v-if="selected === 'Left'">
            <div
              class="row no-shadow"
              style="width: 75%; height: 60%; margin-top: 1vw; margin-left: 4vw"
            >
              <div class="card" style="display: inline">
                <img src="../images/news.jpg" />
                <div class="card-details">
                  <span class="tag">Date: {{ date }}</span>
                  <span class="tag">Source: {{ source }}</span>
                  <div class="name">{{ header }}</div>
                  <p class="p-content">
                    {{ content }}
                  </p>
                  <router-link
                    class="icon-buttons"
                    :to="{ name: 'news-detail-page', params: { id: news_id } }"
                    >Read More</router-link
                  ><button v-on:click="bookmark()" class="icon-buttons">
                    <i
                      class="fa-regular fa-bookmark fa-xl"
                      :class="{ clicked2: bookmark_clicked }"
                    ></i></button
                  ><button v-on:click="show()" class="icon-buttons">
                    <i class="fa-regular fa-comment fa-xl"></i></button
                  ><button v-on:click="show2()" class="icon-buttons">
                    GenAI Option
                  </button>
                  <div class="stars">
                    <i
                      class="fa-solid fa-star"
                      :class="{ star_clicked: 1 <= this.rate }"
                      @click="rateNews(1)"
                    ></i>
                    <i
                      class="fa-solid fa-star"
                      :class="{ star_clicked: 2 <= this.rate }"
                      @click="rateNews(2)"
                    ></i>
                    <i
                      class="fa-solid fa-star"
                      :class="{ star_clicked: 3 <= this.rate }"
                      @click="rateNews(3)"
                    ></i>
                    <i
                      class="fa-solid fa-star"
                      :class="{ star_clicked: 4 <= this.rate }"
                      @click="rateNews(4)"
                    ></i>
                    <i
                      class="fa-solid fa-star"
                      :class="{ star_clicked: 5 <= this.rate }"
                      @click="rateNews(5)"
                    ></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-3" style="background-color: #11101d; display: inline">
          <div class="Navbar-text">Latest Headings</div>
          <div
            class="col-12 card"
            style="width: 60%; height: 20%; margin-top: 1vw"
          >
              <div class="name-list-element" style="font-size: 1vw;">Header</div>
              <div style="display: flex; justify-content: space-between;">
                <div class="name-list-element" style="text-align: left; font-size: 0.7vw">Date: </div>
                <div class="name-list-element" style="text-align: right; font-size: 0.7vw">Source: </div>
              </div>
              
            </div>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
import Sidebar from "../components/sidebar/Sidebar.vue";
import Tab_nav from "../components/deneme/Tab_nav.vue";
import Tab from "../components/deneme/Tab.vue";
import Navbar from "../components/navbar/Navbar.vue";
import Res_sidebar from "../components/sidebar/Res_sidebar.vue";
import deneme from "../components/deneme/Tab_nav.vue";
import Feed from "../components/feed/Feed.vue";
import "./feed.css";
import "primeicons/primeicons.css";
import { axiosInstance, noAuthAxiosInstance } from "@/utils";
export default {
  name: "main-page",
  data() {
    return {
      selected: "Center",
      alignment: "",
      news_id: 0,
      rate: null,
      heart_clicked: false,
      bookmark_clicked: false,
      star1_clicked_var: false,
      star2_clicked_var: false,
      star3_clicked_var: false,
      star4_clicked_var: false,
      star5_clicked_var: false,
      show_popup: false,
      show_popup2: false,
      comments: ["comment1", "comment2"],
    };
  },
  props: {
    id: Number,
    header: String,
    content: String,
    date: String,
    source: String,
    image: {
      type: String,
      default: "./news.jpg",
    },
  },
  methods: {
    set_alignment(tab_alignment) {
      this.alignment = tab_alignment;
      console.log(this.alignment);
    },
    setSelected(tab) {
      this.selected = tab;
    },
    generate_left_version: function () {
      this.$router.push({ path: "generated-article-page/0" });
    },
    generate_center_version: function () {
      this.$router.push({ path: "generated-article-page/0" });
    },
    generate_right_version: function () {
      this.$router.push({ path: "generated-article-page/0" });
    },
    submit: function () {
      //TODO: post the comment
      this.show_popup = !this.show_popup;
    },
    heart: function () {
      this.heart_clicked = !this.heart_clicked;
    },
    bookmark: async function () {
      try {
        if (!this.bookmark_clicked) {
          const resp = await axiosInstance.post(`news/bookmark/${this.id}`);
          console.log(resp);
        } else {
          const resp = await axiosInstance.delete(`news/bookmark/${this.id}`);
          console.log(resp);
        }
        this.bookmark_clicked = !this.bookmark_clicked;
      } catch (err) {
        console.log(err);
        //Todo
      }
    },
    async rateNews(currStarId) {
      try {
        const resp = await axiosInstance.post(`/news/rate/${this.id}`, {
          rating: currStarId,
        });
        this.rate = currStarId;
        console.log(resp);
      } catch (err) {
        //Todo
        console.log(err);
      }
    },
    show: function () {
      this.show_popup = !this.show_popup;
    },
    show2: function () {
      this.show_popup2 = !this.show_popup2;
    },
  },
  components: {Tab_nav, Tab, Navbar, Res_sidebar, deneme, Feed },
};
</script>

<style scoped>
.name-list-element{
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

.clicked2 {
  color: #4477cf;
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
