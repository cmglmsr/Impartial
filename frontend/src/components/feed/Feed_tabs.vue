<template>
    <div class="container" v-show="title == selectedTitle">
      <div class="content">
        <slot></slot>
      </div>
    </div>
</template>

<script>
import { inject } from 'vue';
export default {
    props:['title'],
    setup(){
        const selectedTitle = inject("selectedTitle")
        return{
            selectedTitle
        }
    }
};
</script>

<style scoped>
.container{
  position: relative;
}
.content{
  width: 60%;
  margin-top: -6%;
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  animation: fade 1s ease;
}

@keyframes fade{
    from{
        opacity: 0;
    }
    to{
        opacity: 1;
    }
}
</style>
