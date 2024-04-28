<template>
  <div class="card" style="display: inline; height: fit-content;">
    <img :src="imageUrl" />
    <div class="card-details">
      <span class="date-source-main-page">Date: {{ date }}</span>
      &nbsp;
      <span class="date-source-main-page">Source: {{ source }}</span>
      <div class="header-main-page">{{ header }}</div>
      <carousel
        :content=content
        :news-id=newsId
        :isBookmarked=isBookmarked
        :ratingValue=rate
        generated_article_header="Generated article header"
        generated_article_content="Generated article content"
        previous_version="Center"
        generated_version="Left"
        @show-comment-popup="showCommentPopup(0)"
        @show-genAI-popup="showGenAIPopup(0)"
        @show-classification-reasoning-popup="showClassificationReasoningPopup(0)"
      ></carousel>
    </div>
  </div>
</template>

<script>
import carousel from "../slider/carousel.vue";
import { axiosInstance } from "@/utils";
export default {
  components: {
    carousel,
  },
  props: {
    imageUrl: String,
    date: String,
    source: String,
    header: String,
    content: String,
    newsId: Number,
    rate: Number,
    isBookmarked: Boolean
  },
  data() {
    return {
    };
  },
  methods: {
    showCommentPopup(id) {
      this.$emit("show-comment-popup");
    },
    showGenAIPopup(id) {
      this.$emit("show-genAI-popup");
    },
    showClassificationReasoningPopup(id){
      this.$emit("show-classification-reasoning-popup");
    },
  },
};
</script>

<style scoped>
@media screen and (max-width: 768px) {
  .card img {
    height: 20vw; /* Adjust height for smaller screens */
  }
}

@media screen and (min-width: 769px) {
  .card img {
    height: 15vw; /* Adjust height for larger screens */
  }
}

.date-source-main-page {
  font-size: 0.8vw;
  color: #09090f;
  font-weight: 500;
  margin-top: -12vw;
}
.h2-title {
  font-size: 15px;
}

.side-buttons {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
}

.side-btn {
  background-color: #11101d;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
  border-radius: 5px;
}

.side-btn:hover {
  background-color: #09090f;
}

.side-btn:focus {
  outline: none;
}

.add-comment-popup {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 9999;
  display: flex;
  justify-content: center;
  align-items: center;
}

.add-comment-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
}

.add-comment-popup-content {
  position: relative;
  width: 90%;
  max-width: 500px;
  background: #fff;
  padding: 25px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
}

.users-comment-to-post {
  margin-bottom: 15px;
}

.comment-input {
  width: 100%;
  height: 100px;
  resize: vertical;
  margin-bottom: 15px;
}

.add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.add-comment-submit-btn,
.add-comment-close-btn {
  background: transparent;
  color: #11101d;
  border: 2px solid #11101d;
  padding: 8px 16px;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s, border-color 0.3s;
}

.add-comment-submit-btn:hover,
.add-comment-close-btn:hover {
  background-color: #11101d;
  color: #fff;
}

@media screen and (max-width: 768px) {
  .add-comment-popup-content {
    padding: 15px;
  }
}

.header-main-page {
  font-size: 1.5vw;
  font-weight: 500;
  color: #11101d;
  margin-top: 0.4vw;
}

.name-list-element {
  font-size: 18px;
  font-weight: 800;
  margin-top: 10px;
  color: #11101d;
}

.Navbar-text {
  font-family: "Poppins", sans-serif;
  color: #fff;
  font-size: 1.2vw;
  text-align: center;
  font-weight: 400;
  padding-top: 1vw;
  padding-right: 7vw;
}

.stars {
  display: flex;
  justify-content: center; /* Align items horizontally at the center */
  align-items: center; /* Align items vertically at the center */
  text-align: center; /* Center the content within the container */
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
  width: 100%; /* Ensure the container spans the entire width */
}

.stars i {
  color: #e6e6e6;
  font-size: 2vw;
  cursor: pointer;
}

.icon-buttons-main-page {
  text-decoration: none;
  padding: 0.9vw 1.2vw;
  border: none;
  border-radius: 2vw;
  font-weight: 600;
  font-size: 0.9vw;
  background-color: #e0efff;
  color: #11101d;
  margin-top: -100vw;
}

.p-content {
  height: auto !important;
  font-size: "3vw";
  color: #11101d;
  line-height: 150%;
}

.name {
  font-size: 24px;
  font-weight: 600;
  margin-top: 16px;
  color: #11101d;
}

.card-details {
  padding: 1.5vw 1.5vw 2vw;
}

.tag {
  margin-top: 0.5vw;
  margin-left: 0.5vw;
  padding: 0.5vw 0.5vw;
  border: 0.2vw solid #e5eaed;
  border-radius: 1vw;
  font-size: 1vw;
  font-weight: 600;
  color: #11101d;
  width: auto;
  align-items: center;
}

.clicked1 {
  color: #a42323;
}


.clicked2 {
  color: #4477cf;
}
.star_clicked {
  color: #11101d;
  font-size: 30px;
  cursor: pointer;
}

.generate-ai-popup {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
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
}

.generate-ai-popup .generate-ai-overlay {
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
}

.generate-ai-popup .generate-ai-popup-content {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 95%;
  max-width: 450px;
  background: #fff;
  padding: 25px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
  transition: all 300ms ease-in-out;
}

.add-comment-popup .add-comment-popup-content {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 95%;
  max-width: 450px;
  background: #fff;
  padding: 25px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
  transition: all 300ms ease-in-out;
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

@media screen and (max-width: 768px) {
  .card-details {
    padding: 1vw; /* Adjust padding as needed */
  }

  .header-main-page {
    padding-top: 15px;
    font-size: 2vw; /* Adjust font size if necessary */
  }

  .date-source-main-page {
    font-size: 1vw; /* Adjust font size if necessary */
  }
}
</style>
