<template>
    <div>
      <Navbar></Navbar>
      <Sidebar></Sidebar>
        <Tab_wrapper>
        <Feed_tabs title="Bookmarks"><Bookmarked_posts_feed></Bookmarked_posts_feed></Feed_tabs>
        <Feed_tabs title="Likes"><Liked_posts_feed></Liked_posts_feed></Feed_tabs>
        <Feed_tabs title="Comments"><Commented_posts_feed></Commented_posts_feed></Feed_tabs>
      </Tab_wrapper>
      <Top_news_list></Top_news_list>
    </div>
  </template>
  
  <script setup>
  import Sidebar from "../components/sidebar/Sidebar.vue"
  import Top_news_list from "../components/newslist/Top_news_list.vue";
  import Feed from "../components/feed/Feed.vue";
  import Navbar from "../components/navbar/Navbar.vue";
  import Tab_wrapper from "../components/feed/Tab_wrapper.vue";
  import Feed_tabs from "../components/feed/Feed_tabs.vue"
  import Liked_posts_feed from "../components/feed/Liked_posts_feed.vue";
  import Bookmarked_posts_feed from "../components/feed/Bookmarked_posts_feed.vue";
  import Commented_posts_feed from "../components/feed/Commented_posts_feed.vue";
  </script>
  
<script>
export default {
  name: "profile-page"
}
</script>