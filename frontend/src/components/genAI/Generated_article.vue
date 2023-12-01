<template>
  <div id="generative-ai-container-news">
    <body class="generative-ai-body1">
      <div class="generative-ai-card-news">
        <img src="../../images/news.jpg" alt="Breaking news" />
        <div class="generative-ai-card-details-news">
          <span class="generative-ai-tag-news">Date: {{ date }}</span>
          <span class="generative-ai-tag-news">Source: {{ source }}</span>
          <span class="generative-ai-tag-news">Previous version: {{ previous_version }}</span>
          <span class="generative-ai-tag-news">Generated version: {{ generated_version }}</span>
          <div class="generative-ai-name-news">{{ header }}</div>
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
