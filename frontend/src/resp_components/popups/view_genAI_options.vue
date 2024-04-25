<template>
  <div class="add-comment-popup" v-if="genAIPopup" @click.self="closePopup">
    <div class="add-comment-overlay"></div>
    <div class="add-comment-popup-content">
      <h2 class="h2-title">Please choose a side:</h2>
      <div class="add-comment-controls-versions">
        <button class="add-comment-submit-btn" @click="chooseSide('left')">
          Left
        </button>
        <button class="add-comment-submit-btn" @click="chooseSide('center')">
          Center
        </button>
        <button class="add-comment-submit-btn" @click="chooseSide('right')">
          Right
        </button>
      </div>
      <div
        class="add-comment-controls-versions"
        style="display: flex; justify-content: center"
      >
        <button class="add-comment-submit-btn" @click="closePopup">
          Close
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    genAIPopup: Boolean,
  },
  methods: {
    chooseSide() {
      this.closePopup();
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
  margin-top: 18px;
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
  top: -10%;
  left: 5%;
  position: relative;
  width: 60%;
  background: #fff;
  padding: 5vw;
  border-radius: 3vw;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
}

.h2-title {
  font-size: 3vw;
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
  border-radius: 15px;
  margin-top: 18px;
  font-size: 4vw;
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

