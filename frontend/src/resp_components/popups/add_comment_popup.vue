<template>
  <div class="add-comment-popup" v-if="comment_popup">
    <div class="add-comment-overlay" v-on:click="closePopup"></div>
    <div class="add-comment-popup-content">
      <h2 class="h2-title">Your comment to: {{ header }}</h2>
      <textarea
        v-model="newComment"
        class="comment-input"
        placeholder="Enter your comment"
      ></textarea>
      <div class="add-comment-controls-versions">
        <button class="add-comment-submit-btn" v-on:click="submitComment">
          Submit
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
const comment_popup = ref(false);
const newComment = ref("");
const header = ref("");
const closePopup = () => {
  comment_popup.value = false;
  newComment.value = "";
};

const submitComment = () => {
  closePopup();
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
</style>
