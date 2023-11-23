<template>
  <div id="container">
    <body>
      <div class="card">
        <img src="../../images/news.jpg" alt="Breaking news" />
        <div class="card-details">
          <span class="tag">Date: {{ date }}</span>
          <span class="tag">Source: {{ source }}</span>
          <div class="name">{{ header }}</div>
          <p>
            {{ content }}
          </p>
          <button class="icon-buttons">Read More</button
          ><button class="icon-buttons">
            <i class="fa-regular fa-heart fa-xl"></i></button
          ><button class="icon-buttons">
            <i class="fa-regular fa-bookmark fa-xl"></i></button
          ><button v-on:click="show()" class="icon-buttons">
            <i class="fa-regular fa-comment fa-xl"></i></button
          ><button v-on:click="show2()" class="icon-buttons">
            GenAI Option
          </button>
          <div class="popup" v-if="show_popup">
            <div class="popup-inner">
              <div class="name-popup">Add your comment to {{ header }}</div>
              <div class="input-field">
                <input
                  type="text"
                  class="login-input"
                  id="email"
                  required
                  autocomplete="off"
                />
                <label for="email" class="login-label"
                  >Enter your comment...</label
                >
              </div>
              <button class="icon-buttons-close" v-on:click="show()">
                <i class="fa-solid fa-xmark fa-lg"></i>
              </button>
            </div>
          </div>
          <div class="popup" v-if="show_popup2">
            <div class="popup-inner">
              <button class="icon-buttons-popup">Left version</button>
              <button class="icon-buttons-popup">Center version</button>
              <button class="icon-buttons-popup">Right version</button>
              <button class="icon-buttons-close2" v-on:click="show2()">
                <i class="fa-solid fa-xmark fa-lg"></i>
              </button>
            </div>
          </div>
        </div>
      </div>
    </body>
  </div>
</template>

<script>
import "./feed.css";
import Comments_popup from "./Comments_popup.vue";
import "primeicons/primeicons.css";
export default {
  name: "Feed_element",
  props: ["header", "content", "date", "source", "image"],
  data() {
    return {
      heart_clicked: false,
      bookmark_clicked: false,
      feedback_clicked: false,
      show_popup: false,
      show_popup2: false,
      comments: ["comment1", "comment2"]
    };
  },
  components: {
    Comments_popup,
  },
  methods: {
    show: function () {
      this.show_popup = !this.show_popup;
    },
    show2: function () {
      this.show_popup2 = !this.show_popup2;
    },
  },
};
</script>

<style scoped>
.popup {
  padding: 400px;
  position: fixed;
  background-color: rgba(0, 0, 0, 0.2);
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 100%;
}

.popup .popup-inner {
  background: #fff;
  padding: 32px;
}

.input-field {
  display: flex;
  flex-direction: column;
  position: relative;
  padding: 0 10px 0 10px;
}

.login-input {
  height: 45px;
  width: 100%;
  background: transparent;
  border: none;
  border-bottom: 1px solid rgba(0, 0, 0, 0.2);
  outline: none;
  margin-bottom: 20px;
  color: #40414a;
}

.input-field .login-label {
  position: absolute;
  top: 10px;
  left: 10px;
  pointer-events: none;
  transition: 0.5s;
}

.name-popup {
  font-size: 18px;
  font-weight: 600;
  margin-top: 12px;
  padding-bottom: 19px;
  color: #11101d;
  text-align: center;
}
</style>
