<template>
  <div class="feed-body">

      <feed-element v-for="newsArticle in news"
                    :id = "newsArticle?.id"
                    :content="newsArticle?.content"
                    :header="newsArticle?.title"
                    :date="formatDate(newsArticle?.publishDate)"
                    :source="newsArticle?.source"
                    :image="newsArticle?.img"
      />
      <div v-if="loading" class="d-flex justify-content-center m-4">
          <div class="spinner-border" role="status">
              <span class="visually-hidden">Loading...</span>
          </div>
      </div>
  </div>
</template>

<script>
import "./feed.css"
import FeedElement from "@/components/feed/Feed_element.vue";
import {noAuthAxiosInstance} from "../../utils";
import moment from "moment";


export default {
  name: "FeedPage",
  components: {
    FeedElement,
  },
  props: ['alignment'],
    data() {
        return {
            news: [],
            pageNum: 1,
            loading: false
        };
    },
    mounted() {
        this.loadPosts();
        window.addEventListener('scroll', this.handleScroll);
    },
    beforeDestroy() {
        window.removeEventListener('scroll', this.handleScroll);
    },
    methods: {
        async loadPosts() {
            if (this.loading) return;

            this.loading = true;
            try {
                const resp = await noAuthAxiosInstance.get(`/news?pageNum=${this.pageNum}&pageSize=10`)
                this.news = resp.data
                this.pageNum++;
            } finally {
                this.loading = false;
            }
        },
        async handleScroll() {
            if (window.scrollY + window.innerHeight >= document.body.scrollHeight - 50 && !this.loading) {
                this.loading = true
                const resp = await noAuthAxiosInstance.get(`/news?pageNum=${this.pageNum}&pageSize=10`)
                await new Promise(resolve => setTimeout(resolve, 800))
                this.news = [...this.news, ...resp.data]
                this.pageNum++;
                this.loading = false
            }
        },
        formatDate(dateInput, format = 'DD.MM.YYYY') {
            return moment(dateInput).format(format)
        },
    },
};
</script>
