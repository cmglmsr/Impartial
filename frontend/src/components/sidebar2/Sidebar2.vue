<template>
  <div class="col-2 sidebar-body">
    <div
      class="row"
      style="background-color: #11101d; width: 100%; height: fit-content"
    >
      <div class="col-12" style="height: fit-content">
        <img class="img-fluid" src="../../images/logo.png" />
      </div>
    </div>
    <div
      class="row"
      style="width: 100%; height: fit-content; background-color: #11101d"
    >
      <div
        class="col-12"
        style="height: fit-content; list-style: none; text-decoration: none"
      >
        <li>
          <a href="#" style="text-decoration: none">
            <i class="bx bx-grid-alt logo"></i>
            <router-link
              to="/main-page"
              class="link-name"
              style="text-decoration: none"
              >Mainpage</router-link
            >
          </a>
        </li>
      </div>
      <div
        class="col-12"
        style="height: fit-content; list-style: none; text-decoration: none"
      >
        <li v-on:click="show_more_categories">
          <a href="#" style="text-decoration: none">
            <i class="bx bx-collection logo"></i>
            <span class="link-name" style="text-decoration: none"
              >Categories</span
            >
          </a>
        </li>
      </div>
      <div
        class="col-12 sub-menu"
        style="height: fit-content; list-style: none"
        v-show="show"
      >
        <li><a href="#">Politics</a></li>
      </div>
      <div
        class="col-12"
        style="height: fit-content; list-style: none; text-decoration: none"
      >
          <a href="#" style="text-decoration: none">
            <i class="bx bx-user logo"></i>
            <router-link
              to="/profile-page"
              class="link-name"
              style="text-decoration: none"
              >Profile</router-link
            >
          </a>
      </div>
      <div
        class="col-12"
        style="height: fit-content; list-style: none; text-decoration: none"
      >
        <Premium_option></Premium_option>
      </div>
      <div
        class="col-12"
        style="
          height: fit-content;
          list-style: none;
          text-decoration: none;
          background: #1d1b31;
          width: fit-content;
          position: fixed;
          bottom: 0;
          padding: 1vw 0.5vw 1vw 0.6vw;
        "
      >
        <div style="color: #fff; font-weight: 500; font-size: 1vw; display: inline;">username</div>
        <router-link to="/" class="bx bx-log-out" style="display: inline; font-size: 1.2vw; color: #fff; font-weight: 400; list-style: none; text-decoration: none; padding-left: 7vw;"></router-link>
      </div>
    </div>
  </div>
</template>

<script>
import "./sidebar2.css";
import "@coreui/coreui/dist/css/coreui.min.css";
import Premium_option from "./Premium_option.vue";
export default {
  components: {
    Premium_option,
  },
  data() {
    return {
      show: false,
    };
  },
  methods: {
    show_more_categories() {
      this.show = !this.show;
      console.log("try");
    },
  },
};
</script>
