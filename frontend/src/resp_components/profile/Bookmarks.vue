<template>
  <div class="card" style="display: inline; height: fit-content">
    <img :src="imageUrl" />
    <div class="card-details">
      <span class="date-source-main-page">Date: {{ date }}</span>
        &nbsp;
      <span class="date-source-main-page">Source: {{ source }}</span>
      <div class="header-main-page">{{ header }}</div>
      <div>
        <p class="p-content-news-detail">{{ content }}</p>
      </div>
      <div class="icon-container">
        <i class="fa-solid fa-bookmark fa-2xl i-like-icon bookmark-icon-size"></i>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "news-detail-page",
  props: {
    imageUrl: String,
    date: String,
    source: String,
    header: String,
    content: String,
    comments: Array,
  },
};
</script>

<style>
.icon-container {
  text-align: center;
  margin-left: 2.5vw;
}

.bookmark-icon-size {
  font-size: 2.5vw;
}
.username-comments {
  font-family: "Poppins", sans-serif;
  color: #11101d;
  font-weight: 500;
  font-size: 1vw;
}
.img-style {
  height: 20vw;
}
.p-content-news-detail {
  margin-top: 0px;
  height: auto !important;
  font-size: 0.7vw;
  color: #11101d;
}

.comment-list {
  max-height: 15vw;
  overflow-y: auto;
  margin-bottom: 0;
}

.comment-items {
  list-style-type: none;
  padding: 0;
  font-size: 0.7vw;
  font-family: "Poppins", sans-serif;
}

.comment-item {
  border-bottom: 1px solid #11101d;
  padding: 0.3vw;
}

.header-main-page {
  font-size: 1.5vw;
  font-weight: 500;
  color: #11101d;
  margin-top: 0.4vw;
  margin-bottom: -1vw;
}

.date-source-main-page {
  font-size: 0.8vw;
  color: #09090f;
  font-weight: 500;
  margin-top: -12vw;
}

.name-news-comment {
  text-align: center;
  font-size: 1.5vw;
  font-weight: 600;
  color: #11101d;
  margin-bottom: 0.5vw;
}

/*.username-comments {
  font-family: "Poppins", sans-serif;
  color: #11101d;
  font-weight: 600;
  font-size: 0.9vw;
}

.comments-list-element {
  font-size: 0.8vw;
}

.comments-list {
  margin-bottom: 2vw;
  text-align: left;
  align-items: center;
  list-style: none;
}

#container-news-comment {
  overflow-y: scroll;
  overflow-x: hidden;
  width: 43vw;
  height: 13vw;
}*/

.card-details {
  padding: 1.5vw 1.5vw 2vw;
}

@media screen and (max-width: 768px) {
  .icon-container {
  text-align: center;
  margin-left: 3.5vw;
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

.comment-list::-webkit-scrollbar {
  width: 8px; 
}

.comment-list::-webkit-scrollbar-thumb {
  background-color: #888; 
  border-radius: 4px; 
}

.comment-list::-webkit-scrollbar-thumb:hover {
  background-color: #11101d; 
}
</style>
