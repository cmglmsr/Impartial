<template>
  <div class="add-comment-popup" v-if="classificationReasoningPopup">
    <div class="add-comment-overlay" @click="closePopup"></div>
    <div class="add-comment-popup-content">
      <p class="reasoning">{{ reasoning }}</p>
      <div class="add-comment-controls-versions">
        <button class="add-comment-submit-btn" @click="closePopup">
          Close
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import {axiosInstance} from "@/utils";

export default {
  props: {
    article : Object,
    classificationReasoningPopup: Boolean,
  },
  data() {
    return {
       reasoning: ""
    }
  },
  async mounted() {
      const response = await axiosInstance.post(`/news/reasoning`, {
          "articleBody": this.article.content.replace(/[^\w\s.,!?]|[\r\n]/g, "").replace(/\n/g, " "),
          "currentAlignment":this.article.alignment,
      });
      this.reasoning = response.data
  },
  methods: {
    closePopup() {
      this.reasoning = ""
      this.$emit("close-popup");
    },
  },
};
</script>

<style scoped>
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
  top: 15%;
  position: relative;
  width: 90%;
  max-width: 500px;
  background: #fff;
  padding: 25px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
}

.h2-title {
  font-size: 15px;
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
  border-radius: 15px;
}

.add-comment-submit-btn:hover,
.add-comment-close-btn:hover {
  background-color: #11101d;
  color: #fff;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-versions
  .add-comment-submit-btn {
  background: #11101d;
  color: #fff;
}

@media screen and (max-width: 768px) {
    .reasoning{
        font-size: 2vw;
    }
  .add-comment-popup {
  box-sizing: border-box;
  width: 20%;
  height: 10%;
  z-index: 9999;
  display: flex;
  justify-content: center;
  align-items: center;
  top: 10%; /* Adjust this value to position the popup higher */
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
    top: -20%;
    left: 4%;
  position: relative;
  width: 50%;
  background: #fff;
  padding: 4vw;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
}

.h2-title {
  font-size: 4vw;
}

.comment-input {
  width: 100%;
  margin-left: 1vw;
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
  border: 0.5vw solid #11101d;
  padding: 1vw 2vw;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s, border-color 0.3s;
  border-radius: 2vw;
}

.add-comment-submit-btn:hover,
.add-comment-close-btn:hover {
  background-color: #11101d;
  color: #fff;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-versions
  .add-comment-submit-btn {
  background: #11101d; 
  color: #fff;
  font-size: 2vw;
}
}
</style>
