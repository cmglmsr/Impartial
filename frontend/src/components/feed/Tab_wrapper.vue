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
    width: 50%;
    margin: 6.5rem auto 0;
    margin-left: 15%;
    margin-top: 1%;
}

.tabs-header{
    margin-left: 15%;
    list-style: none;
    padding: 0;
    display: flex;
    justify-content: space-around;
    margin-bottom: 3rem;
}

.tabs-header li{
    font-size: 1.5rem;
    font-weight: 600;
    color: #263238;
    cursor: pointer;
    position: relative;
}

.tabs li::after{
    content: "";
    position: absolute;
    bottom: -20%;
    left: -3%;
    width: 0%;
    height: 5px;
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