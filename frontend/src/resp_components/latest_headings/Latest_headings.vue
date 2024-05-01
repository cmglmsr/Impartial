<template>
  <div>
    <div class="Latest-heading-text">Latest Headings</div>
    <div class="col-12 card" style="width: 60%; height: 20%; margin-top: 1vw">
      <div class="name-list-element" style="font-size: 1vw">{{ header }}</div>
      <div style="display: flex; justify-content: space-between">
        <div
          class="name-list-element"
          style="text-align: left; font-size: 0.7vw"
        >
          Date: {{ date }}
        </div>
        <div
          class="name-list-element"
          style="text-align: right; font-size: 0.7vw"
        >
          Source: {{ source }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props:{
    header: String,
    date: String,
    source: String
  }
};
</script>

<style>
.name-list-element {
  font-size: 18px;
  font-weight: 800;
  margin-top: 10px;
  color: #11101d;
}

.Latest-heading-text {
  font-family: "Poppins", sans-serif;
  color: #fff;
  font-size: 1.2vw;
  text-align: center;
  font-weight: 400;
  padding-top: 1vw;
  padding-right: 7vw;
}
</style>
