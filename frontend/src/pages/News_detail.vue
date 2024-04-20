<template>
    <div class="card" style="display: inline;">
              <img src="../images/news.jpg" />
              <div class="card-details">
                <span class="tag">Date: {{ date }}</span>
                <span class="tag">Source: {{ source }}</span>
                <div class="name">{{ header }}</div>
                <p class="p-content">
                  {{ content }}
                </p>
                <div class="name-news-comment">Comments</div>
              <div
                id="container-news-comment"
                style="
                  overflow-y: auto;
                  white-space: nowrap;
                  max-height: 13vw;
                  position: absolute;
                  bottom: 0;
                  left: 0;
                  right: 0;
                "
              >
                <ul class="comments-list">
                  <li
                    v-for="c in comments"
                    :key="c"
                    class="comments-list-element"
                  >
                    <div class="username-comments">
                      <i class="fa-solid fa-user i-profile-icon"></i> username:
                    </div>
                    {{ c }}
                  </li>
                </ul>
              </div>
              </div>
            </div>
  </template>
  

  <script>
  export default {
    name: "news-detail-page",
    data() {
      return {
        heart_clicked: false,
        bookmark_clicked: false,
        feedback_clicked: false,
        comments: [
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        ],
      };
    },
  };
  </script>
  
<style>
.username-comments {
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

.name-news-comment {
  text-align: center;
  font-size: 1vw;
  font-weight: 600;
  color: #11101d;
}

#container-news-comment {
  overflow-y: scroll;
  overflow-x: hidden;
  width: 43vw;
  height: 13vw;
}

  .p-content {
  height: auto !important;
  font-size: "3vw";
  color: #11101d;
  line-height: 150%;
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
  font-size: 0.8vw;
  font-weight: 600;
  color: #e5eaed;
  width: auto;
  align-items: center;
  }
  
  .name {
  font-size: 24px;
  font-weight: 600;
  margin-top: 16px;
  color: #11101d;
  }
  </style>