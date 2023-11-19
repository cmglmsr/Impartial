<template>
  <div class="feed-body">
    <Feed_element 
      header= "Header"
      content= "New's content"
      date="06.10.2023"
      source="CNN News"
    />
    <Feed_element
      header= "Header"
      content= "New's content"
      date="06.10.2023"
      source="CNN News"
    />
  </div>
</template>

<script>
import "./feed.css"
import Feed_element from "@/components/feed/Feed_element.vue";
import { noAuthAxiosInstance } from "../../utils";
export default {
  name: "FeedPage",
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
