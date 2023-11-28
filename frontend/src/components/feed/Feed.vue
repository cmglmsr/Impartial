<template>
  <div class="feed-body">
      <Feed_element v-for="newsArticle in news"
                    :content="newsArticle?.content"
                    :header="newsArticle?.title"
                    date="06.10.2023"
                    source="CNN News"
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
import Feed_element from "@/components/feed/Feed_element.vue";
import {noAuthAxiosInstance} from "../../utils";
import axios from "axios";

export default {
  name: "FeedPage",
  components: {
    Feed_element,
  },
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
                const resp = await noAuthAxiosInstance(`/news?pageNum=${this.pageNum}&pageSize=10`)
                this.news = resp.data
                this.pageNum++;
            } finally {
                this.loading = false;
            }
        },
        async handleScroll() {

            if (window.scrollY + window.innerHeight >= document.body.scrollHeight - 50 && !this.loading) {
                this.loading = true
                const resp = await noAuthAxiosInstance(`/news?pageNum=${this.pageNum}&pageSize=10`)
                await new Promise(resolve => setTimeout(resolve, 3000))
                this.news = [...this.news, ...resp.data]
                this.pageNum++;
                this.loading = false
            }
        },
    },
};
</script>
