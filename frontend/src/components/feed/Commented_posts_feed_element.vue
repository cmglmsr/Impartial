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
            <button v-on:click="show()" class="icon-buttons-comment"> <i class="fa-regular fa-comment fa-xl"></i></button>
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

<style scope>
.i-like-icon{
    text-align: center;
    align-self: center;
    font-size: 50px;
}

.icon-buttons-comment{
    padding: 18px 18px;
    border: none;
    border-radius: 50px;
    font-weight: 600;
    background-color: #E0EFFF;
    margin-left: 46%;
    margin-bottom: -50%;
}
</style>
  
  