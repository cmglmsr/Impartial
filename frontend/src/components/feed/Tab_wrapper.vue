<template>
  <div class="tabs"> 
    <ul class="tabs-header">
        <li 
            v-for="title in tabTitles" 
            :key="title"
            :class="{selected: title == selectedTitle}"
            @click="selectedTitle = title"
        >
            {{ title }}
        </li>
    </ul>
    <slot></slot>
  </div>
</template>

<script>
import { ref, provide } from 'vue';
export default {
    setup(props, { slots }){
        const tabTitles = ref(slots.default().map((tab) => tab.props.title))
        const selectedTitle = ref(tabTitles.value[0])
        provide("selectedTitle", selectedTitle)
        return{
            selectedTitle,
            tabTitles
        }
    }
}
</script>

<style scope>
.tabs{
    width: 70%;
    margin-top: 1vw;
    margin-left: 2vw;
    align-items: center;
}

.tabs-header{
    margin-left: 10vw;
    list-style: none;
    display: flex;
    justify-content: space-around;
    margin-bottom: 2vw;
}

.tabs-header li{
    font-size: 1.2vw;
    font-weight: 600;
    color: #263238;
    cursor: pointer;
    position: relative;
}

.tabs li::after{
    content: "";
    position: absolute;
    bottom: -0.3vw;
    left: 0vw;
    width: 0%;
    height: 0.3vw;
    background: #263238;
    border-radius: 30px;
    transition: width .8s ease;
}

.tabs-header li.selected{
    color: #263238;
}

.tabs-header li.selected::after{
    width: 104%;
}


</style>