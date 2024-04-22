<template>
  <div class="col-2 sidebar-body">
    <div
      class="row"
      style="background-color: #11101d; width: 100%; height: fit-content"
    >
      <div class="col-12" style="height: fit-content">
        <img class="img-fluid logo-padding" src="../../images/logo.png" />
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
            <i class="bx bx-grid-alt logo icon-size"></i>
            <router-link
              to="/"
              class="link-name displayment"
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
            <i class="bx bx-collection logo icon-size"></i>
            <span class="link-name displayment" style="text-decoration: none"
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
        v-if="is_user_logged_in"
        class="col-12"
        style="height: fit-content; list-style: none; text-decoration: none"
      >
        <a href="#" style="text-decoration: none">
          <i class="bx bx-user logo icon-size"></i>
          <router-link
            to="/profile-page"
            class="link-name displayment"
            style="text-decoration: none"
            >Profile</router-link
          >
        </a>
      </div>
      <div
        v-if="!is_user_premium"
        class="col-12"
        style="height: fit-content; list-style: none; text-decoration: none"
      >
        <Premium_option class="premium-option-displayment"></Premium_option>
      </div>
      <div
        v-if="!is_user_logged_in"
        class="col-12"
        style="height: fit-content; list-style: none; text-decoration: none"
      >
        <a href="#" style="text-decoration: none">
          <i class="bx bx-log-in logo icon-size"></i>
          <router-link
            to="/login-page"
            class="link-name displayment"
            style="text-decoration: none"
            >Login</router-link
          >
        </a>
      </div>
      <div
        v-if="is_user_logged_in"
        class="col-12"
        style="height: fit-content; list-style: none; text-decoration: none"
      >
        <a href="#" style="text-decoration: none">
          <i class="bx bx-log-out logo icon-size"></i>
          <router-link
            to="/login-page"
            class="link-name displayment"
            style="text-decoration: none"
            >Logout</router-link
          >
        </a>
      </div>
    </div>
  </div>
</template>

<script>
import "./Res_sidebar.css";
import "@coreui/coreui/dist/css/coreui.min.css";
import Premium_option from "./Premium_option.vue";
export default {
  components: {
    Premium_option,
  },
  data() {
    return {
      show: false,
      is_user_logged_in: this.$store.getters.isAuthorized,
      is_user_premium: false
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
