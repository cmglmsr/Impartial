<template>
  <div class="add-comment-popup" v-if="commentPopup">
    <div class="add-comment-overlay" @click="closePopup"></div>
    <div class="add-comment-popup-content">
      <h2 class="h2-title">Your comment to: {{ header }}</h2>
      <textarea v-model="newComment" class="comment-input" placeholder="Enter your comment"></textarea>
      <div class="add-comment-controls-versions">
        <button class="add-comment-submit-btn" @click="submitComment">Submit</button>
        <button class="add-comment-submit-btn" @click="closePopup">Close</button>
      </div>
    </div>
    <error_popup></error_popup>
  </div>
</template>

<script>
import {axiosInstance} from "@/utils";
import { eventBus } from "../../event-bus";
import error_popup from "../../resp_components/popups/error_popup.vue";
export default {
  props: {
    header: String,
    commentPopup: Boolean,
    id: Number
  },
  components:{
    error_popup
  },
  data() {
    return {
      newComment: "",
    };
  },
  methods: {
    async submitComment() {
        try {
          const resp = await axiosInstance.post(`/news/comment/${this.id}`, {
              "comment": this.newComment
          })
          this.newComment = ""
          this.$emit("close-popup");

        } catch (e) {
          eventBus.emit("api-error", "An unexpected error occurred. Please try again later.");
        }

    },
    closePopup() {
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
  top: -15%;
  left: 5%;
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
}
}
</style>
