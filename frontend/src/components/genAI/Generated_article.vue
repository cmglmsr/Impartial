<template>
  <div id="container-news">
    <body class="body1">
      <div class="card-news">
        <img src="../../images/news.jpg" alt="Breaking news" />
        <div class="card-details-news">
          <span class="tag-news">Date: {{ date }}</span>
          <span class="tag-news">Source: {{ source }}</span>
          <span class="tag-news">Previous version: {{ previous_version }}</span>
          <span class="tag-news">Generated version: {{ generated_version }}</span>
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
import "./generated.css";
import "primeicons/primeicons.css";
export default {
  name: "Generated_article",
  props: ["header", "content", "date", "source", "image", "previous_version", "generated_version"],
  data(){
    return{
        left: false,
        center: false,
        right: false
    }
  }
};
</script>
