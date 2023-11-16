<script setup>
import "./sidebar.css";
import "@coreui/coreui/dist/css/coreui.min.css";
import Premium_option from "./Premium_option.vue";
</script>

<template>
  <div>
    <div class="sidebar-body">
      <div class="logo-details">
        <i class="bx bxl-c-plus-plus"></i>
        <span class="logo-name">Impartial</span>
      </div>
      <ul class="nav-links">
        <li>
          <a href="#">
            <i class="bx bx-grid-alt"></i>
            <span class="link-name">Mainpage</span>
          </a>
        </li>
        <li>
          <div class="icon-link">
            <a href="#">
              <i class="bx bx-collection"></i>
              <span class="link-name">Categories</span>
            </a>
            <i class="bx bxs-chevron-down arrow" v-on:click="show_more_categories"></i>
          </div>
          <ul class="sub-menu blank" v-show="show">
            <li><a href="#">aaaaa</a></li>
            <li><a href="#">bbbbb</a></li>
            <li><a href="#">ccccc</a></li>
          </ul>
        </li>
        <li>
          <div class="icon-link">
            <a href="#">
              <i class="bx bx-bookmark"></i>
              <span class="link-name">Bookmarks</span>
            </a>
          </div>
        </li>
        <li>
          <div class="icon-link">
            <a href="#">
              <i class="bx bx-user"></i>
              <span class="link-name">Profile</span>
            </a>
          </div>
        </li>
        <div class="premium-section">
            <Premium_option></Premium_option>
        </div>
        <li>
          <div class="profile-details">
            <div class="profile-content">
              <img src="./profile.png" alt="profile" />
            </div>
            <div class="name">
              <div class="profile-name">Username</div>
            </div>
            <i class="bx bx-log-out"></i>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  components: {
  },
  data() {
    return {
      show: false
    };
  },
  methods: {
   show_more_categories(){
    console.log(this.show)
    this.show = !this.show
    console.log(this.show)
   }
  },
};
</script>

