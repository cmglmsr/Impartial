<template>
  <div class="add-comment-popup" v-if="show">
    <div class="add-comment-overlay"></div>
    <div class="add-comment-popup-content">
      <div
        v-if="!this.loading"
        class="add-comment-controls-versions"
        style="max-height: 80vh; overflow-y: auto"
      >
        <p class="reasoning" style="font-size: 1.1vw; text-align: center">
          {{ errorMessage }}
        </p>
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
import { ref } from "vue";
import { eventBus } from "../../event-bus";

export default {
  setup() {
    const show = ref(false);
    const errorMessage = ref("");

    const closePopup = () => {
      show.value = false;
    };

    eventBus.on("api-error", (message) => {
      errorMessage.value = message;
      show.value = true;
    });

    return {
      show,
      errorMessage,
      closePopup,
    };
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
  top: 13%;
  bottom: 3%;
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
  .reasoning {
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
.overlay {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
}

.modal {
  background: white;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
  width: 500px;
  max-width: 80%;
}

.modal-header h3 {
  margin: 0;
}

.modal-body {
  margin: 20px 0;
}

.modal-footer {
  text-align: right;
}

.modal-footer button {
  padding: 6px 12px;
  background-color: #3498db;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>
