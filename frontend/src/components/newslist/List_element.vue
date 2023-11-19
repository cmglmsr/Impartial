<script setup>

</script>

<template>
      <div class="card-list-element">
        <img src="../../images/news.jpg" alt="Breaking news" class="img-list-element"/>
        <div class="card-details">
          <div class="name-list-element">{{ header }}</div>
          <p>
            {{ content }}
          </p>
        </div>
      </div>
</template>

<script>
import "./newslist.css"
export default {
  name: "List_element",
  props: ['header', 'desc', 'date', 'source']
}
</script>