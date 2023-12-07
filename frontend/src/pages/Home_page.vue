<template>
    <div>
      <Navbar></Navbar>
      <Sidebar></Sidebar>
        <Tab_wrapper>
        <Feed_tabs title="Left" @click="set_alignment('left')"><Feed></Feed></Feed_tabs>
        <Feed_tabs title="Center" @click="set_alignment('center')" ><Feed></Feed></Feed_tabs>
        <Feed_tabs title="Right" @click="set_alignment('right')" ><Feed></Feed></Feed_tabs>
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
  name: "main-page",
  data() {
    return {
      alignment: ""
    };
  },
  methods:{
    set_alignment(tab_alignment) {
      this.alignment = tab_alignment
      console.log(this.alignment)
    },
  }
}
</script>