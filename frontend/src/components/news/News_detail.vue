<template>
  <div id="container-news">
    <body class="body1">
      <div class="card-news">
        <img src="../../images/news.jpg" alt="Breaking news" />
        <div class="card-details-news">
          <span class="tag-news">Date: {{ date }}</span>
          <span class="tag-news">Source: {{ source }}</span>
          <div class="name-news">{{ header }}</div>
          <p>
            {{ content }}
          </p>
        </div>
        <div class="name-news-comment">Comments</div>
          <div id="container-news-comment">
            <body class="body2">
              <div></div>
              <div class="card-news-comment">
                <ul class="comments-list">
                  <li v-for="c in comments" :key="c">
                    <i class="fa-regular fa-user i-profile-icon"></i>username: {{ c }}
                  </li>
                </ul>
              </div>
            </body>
          </div>
        </div>
    </body>
  </div>
</template>

<script>
import "./news.css";
import "primeicons/primeicons.css";
export default {
  name: "News_element",
  props: ["header", "content", "date", "source", "image"],
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
      ],
    };
  },
};
</script>
