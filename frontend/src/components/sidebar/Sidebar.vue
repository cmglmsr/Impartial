<script setup>
import "./sidebar.css";
import "@coreui/coreui/dist/css/coreui.min.css";
import Premium_option from "../sidebar2/Premium_option.vue";
</script>
<template>
  <div>
    <div class="col-2 sidebar-body">
      <div class="logo-details">
        <span class="logo-name"><img src="../../images/logo.png" style="max-width: 80%; height: auto; margin-top: 20%; margin-right: 100%; margin-left: -10%;"></span>
      </div>
      <ul class="nav-links">
        <li>
          <a href="#">
            <i class="bx bx-grid-alt logo"></i>
            <router-link to="/main-page" class="link-name logo">Mainpage</router-link>
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
              <i class="bx bx-user"></i>
              <router-link to="/profile-page" class="link-name">Profile</router-link>
            </a>
          </div>
        </li>
        <div style="align-self: center; margin-top: 45%;">
            <Premium_option style="margin-left: 0%;"></Premium_option>
        </div>
        <li>
          <div class="profile-details">
            <div class="name">
              <div class="profile-name">username</div>
            </div>
            <router-link to="/" class="bx bx-log-out log-out-button"></router-link>
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
    this.show = !this.show
   }
  },
};
</script>

