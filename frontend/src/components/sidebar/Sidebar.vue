<script setup>
import Sidebar_section from "@/components/sidebar/Sidebar_section.vue";
</script>

<template>
  <div class="sidebar">
    <Sidebar_section icon="fa fa-home" label="Home"/>
    <Sidebar_section icon="fa fa-sort" label="Categories"/>
    <Sidebar_section icon="fa fa-bookmark" label="Profile"/>
    <Sidebar_section icon="fa fa-user" label="Bookmarks"/>
  </div>
</template>

<script>
import '@/components/sidebar/sidebar.css'

export default {
  name: "Sidebar",
  components: ['Sidebar_section']
}
</script>
