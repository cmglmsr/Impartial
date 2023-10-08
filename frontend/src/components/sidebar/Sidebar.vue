<script setup>
import "./sidebar.css";
import Sidebar_section from "@/components/sidebar/Sidebar_section.vue";
import Premium_option from "./Premium_option.vue";
import { CIcon } from "@coreui/icons-vue";
import { cilAccountLogout } from "@coreui/icons";
import { CButton } from "@coreui/vue";
import "@coreui/coreui/dist/css/coreui.min.css";
</script>

<template>
  <div class="sidebar-body">
    <Sidebar_section icon="fa fa-home" label="Home" link="/home" />
    <Sidebar_section icon="fa fa-sort" label="Categories" link="/categories" />
    <Sidebar_section icon="fa fa-bookmark" label="Bookmarks" link="/home" />
    <Sidebar_section icon="fa fa-user" label="Profile" link="/home" />
    <div class="sidebar-premium-section">
      <Premium_option></Premium_option>
    </div>

      <CButton color="secondary" shape="rounded-pill" size="lg" class="logout-button"
        >Logout <CIcon :icon="cilAccountLogout" size="xl"
      /></CButton>

  </div>
</template>

<script>
export default {
  name: "Sidebar",
  components: ["Sidebar_section"],
};
</script>
