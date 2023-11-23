<template>
    <div class="feed-body">
      <Bookmarked_posts_feed_element 
        header= "Header"
        content= "New's content"
        date="06.10.2023"
        source="CNN News"
      />
      <Bookmarked_posts_feed_element
        header= "Header"
        content= "New's content"
        date="06.10.2023"
        source="CNN News"
      />
    </div>
  </template>
  
  <script>
  import "./feed.css"
  import Bookmarked_posts_feed_element from "./Bookmarked_posts_feed_element.vue";
  import { noAuthAxiosInstance } from "../../utils";
  export default {
    name: "Bookmarked_Posts_Page",
    components: {
      Bookmarked_posts_feed_element,
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
  