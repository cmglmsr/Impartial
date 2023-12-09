<template>
    <div class="feed-body">
      <Bookmarked_posts_feed_element v-for="bookmark in bookmarks"
        :header= "bookmark?.title"
        :content= "bookmark?.content"
        date="06.10.2023"
        source="CNN News"
      />

    </div>
  </template>
  
  <script>
  import "./feed.css"
  import Bookmarked_posts_feed_element from "./Bookmarked_posts_feed_element.vue";
  import {axiosInstance, noAuthAxiosInstance} from "../../utils";
  export default {
    name: "Bookmarked_Posts_Page",
    components: {
      Bookmarked_posts_feed_element,
    },
    data() {
      return {
        bookmarks: [],
      };
    },
    async created() {
        const newsResponse = await axiosInstance.get(`/user/bookmarks`);
        if (newsResponse.data) {
            this.bookmarks = newsResponse.data;
        }
  
      },
  };
  </script>
  