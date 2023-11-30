<template>
    <div>
      <Navbar></Navbar>
      <Sidebar></Sidebar>
      <Generated_article
      header= "Header"
      content= "New's content"
      date="06.10.2023"
      source="CNN News"
      previous_version = "Left"
      generated_version="Right"></Generated_article>
      <Top_news_list></Top_news_list>
    </div>
  </template>
  
  <script setup>
  import Sidebar from "../components/sidebar/Sidebar.vue"
  import Top_news_list from "../components/newslist/Top_news_list.vue";
  import Navbar from "../components/navbar/Navbar.vue";
  import Generated_article from "../components/genAI/Generated_article.vue";
  </script>
  
<script>
export default {
  name: "news-detail-page"
}
</script>