<script setup>
import Feed_element from "@/components/feed/Feed_element.vue";
</script>

<template>
  <div class="feed-body">
    <Feed_element
      header="George Santos’ former campaign treasurer"
      content="George Santos’ former campaign treasurer pleads guilty to one count of conspiracy to defraud the United States."
      date="06.10.2023"
      source="CNN News"
    />

    <Feed_element
      header="Biden administration will begin deporting Venezuelan migrants directly to Venezuela"
      content="The Biden administration will restart deporting Venezuelans directly to Venezuela in an attempt to curb the record influx."
      date="06.10.2023"
      source="CNN News"
    />

    <Feed_element
      header="US fighter jet downs a drone belonging to NATO ally Turkey over Syria"
      content="A US F-16 fighter jet shot down an armed Turkish drone in northeast Syria that was operating near US military personnel."
      date="06.10.2023"
      source="CNN News"
    />
  </div>
</template>

<style scoped>
.feed-body {
  position: absolute;
  margin-left: 30%;
}
</style>
