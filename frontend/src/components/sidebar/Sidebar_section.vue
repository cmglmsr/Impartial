
<template>
  <div class="sidebar-section">
    <i :class=this.icon></i>
    <label>{{this.label}}</label>
  </div>
</template>

<script>
export default {
  name: "Sidebar_section",
  props: ['icon', 'label', 'link']
}

</script>