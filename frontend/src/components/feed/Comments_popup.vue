<template>
  <div class="popup">
    <div class="popup-inner">
        <slot></slot>
        <button class="popup-close" v-on:click="show()"><i class="fa-solid fa-xmark fa-lg"></i></button>
    </div>
  </div>
</template>

<script>
export default {
    props: ['show']
}
</script>

<style scope>
.popup{
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    z-index: 99;
    background-color: rgba(0, 0, 0, 0.2);
    display: flex;
    align-items: center;
    justify-content: center;
}

.popup .popup-inner{
    background: #FFF;
    padding: 32px;
}


</style>