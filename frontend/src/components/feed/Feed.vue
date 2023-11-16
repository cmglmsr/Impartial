<template>
  <div class="feed-body">
    <Feed_element v-for="newsArticle in news"
      :header= "newsArticle.title"
      :content= "newsArticle.description"
      date="06.10.2023"
      source="CNN News"
    />

  </div>
</template>

<style scoped>
.feed-body {
  position: absolute;
  margin-left: 30%;
}
</style>

<script>
import Feed_element from "@/components/feed/Feed_element.vue";
import { noAuthAxiosInstance } from "../../utils";
export default {
  name: "ClosedProjectsPage",
  components: {
    Feed_element,
  },
  data() {
    return {
      news: [],
    };
  },
  async created() {
      const newsResponse = await noAuthAxiosInstance.get(`/news`);
      /*if (newsRespond.data.data) {
        this.news = newsRespond.data.data;
      }*/
      this.news = newsResponse.data.slice(0,10)

    },
};
</script>
