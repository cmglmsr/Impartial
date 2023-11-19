<template>
  <div id="container">
    <body>
      <div class="card">
        <img src="../../images/news.jpg" alt="Breaking news" />
        <div class="card-details">
          <span class="tag">Date: {{ date }}</span>
          <span class="tag">Source: {{ source }}</span>
          <div class="name">{{ header }}</div>
          <p>
            {{ content }}
          </p>
          <button>Read more</button>
        </div>
      </div>
    </body>
  </div>
</template>

<script>
import "./feed.css";
import "primeicons/primeicons.css";
export default {
  name: "Feed_element",
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

<style>
</style>
