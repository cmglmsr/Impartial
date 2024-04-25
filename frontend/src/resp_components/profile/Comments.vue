<template>
  <div class="card" style="display: inline; height: fit-content">
    <img :src="imageSrc" />
    <div class="card-details">
      <span class="date-source-main-page">Date: {{ date }}</span>
      <span class="date-source-main-page">Source: {{ source }}</span>
      <div class="header-main-page">{{ header }}</div>
      <p class="p-content-news-detail">{{ content }}</p>
      <div class="button-container">
        <button v-on:click="showMyComment" class="icon-buttons-comment-a">
          <i class="fa-regular fa-comment fa-l show-my-comment-button"></i> Show
          my comment
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    date: String,
    source: String,
    header: String,
    content: String,
    imageSrc: {
      type: String,
      default: "",
    },
  },
  methods: {
    showMyComment() {
      this.$emit("show-my-comment"); // Emit event to parent component
    },
  },
};
</script>

<style scoped>
.show-my-comment-button {
  font-size: 1vw;
}
.button-container {
  text-align: center;
}

.p-content-news-detail {
  margin-top: 0px;
  height: auto !important;
  font-size: 0.7vw;
  color: #11101d;
}

.date-source-main-page {
  font-size: 0.8vw;
  color: #09090f;
  font-weight: 500;
  margin-top: -12vw;
}

.header-main-page {
  font-size: 1.5vw;
  font-weight: 500;
  color: #11101d;
  margin-top: 0.4vw;
  margin-bottom: -1vw;
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

.name {
  font-size: 24px;
  font-weight: 600;
  margin-top: 16px;
  color: #11101d;
}

.p-content {
  height: auto !important;
  font-size: "3vw";
  color: #11101d;
  line-height: 150%;
}

.icon-buttons-comment-a {
  padding: 0.5vw;
  border: none;
  border-radius: 2vw;
  font-weight: 500;
  background-color: #bacdd8;
  font-size: 1vw;
}

@media screen and (max-width: 768px) {
  .show-my-comment-button {
    font-size: 1.5vw;
  }
  .icon-buttons-comment-a {
    padding: 0.5vw;
    border: none;
    border-radius: 2vw;
    font-weight: 500;
    background-color: #bacdd8;
    font-size: 1.5vw;
  }
  .bookmark-icon-size {
    font-size: 5vw;
  }
  .username-comments {
    font-family: "Poppins", sans-serif;
    color: #11101d;
    font-weight: 500;
    font-size: 1.5vw;
  }
  .name-news-comment {
    text-align: center;
    font-size: 2vw;
    font-weight: 600;
    color: #11101d;
    margin-bottom: 0.5vw;
  }
  .img-style {
    height: 25vw;
  }
  .card-details {
    padding: 1vw 1vw 0; /* Adjust padding to remove bottom padding */
  }

  .header-main-page {
    font-size: 1.5vw;
    font-weight: 500;
    color: #11101d;
    margin-top: 0.4vw;
    margin-bottom: -2vw;
  }

  .date-source-main-page {
    font-size: 1.5vw; /* Adjust font size if necessary */
  }

  .p-content-news-detail {
    height: auto !important;
    font-size: 1.5vw;
    color: #11101d;
  }

  .comment-items {
    list-style-type: none;
    padding: 0;
    font-size: 1.2vw;
    font-family: "Poppins", sans-serif;
  }
}
</style>
