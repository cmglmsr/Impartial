<template>
  <div class="container my-4">
    <div
      id="carouselExampleDark"
      class="carousel carousel-dark slide"
      data-bs-ride="carousel"
      data-bs-interval="false"
    >
      <div class="carousel-indicators">
        <button
          type="button"
          data-bs-target="#carouselExampleDark"
          data-bs-slide-to="0"
          class="active"
          aria-current="true"
          aria-label="Slide 1"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselExampleDark"
          data-bs-slide-to="1"
          aria-label="Slide 2"
        ></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <div style="min-height: 200px">
            <div class="carousel-caption d-block">
              <p class="generated-article-slide-texts-p">
                {{content}}
              </p>
            </div>
          </div>
        </div>
        <div class="carousel-item">
          <div style="min-height: 200px">
            <div class="carousel-caption d-block">
              <span class="generated-article-tag"
                >Previous version: {{ previous_version }}</span
              >
              <span class="generated-article-tag"
                >Generated version: {{ generated_version }}</span
              >
              <p class="generated-article-slide-texts-p">
                {{generated_article_content}}
              </p>
            </div>
          </div>
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#carouselExampleDark"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#carouselExampleDark"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    header: String,
    content: String,
    generated_article_header: String,
    generated_article_content: String,
    previous_version: String,
    generated_version: String
  }
};
</script>

<style scope>
@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,200;0,400;0,500;0,600;0,700;1,200&family=Yusei+Magic&display=swap");
.generated-article-tag {
  margin-top: 0.5vw;
  margin-left: 0.5vw;
  padding: 0.5vw 0.5vw;
  border: 0.2vw solid #11101d;
  border-radius: 1vw;
  font-size: 0.8vw;
  font-weight: 600;
  color: #11101d;
  width: auto;
  align-items: center;
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

.generated-article-slide-texts-h5{
    font-family: 'Poppins', sans-serif;
    font-size: 1.5vw;
    color: #11101d;
    margin-top: 0.5rem; /* Adjust this value as needed */
}

.generated-article-slide-texts-p{
    font-family: 'Poppins', sans-serif;
    font-size: 1vw;
    color: #11101d;
}

.carousel-caption {
  padding-top: 0.5rem; /* Adjust this value as needed */
}

.generated-article-slide-texts h5 {
  margin-top: 0; /* Add this line to remove any default margin */
}
</style>
