<template>
  <div v-if="isSelected" class="container">
    <div class="content">
      <slot></slot>
    </div>
  </div>
</template>

<script>
import "./Tab.css";
export default {
  props: {
    isSelected: {
      type: Boolean,
    },
  },
};
</script>

<style scoped>
.container {
  position: relative;
  display: flex;
  flex-direction: row;
  justify-content: center;
}
.content {
  width: 90%;
  margin-top: -6%;
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  animation: fade 1s ease;
}

@keyframes fade {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}
</style>
