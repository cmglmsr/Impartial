<template>
  <div class="add-comment-popup" v-if="show">
    <div class="add-comment-overlay">
      <div class="add-comment-popup-content">
        <h2 class="h2-title">Your comment to: {{ header }}</h2>
        <div class="users-comment-to-post">
          <i class="fa-solid fa-user i-profile-icon"></i> username:
        </div>
        {{ comment }}
        <div class="add-comment-controls-versions">
          <button class="add-comment-close-btn" @click="closePopup">
            Close
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    header: String,
    comment: String,
    show: Boolean,
  },
  methods:{
    closePopup() {
      this.$emit("close-popup");
    },
  }
};
</script>

<style scoped>
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

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-close
  .add-comment-close-btn {
  background: transparent;
  color: #11101d;
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

.add-comment-popup .add-comment-popup-content h2 {
  margin-top: 15px;
  margin-bottom: 60px;
  font-size: 25px;
  color: #11101d;
  text-align: center;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
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

.h2-title {
  font-size: 15px;
}

.users-comment-to-post {
  font-family: "Poppins", sans-serif;
  color: #11101d;
  font-weight: 600;
  font-size: 18px;
  margin-bottom: 50px;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
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

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-versions
  .add-comment-submit-btn {
  background: #11101d;
  color: #fff;
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
  .add-comment-controls-close
  .add-comment-close-btn {
  background: transparent;
  color: #11101d;
}

@media screen and (max-width: 768px) {
  .add-comment-popup {
  box-sizing: border-box;
  position: fixed;
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
  transform: translate(-50%, -50%);
  width: 95%;
  background: #fff;
  padding: 5px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
  transition: all 300ms ease-in-out;
  position: fixed;
  z-index: 9999;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-close
  .add-comment-close-btn {
  background: transparent;
  color: #11101d;
}

.add-comment-popup .add-comment-popup-content {
  position: absolute;
  top: 40%;
  left: 55%;
  transform: translate(-50%, -50%);
  width: 60%;
  max-width: 450px;
  background: #fff;
  padding: 3vw;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
  transition: all 300ms ease-in-out;
}

.add-comment-popup .add-comment-popup-content h2 {
  margin-top: 15px;
  margin-bottom: 60px;
  font-size: 3vw;
  color: #11101d;
  text-align: center;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-versions
  button {
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 2vw;
  border-radius: 20px;
  cursor: pointer;
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

.h2-title {
  font-size: 3vw;
}

.users-comment-to-post {
  font-family: "Poppins", sans-serif;
  color: #11101d;
  font-weight: 600;
  font-size: 3vw;
  margin-bottom: 50px;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
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

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-versions
  .add-comment-submit-btn {
  background: #11101d;
  color: #fff;
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
  .add-comment-controls-close
  .add-comment-close-btn {
  background: transparent;
  color: #11101d;
}
}
</style>
