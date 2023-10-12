<script setup>

</script>

<template>
  <div class="list-element">
    <h1 class="news-header">{{header}}</h1>
    <p class="news-desc">{{desc}}</p>
    <div class="news-details">
      <p>{{date}}</p>
      <p>{{source}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "List_element",
  props: ['header', 'desc', 'date', 'source']
}
</script>