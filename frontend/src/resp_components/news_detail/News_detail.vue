<template>
  <div class="card" style="display: inline; height: fit-content">
    <img :src="newsArticle?.img" class="img-style" />
    <div class="card-details">
      <span class="date-source-main-page">Date: {{ formatDate(newsArticle?.publishDate) }}</span>
        &nbsp;
        <span class="date-source-main-page">Source: {{ newsArticle?.source }}</span>
        &nbsp;

        <span class="date-source-main-page">Alignment: {{ formatAlginment(newsArticle?.alignment) }}</span>
      <div class="header-main-page">{{ newsArticle?.title }}</div>
      <div>
        <p class="p-content-news-detail">{{ newsArticle?.content }}</p>
      </div>
      <div class="name-news-comment" v-if="comments.length > 0">Comments</div>
      <div class="comment-list">
        <ul class="comment-items">
          <li
            v-for="(comment, index) in comments"
            :key="index"
            class="comment-item"
          >
            <div class="username-comments"><i class="fa-solid fa-user i-profile-icon"></i> {{formatMail(comment?.userMail) }}:</div> {{ comment?.comment }}
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import {axiosInstance} from "@/utils";
import moment from "moment/moment";

export default {
  name: "news-detail-page",
  props: {
    id: Number,
  },
  data() {
      return {
          newsArticle : undefined,
          comments: []
      }
  },
  async mounted() {
      const resp = await axiosInstance.get(`news/${this.id}`)
      const commentsResp = await axiosInstance.get(`news/comments/${this.id}`)
      this.newsArticle = resp.data
      this.comments = commentsResp.data
      console.log(this.newsArticle)
  },
  methods: {
      formatDate(dateInput, format = 'DD.MM.YYYY') {
          return moment(dateInput).format(format)
      },
      formatMail(mail) {
          const index = mail.indexOf("@")
          return mail.substring(0, index)
      },
      formatAlginment(alignment) {
          if (alignment) {
            return alignment.charAt(0).toUpperCase() + alignment.slice(1).toLowerCase()

          }
      }
  }
};
</script>

<style>
.username-comments{
    font-family: 'Poppins', sans-serif;
    color: #11101d;
    font-weight: 500;
    font-size: 0.8vw;
}
.img-style {
  height: 20vw;
}
.p-content-news-detail {
  margin-top: 0px;
  height: auto !important;
  font-size: 0.9vw;
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
  font-size: 0.8vw;
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
  .username-comments{
    font-family: 'Poppins', sans-serif;
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

.comment-item {
  border-bottom: 1px solid #11101d;
  padding: 0.3vw;
  font-size: 1.6vw;
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
  background-color: #11101d; /* Change the color of the scrollbar thumb on hover */
}
</style>
