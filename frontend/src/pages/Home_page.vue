<template>
  <div>
    <Navbar></Navbar>
    <div class="container-fluid">
      
      <div class="row" style="width: 100%; height: 100%;">
        <div class="col-2" style="background-color: brown; display: inline;"><Sidebar2></Sidebar2></div>
        <div class="col-5" style="background-color: blue; display: inline;">2</div>
        <div class="col-5" style="background-color:black; display: inline;">3</div>
      </div>
      
    </div>
  </div>
</template>

<script setup>
import Sidebar from "../components/sidebar/Sidebar.vue";
import Top_news_list from "../components/newslist/Top_news_list.vue";
import Feed from "../components/feed/Feed.vue";
import Navbar from "../components/navbar/Navbar.vue";
import Tab_wrapper from "../components/feed/Tab_wrapper.vue";
import Feed_tabs from "../components/feed/Feed_tabs.vue";
import Sidebar2 from "../components/sidebar2/Sidebar2.vue";
</script>

<script>
export default {
  name: "main-page",
  data() {
    return {
      alignment: "",
    };
  },
  methods: {
    set_alignment(tab_alignment) {
      this.alignment = tab_alignment;
      console.log(this.alignment);
    },
  },
};
</script>
