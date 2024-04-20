<template>
  <div class="card" style="display: inline">
    <img src="../images/news.jpg" />
    <div class="card-details">
      <span class="date-source">Date: {{ date }}</span>
      <span class="date-source">Source: {{ source }}</span>
      <div class="name">{{ header }}</div>
      <p class="p-content">
        {{ content }}
      </p>
      <button v-on:click="bookmark()" class="icon-buttons">
        <i
          class="fa-regular fa-bookmark fa-xl"
          :class="{ clicked2: bookmark_clicked }"
        ></i>
      </button>
      <button v-on:click="show()" class="icon-buttons">
        <i class="fa-regular fa-comment fa-xl"></i>
      </button>
      <button v-on:click="show2()" class="icon-buttons">GenAI Option</button>
      <div class="stars">
                    <i
                      class="fa-solid fa-star"
                      :class="{ star_clicked: 1 <= this.rate }"
                      @click="rateNews(1)"
                    ></i>
                    <i
                      class="fa-solid fa-star"
                      :class="{ star_clicked: 2 <= this.rate }"
                      @click="rateNews(2)"
                    ></i>
                    <i
                      class="fa-solid fa-star"
                      :class="{ star_clicked: 3 <= this.rate }"
                      @click="rateNews(3)"
                    ></i>
                    <i
                      class="fa-solid fa-star"
                      :class="{ star_clicked: 4 <= this.rate }"
                      @click="rateNews(4)"
                    ></i>
                    <i
                      class="fa-solid fa-star"
                      :class="{ star_clicked: 5 <= this.rate }"
                      @click="rateNews(5)"
                    ></i>
                  </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.date-source {
  margin-top: 0.5vw;
  margin-left: 0.5vw;
  padding: 0.5vw 0.5vw;
  border: 0.2vw solid #e5eaed;
  border-radius: 1vw;
  font-size: 1vw;
  font-weight: 600;
  color: #11101d;
  width: auto;
  align-items: center;
}

.stars {
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
  gap: 1vw;
  margin-top: 10vw;
  padding-right: 40vw;
  padding-left: -40vw;
}
.star_clicked {
  color: #11101d;
  font-size: 30px;
  cursor: pointer;
}
.icon-buttons {
  text-decoration: none;
  padding: 0.9vw 1.2vw;
  border: none;
  border-radius: 2vw;
  font-weight: 600;
  font-size: 0.9vw;
  background-color: #e0efff;
  margin-left: 3vw;
  margin-bottom: -3vw;
  color: #11101d;
}

.p-content {
  height: auto !important;
  font-size: "3vw";
  color: #11101d;
  line-height: 150%;
}

.name {
  font-size: 24px;
  font-weight: 600;
  margin-top: 16px;
  color: #11101d;
}

.card-details {
  padding: 1.5vw 1.5vw 2vw;
}

</style>
