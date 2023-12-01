<template>
  <div>
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
            <button
              v-on:click="show_my_comment()"
              class="icon-buttons-comment-a"
            >
              <i class="fa-regular fa-comment fa-xl"></i> Show my comment
            </button>
          </div>
        </div>
      </body>
    </div>
    <div class="add-comment-popup" v-if="show">
      <div class="add-comment-overlay">
        <div class="add-comment-popup-content">
          <h2 class="h2-title">Your comment to: {{ header }}</h2>
          <div class="users-comment-to-post"><i class="fa-solid fa-user i-profile-icon"></i> username: </div>{{ comment }}
          <div class="add-comment-controls-versions">
            <button
              class="add-comment-close-btn"
              v-on:click="show_my_comment()"
            >
              Close
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import "./feed.css";
import "primeicons/primeicons.css";
export default {
  name: "Feed_element",
  props: ["header", "content", "date", "source", "image"],
  data() {
    return {
      show: false,
    };
  },
  methods: {
    show_my_comment: function(){
      this.show = !this.show;
    }
  },
};
</script>

<style scope>
.h2-title{
  font-size: 15px;
}
.users-comment-to-post{
    font-family: 'Poppins', sans-serif;
    color: #11101d;
    font-weight: 600;
    font-size: 18px;
    margin-bottom: 50px;
}

.i-like-icon {
  text-align: center;
  align-self: center;
  font-size: 50px;
}

.icon-buttons-comment-a {
  padding: 10px;
  border: none;
  border-radius: 50px;
  font-weight: 600;
  background-color: #bacdd8;
  margin-bottom: -55%;
  margin-left: 36%;
}

.add-comment-popup {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  position: fixed;
  z-index: 9999;
}


.add-comment-popup .add-comment-overlay {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  opacity: 1;
  transition: opacity 100ms ease-in-out 200ms;
  position: fixed;
  z-index: 9999;
}

.add-comment-popup .add-comment-popup-content {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 95%;
  max-width: 650px;
  background: #fff;
  padding: 25px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
  transition: all 300ms ease-in-out;
  position: fixed;
  z-index: 9999;
}

.generate-ai-popup .generate-ai-popup-content h2 {
  margin: 10px 0px;
  font-size: 25px;
  color: #11101d;
  text-align: center;
}

.add-comment-popup .add-comment-popup-content h2 {
  margin-top: 15px;
  margin-bottom: 60px;
  font-size: 25px;
  color: #11101d;
  text-align: center;
}

.generate-ai-popup .generate-ai-popup-content .generate-ai-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
}

.generate-ai-popup .generate-ai-popup-content .generate-ai-controls-close {
  display: flex;
  margin-left: 38%;
  margin-top: 20px;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-close {
  display: flex;
  margin-left: 38%;
  margin-top: 20px;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-versions
  button {
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 15px;
  border-radius: 20px;
  cursor: pointer;
}

.generate-ai-popup
  .generate-ai-popup-content
  .generate-ai-controls-close
  button {
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 15px;
  border-radius: 20px;
  cursor: pointer;
}

.generate-ai-popup
  .generate-ai-popup-content
  .generate-ai-controls-versions
  button {
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 15px;
  border-radius: 20px;
  cursor: pointer;
}

.generate-ai-popup
  .generate-ai-popup-content
  .generate-ai-controls-close
  .generate-ai-close-btn {
  background: transparent;
  color: #11101d;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-close
  .add-comment-close-btn {
  background: transparent;
  color: #11101d;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-versions
  .add-comment-submit-btn {
  background: #11101d;
  color: #fff;
}

.generate-ai-popup
  .generate-ai-popup-content
  .generate-ai-controls-versions
  .generate-ai-submit-btn {
  background: #11101d;
  color: #fff;
}

.popup.active {
  top: 0px;
  transition: top 0ms ease-in-out 0ms;
}

.popup.active .overlay {
  opacity: 1;
  transition: all 300ms ease-in-out;
}

.pop.active .popup-content {
  transform: translate(-50%, -50%) scale(1);
  opacity: 1;
}

.input-field {
  display: flex;
  flex-direction: column;
  position: relative;
}

.login-input {
  height: 45px;
  width: 100%;
  background: transparent;
  border: none;
  border-bottom: 1px solid rgba(0, 0, 0, 0.2);
  outline: none;
  margin-bottom: 40px;
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
