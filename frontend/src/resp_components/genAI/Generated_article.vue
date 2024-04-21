<template>
  <div class="card" style="display: inline; background-color: #2D4356;">
            <img src="../../images/news.jpg" />
            <div class="card-details">
              <span class="tag">Date: {{ date }}</span>
              <span class="tag">Source: {{ source }}</span>
              <span class="tag">Previous version: {{ previous_version }}</span>
              <span class="tag">Generated version: {{ generated_version }}</span>
              <div class="name">{{ header }}</div>
              <p class="p-content">
                {{ content }}
              </p>
            </div>
          </div>
</template>

<script>
export default {

}
</script>

<style>

.p-content {
height: auto !important;
font-size: "3vw";
color: #11101d;
line-height: 150%;
}

.card-details {
padding: 1.5vw 1.5vw 2vw;
}

.tag {
margin-top: 0.5vw;
margin-left: 0.5vw;
padding: 0.5vw 0.5vw;
border: 0.2vw solid #e5eaed;
border-radius: 1vw;
font-size: 0.8vw;
font-weight: 600;
color: #e5eaed;
width: auto;
align-items: center;
}

.name {
font-size: 24px;
font-weight: 600;
margin-top: 16px;
color: #11101d;
}
</style>