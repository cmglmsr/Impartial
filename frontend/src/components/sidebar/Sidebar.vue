<script setup>
import '@/components/sidebar/sidebar.css'
import Sidebar_section from "@/components/sidebar/Sidebar_section.vue";
</script>

<template>
  <div class="sidebar">
    <Sidebar_section icon="fa fa-home" label="Home" link="/home"/>
    <Sidebar_section icon="fa fa-sort" label="Categories" link="/categories"/>
    <Sidebar_section icon="fa fa-bookmark" label="Bookmarks" link="/home"/>
    <Sidebar_section icon="fa fa-user" label="Profile" link="/home"/>
  </div>
</template>

<script>

export default {
  name: "Sidebar",
  components: ['Sidebar_section']
}
</script>
