<template>
  <div class="card">
    <img :src="imageSrc" />
    <div class="card-details">
      <span class="tag">Date: {{ date }}</span>
      <span class="tag">Source: {{ source }}</span>
      <div class="name">{{ header }}</div>
      <p class="p-content">{{ content }}</p>
      <button v-on:click="showMyComment" class="icon-buttons-comment-a">
        <i class="fa-regular fa-comment fa-l"></i> Show my comment
      </button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    date: String,
    source: String,
    header: String,
    content: String,
    imageSrc: {
      type: String,
      default: "" 
    }
  },
  methods: {
    showMyComment() {
      this.$emit("show-my-comment"); // Emit event to parent component
    }
  }
};
</script>

<style scoped>
.card-details {
  padding: 1.5vw 1.5vw 2vw;
}

.tag {
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

.name {
  font-size: 24px;
  font-weight: 600;
  margin-top: 16px;
  color: #11101d;
}

.p-content {
  height: auto !important;
  font-size: "3vw";
  color: #11101d;
  line-height: 150%;
}

.icon-buttons-comment-a {
  padding: 0.5vw;
  border: none;
  border-radius: 2vw;
  font-weight: 500;
  background-color: #bacdd8;
  font-size: 0.7vw;
}
</style>

