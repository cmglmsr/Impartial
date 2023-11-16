
<template>
  <a class="sidebar-link" :href=this.link>
    <div class="sidebar-section">
      <i :class=this.icon></i>
      <label class="sidebar-label">{{this.label}}</label>
    </div>
  </a>
</template>

<script>
export default {
  name: "Sidebar_section",
  props: ['icon', 'label', 'link']
}

</script>