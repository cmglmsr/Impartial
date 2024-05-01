<template>
  <div>
    <router-view :key="$route.fullPath"></router-view>
  </div>
</template>

<script setup>
import { RouterView, RouterLink } from "vue-router";
import Home_page from "./pages/Home_page.vue";
import Reg_page from "./pages/Reg_page.vue";
import News_detail_page from "./pages/News_detail_page.vue";
import Login_page from "./pages/Login_page.vue";
</script>

<script></script>
