<template>
    <div>
      <Navbar></Navbar>
      <Sidebar></Sidebar>
        <Tab_wrapper>
        <Feed_tabs title="Left"><Feed></Feed></Feed_tabs>
        <Feed_tabs title="Center"><Feed></Feed></Feed_tabs>
        <Feed_tabs title="Right"><Feed></Feed></Feed_tabs>
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
  </script>
  
<script>
export default {
  name: "Home_page"
}
</script>