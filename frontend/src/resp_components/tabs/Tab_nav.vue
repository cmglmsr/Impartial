<template>
  <div class="tabs">
    <ul class="nav tabs-header">
      <li
        v-for="tab in tabs"
        :key="tab"
        :class="{ selected: tab === selected }"
        @click="setTab(tab)"
        style="padding-left: 2vw; padding-right: 2vw"
      >
        {{ tab }}
      </li>
    </ul>
    <slot></slot>
  </div>
</template>

<script>
import "./Tab.css";
export default {
  props: {
    tabs: {
      type: Array,
      required: true,
    },
    selected: {
      type: String,
      required: true,
    },
  },
  methods: {
    setTab(tab) {
      this.$emit("selected", tab);
    },
  },
};
</script>

<style scoped>
.tabs {
  width: 70%;
  margin-top: 1vw;
  margin-left: 2vw;
  align-items: center;
  display: flex;
  flex-direction: row;
  justify-content: center;
}

.tabs-header {
  margin-left: 10vw;
  list-style: none;
  display: flex;
  justify-content: space-around;
  margin-bottom: 2vw;
}

.tabs-header li {
  font-size: 1.2vw;
  font-weight: 600;
  color: #263238;
  cursor: pointer;
  position: relative;
}

.tabs-header li::after {
  content: "";
  position: absolute;
  bottom: -0.3vw;
  height: 0.3vw;
  background: #263238;
  border-radius: 30px;
  transition: width 0.8s ease, left 0.4s ease; /* Added left transition */
  width: 0; /* Initially hidden */
  left: 50%; /* Initially centered */
}

.tabs-header li.selected {
  color: #263238;
}

.tabs-header li.selected::after {
  width: 70%;
  left: 15%; /* Adjusted position to align with selected header */
}

/* Media query for screens <= 768px */
@media (max-width: 768px) {
  .tabs-header li {
    font-size: 2.5vw; /* Font size when screen width is <= 768px */
  }
  .tabs {
    width: 100%;
    margin-top: 1.5vw;
    align-items: center;
    display: flex;
    flex-direction: row;
    justify-content: center;
    margin-left: -2vw;
  }
}
</style>
