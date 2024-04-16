<template>
    <div>
      <Navbar></Navbar>
      <News_detail
      header= "Header"
      content= "New's content"
      date="06.10.2023"
      source="CNN News"></News_detail>
      <Top_news_list></Top_news_list>
    </div>
  </template>
  
  <script setup>
  import Top_news_list from "../components/newslist/Top_news_list.vue";
  import Navbar from "../components/navbar/Navbar.vue";
  import News_detail from "../components/news/News_detail.vue";
  </script>
  
<script>
export default {
  name: "news-detail-page",
}
</script>