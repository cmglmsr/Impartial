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
            <i class="fa-solid fa-heart fa-2xl i-like-icon" style="color: #900932;"></i>
          </div>
        </div>
      </body>
    </div>
  </template>
  
  <script>
  import "./feed.css";
  import "primeicons/primeicons.css";
  export default {
    name: "Liked_Posts_Feed_element",
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

<style scope>
.i-like-icon{
    text-align: center;
    align-self: center;
    margin-left: 45%;
    margin-bottom: 7%;
    font-size: 50px;
}
</style>
  
  