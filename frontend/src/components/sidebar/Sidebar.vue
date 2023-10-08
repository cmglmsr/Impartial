<script setup>
import "@/components/sidebar/sidebar.css";
import Sidebar_section from "@/components/sidebar/Sidebar_section.vue";
import Premium from "./Premium_option.vue";
import { CIcon } from "@coreui/icons-vue";
import { cilAccountLogout } from "@coreui/icons";
import { CButton } from "@coreui/vue";
import "@coreui/coreui/dist/css/coreui.min.css";
</script>

<template>
  <div class="sidebar">
    <Sidebar_section icon="fa fa-home" label="Home" link="/home" />
    <Sidebar_section icon="fa fa-sort" label="Categories" link="/categories" />
    <Sidebar_section icon="fa fa-bookmark" label="Bookmarks" link="/home" />
    <Sidebar_section icon="fa fa-user" label="Profile" link="/home" />
    <div class="sidebar-premium-section">
      <Premium></Premium>
    </div>
    <div class="logout-button">
      <CButton color="secondary" shape="rounded-pill" size="lg"
        >Logout <CIcon :icon="cilAccountLogout" size="xl"
      /></CButton>
    </div>
  </div>
</template>

<script>
export default {
  name: "Sidebar",
  components: ["Sidebar_section"],
};
</script>
