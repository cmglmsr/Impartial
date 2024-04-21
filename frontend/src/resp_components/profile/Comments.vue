<template>
  <div class="card" style="display: inline">
    <img src="../../images/news.jpg" />
    <div class="card-details">
      <span class="tag">Date: {{ date }}</span>
      <span class="tag">Source: {{ source }}</span>
      <div class="name">{{ header }}</div>
      <p class="p-content">
        {{ content }}
      </p>
      <button v-on:click="show_my_comment()" class="icon-buttons-comment-a">
        <i class="fa-regular fa-comment fa-l"></i> Show my comment
      </button>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
