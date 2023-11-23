<script setup>
import "./sidebar.css";
import "@coreui/coreui/dist/css/coreui.min.css";
import Premium_option from "./Premium_option.vue";
</script>

<template>
  <div>
    <div class="sidebar-body">
      <div class="logo-details">
        <span class="logo-name"><img src="../../images/logo.jpg" style="max-width: 40%; height: auto; margin-right: 50%; margin-top: 20%;"></span>
      </div>
      <ul class="nav-links">
        <li>
          <a href="#">
            <i class="bx bx-grid-alt logo"></i>
            <span class="link-name logo">Mainpage</span>
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
            <li><a href="#">Politics</a></li>
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
        <div style="align-self: center;">
            <Premium_option style="margin-left: 0%;"></Premium_option>
        </div>
        <li>
          <div class="profile-details">
            <div class="profile-content">
              <img src="./profile.png" alt="profile" />
            </div>
            <div class="name">
              <div class="profile-name">Email address</div>
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

