<template>
    <div id="container-news">
      <body>
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
    };
  },
};
</script>
