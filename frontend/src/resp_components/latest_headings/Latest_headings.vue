<template>
  <div>
    <div class="Latest-heading-text">Latest Headings</div>
    <div v-for="news in latestNews" class="mb-5 col-12 card" style="width: 60%; height: 20%; margin-top: 1vw">
      <div class="name-list-element" style="font-size: 1vw">{{ news.title }}</div>
      <div style="display: flex; justify-content: space-between">
        <div
          class="name-list-element"
          style="text-align: left; font-size: 0.7vw"
        >
          Date: {{formatDate(news.publishDate) }}
        </div>
        <div
          class="name-list-element"
          style="text-align: right; font-size: 0.7vw"
        >
          Source: {{ news.source }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import moment from "moment";

export default {
  props:{
    latestNews : Array,
    header: String,
    date: String,
    source: String
  },
  methods: {
      formatDate(dateInput, format = "DD.MM.YYYY") {
          return moment(dateInput).format(format);
      },
  }
};
</script>

<style>
.name-list-element {
  font-size: 18px;
  font-weight: 800;
  margin-top: 10px;
  color: #11101d;
}

.Latest-heading-text {
  font-family: "Poppins", sans-serif;
  color: #fff;
  font-size: 1.2vw;
  text-align: center;
  font-weight: 400;
  padding-top: 1vw;
  padding-right: 7vw;
}
</style>
