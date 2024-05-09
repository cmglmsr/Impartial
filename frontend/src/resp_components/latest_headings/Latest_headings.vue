<template>
  <div>
    <div class="Latest-heading-text">Latest Headings</div>
    <div
      v-for="news in latestNews"
      class="mb-5 col-12 card"
      style="width: 60%; height: 20%; margin-top: 1vw"
    >
      <div class="name-list-element" style="font-size: 0.8vw">
        {{ news.title }}
      </div>
      <div style="display: flex; justify-content: space-between">
        <div
          class="name-list-element"
          style="text-align: left; font-size: 0.5vw"
        >
          Date: {{ formatDate(news.publishDate) }}
        </div>
        <div
          class="name-list-element"
          style="text-align: right; font-size: 0.5vw"
        >
          Source: {{ news.source }}
        </div>
      </div>
      <button
        style="
          text-decoration: none;
          padding: 0.5vw 0.3vw 0.5vw 0.3vw;
          border: none;
          border-radius: 2vw;
          font-weight: 600;
          font-size: 0.9vw;
          background-color: #e0efff;
          color: #11101d;
          margin-top: 1vw;
        "
      @click="redirectToReadMore(news.id)">
        Read More
      </button>
    </div>
  </div>
</template>

<script>
import moment from "moment";

export default {
  props: {
    latestNews: Array,
    header: String,
    date: String,
    source: String,
  },
  methods: {
    formatDate(dateInput, format = "DD.MM.YYYY") {
      return moment(dateInput).format(format);
    },
    redirectToReadMore(id) {
        console.log(id)
      this.$router.push({ name: "read-more-page", params: { id: id } });
    },
  },
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
