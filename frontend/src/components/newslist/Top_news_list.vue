<script>
import List_element from "@/components/newslist/List_element.vue";
import "./newslist.css";
export default {
  components: {
    List_element,
  },
};
</script>

<template>
  <div class="scroll">
    <div class="top-news-list-div">
      <h1 class="top-news-header">Latest Headlines</h1>
      <ul class="top-news-list">
        <li class="top-news-list-element">
          <List_element
            header="George Santos’ former campaign treasurer"
            desc="George Santos’ former campaign treasurer pleads guilty to one count of conspiracy to defraud the United States."
            date="06.10.2023"
            source="CNN News"
          />
        </li>
        <li class="top-news-list-element">
          <List_element
            header="Biden administration will begin deporting Venezuelan migrants directly to Venezuela"
            desc="The Biden administration will restart deporting Venezuelans directly to Venezuela in an attempt to curb the record influx."
            date="06.10.2023"
            source="CNN News"
          />
        </li>
        <li class="top-news-list-element">
          <List_element
            header="US fighter jet downs a drone belonging to NATO ally Turkey over Syria"
            desc="A US F-16 fighter jet shot down an armed Turkish drone in northeast Syria that was operating near US military personnel."
            date="06.10.2023"
            source="CNN News"
          />
        </li>
      </ul>
    </div>
  </div>
</template>

<style >

</style>
