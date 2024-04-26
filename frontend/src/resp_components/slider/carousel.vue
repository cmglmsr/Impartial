<template>
  <div class="container my-4" :style="{ height: containerHeight }">
    <div
      :id="carouselId"
      class="carousel carousel-dark slide"
      data-bs-ride="carousel"
      data-bs-interval="false"
    >
      <div class="carousel-indicators" style="margin-bottom: -0.1vw">
        <button
          type="button"
          :data-bs-target="'#' + carouselId"
          data-bs-slide-to="0"
          class="active custom-carousel-button"
          aria-current="true"
        ></button>
        <button
          type="button"
          :data-bs-target="'#' + carouselId"
          data-bs-slide-to="1"
          class="custom-carousel-button"
        ></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <div style="min-height: 10vw">
            <div class="carousel-container">
              <p class="generated-article-slide-texts-p">
                {{ content }}
              </p>
            </div>
          </div>
        </div>
        <div class="carousel-item">
          <div style="min-height: 10vw">
            <div class="carousel-container">
              <span class="generated-article-tag">Previous version: </span>
              <span class="generated-article-tag">Generated version: </span>
              <p class="generated-article-slide-texts-p"></p>
            </div>
          </div>
        </div>
      </div>
      <span
        type="button"
        :data-bs-target="'#' + carouselId"
        data-bs-slide="prev"
        class="carousel-control-prev-icon"
        aria-hidden="true"
        :style="{
          'padding-left': isMobile ? '5vw' : '4vw',
          'margin-bottom': isMobile ? '-16vw' : '-6vw',
        }"
      ></span>
      <span
        type="button"
        :data-bs-target="'#' + carouselId"
        data-bs-slide="next"
        class="carousel-control-next-icon"
        aria-hidden="true"
        :style="{
          'padding-left': isMobile ? '5vw' : '4vw',
          'margin-bottom': isMobile ? '-16vw' : '-6vw',
        }"
      ></span>
    </div>
    <div v-if="!userAuthenticated">
      <button
        class="icon-buttons-main-page-not-auth"
        @click="redirectToReadMore"
      >
        Read More
      </button>
    </div>
    <div v-if="userAuthenticated">
      <!-- DO NOT REMOVE !!!!!!!!!!!!! if user is not logged in they shouldnt see rating bookmarking etc.-->

      <button class="icon-buttons-main-page" @click="redirectToReadMore">
        Read More
      </button>
      <button
        v-on:click="bookmarkNews"
        class="icon-buttons-main-page"
        :class="{ 'bookmarked-bg': bookmark_clicked }"
      >
        <i
          class="fa-regular fa-bookmark fa-xl"
          :class="{ clicked2: bookmark_clicked }"
        ></i>
      </button>
      <button
        v-on:click="showCommentPopup(this.newsId)"
        class="icon-buttons-main-page"
      >
        <i class="fa-regular fa-comment fa-xl"></i>
      </button>
      <button
        v-on:click="showGenAIPopup(this.newsId)"
        class="icon-buttons-main-page"
      >
        GenAI Option
      </button>
      <div class="stars-container">
        <div class="star-rating" @mouseleave="resetRating">
          <span
            v-for="star in totalStars"
            :key="star"
            @mouseover="highlightStar(star)"
            @click="rateStar(star)"
          >
            <i
              :class="star <= currentRating ? 'fas fa-star' : 'far fa-star'"
            ></i>
          </span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { axiosInstance } from "@/utils";

export default {
  props: {
    content: String,
    newsId: Number,
    isBookmarked: Boolean,
    ratingValue: { type: Number, default: 0 }, // Used for showing prev. ratings when page is loaded
  },
  data() {
    return {
      containerHeight: "",
      totalStars: 5,
      currentRating: this.ratingValue, // this is the rating used when mouse hovers over stars. Init with any prev. rating
      oldRating: this.ratingValue, // this is the rating that is committed to db.
      bookmark_clicked: undefined,
      userAuthenticated: this.$store.getters.isAuthorized,
    };
  },
  computed: {
    isMobile() {
      return window.innerWidth <= 768;
    },
    carouselId() {
        return "Carousel" + this.newsId
    }
  },
  mounted() {
    this.bookmark_clicked = this.isBookmarked;
    this.setContainerHeight();
    window.addEventListener("resize", this.setContainerHeight);
  },
  beforeUnmount() {
    window.removeEventListener("resize", this.setContainerHeight);
  },
  methods: {
    async bookmarkNews() {
      try {
        if (!this.bookmark_clicked) {
          const resp = await axiosInstance.post(`news/bookmark/${this.newsId}`);
        } else {
          const resp = await axiosInstance.delete(
            `news/bookmark/${this.newsId}`
          );
        }
        this.bookmark_clicked = !this.bookmark_clicked;
      } catch (err) {
        console.log(err);
        //Todo
      }
    },
    setContainerHeight() {
      const width = window.innerWidth;
      this.containerHeight =
        width <= 768 ? `${width * 0.45}px` : `${width * 0.25}px`;
    },
    highlightStar(star) {
      this.currentRating = star;
    },
    async rateStar(star) {
      try {
        if (this.currentRating === this.oldRating) {
          //if we click on the same rating the rating is removed
          await axiosInstance.delete(`/news/rate/${this.newsId}`);
          this.oldRating = 0;
          this.currentRating = 0;
        } else {
          //if we click on a different rating the rating is updated
          await axiosInstance.post(`/news/rate/${this.newsId}`, {
            rating: star,
          });
          this.oldRating = star;
        }
      } catch (err) {
        //Todo
        console.log(err);
      }
    },
    resetRating() {
      this.currentRating = this.oldRating; //when mouse is removed display the latest committed rating (0 if no rating)
    },
    redirectToReadMore() {
      this.$router.push({ name: "read-more-page", params: { id: 0 } });
    },
    showCommentPopup(id) {
      this.$emit("show-comment-popup");
    },
    showGenAIPopup(id) {
      this.$emit("show-genAI-popup");
    },
  },
  watch: {
    isBookmarked(newVal) {
      this.bookmark_clicked = newVal;
    },
  },
};
</script>

<style scope>
@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,200;0,400;0,500;0,600;0,700;1,200&family=Yusei+Magic&display=swap");
.generated-article-tag {
  margin-top: 0.5vw;
  margin-left: 0.5vw;
  font-size: 0.7vw;
  font-weight: 500;
  color: #11101d;
  align-items: center;
}

.clicked2 {
  color: #ffffff;
}

.bookmarked-bg {
  background-color: #1c136b !important;
}
.stars-container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 1.5vw;
}

.star-rating {
  font-size: 2vw;
  color: #11101d;
  font-weight: 600;
}

.star-rating i {
  margin-right: 3vw;
  cursor: pointer;
}

@media screen and (max-width: 768px) {
  .stars-container {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 3vw;
  }
}

@media screen and (max-width: 768px) {
  .star-rating {
    font-size: 3vw;
    color: #11101d;
    font-weight: 500;
  }
}

.icon-buttons-main-page {
  text-decoration: none;
  padding: 0.5vw 0.5vw 0.5vw 0.5vw;
  border: none;
  border-radius: 2vw;
  font-weight: 600;
  font-size: 0.9vw;
  background-color: #e0efff;
  color: #11101d;
  margin-top: 3vw;
  margin-left: 4vw;
}

.icon-buttons-main-page-not-auth {
  text-decoration: none;
  padding: 0.5vw 0.5vw 0.5vw 0.5vw;
  border: none;
  border-radius: 2vw;
  font-weight: 600;
  font-size: 0.9vw;
  background-color: #e0efff;
  color: #11101d;
  margin-top: 3vw;
  margin-left: 16vw;
}

@media screen and (max-width: 768px) {
  .icon-buttons-main-page {
    text-decoration: none;
    padding: 1vw 1vw 1vw 1vw;
    border: none;
    border-radius: 2vw;
    font-weight: 600;
    font-size: 1.5vw;
    background-color: #e0efff;
    color: #11101d;
    margin-top: 3vw;
    margin-left: 3.5vw;
  }

  .icon-buttons-main-page-not-auth {
    text-decoration: none;
    padding: 1vw 1vw 1vw 1vw;
    border: none;
    border-radius: 2vw;
    font-weight: 600;
    font-size: 2vw;
    background-color: #e0efff;
    color: #11101d;
    margin-top: 3vw;
    margin-left: 19vw;
  }
}

.carousel-container {
  padding-left: 2vw;
  padding-right: 2vw;
}

#carouselExampleDark .carousel-control-prev-icon,
#carouselExampleDark .carousel-control-next-icon {
  width: 2vw;
  height: 2vw;
}

.carousel {
  background-color: #e0efff;
  width: 100%;
  height: 70%;
  margin-top: auto;
}

.generated-article-slide-texts-h5 {
  font-family: "Poppins", sans-serif;
  font-size: 1.5vw;
  color: #11101d;
  margin-top: 0.5rem;
}

.generated-article-slide-texts-p {
  font-family: "Poppins", sans-serif;
  font-size: 0.7vw;
  color: #11101d;
}

.carousel-caption {
  padding-top: 0.5rem;
}

.generated-article-slide-texts h5 {
  margin-top: 0;
}
</style>
