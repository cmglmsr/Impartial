import "./assets/styles/base.css"
import "bootstrap/dist/css/bootstrap.css"
import "bootstrap/dist/js/bootstrap.js"


import { createApp } from 'vue'
import { createRouter, createWebHistory } from "vue-router";
import App from './App.vue'

const router = createRouter({
    history: createWebHistory(),
    routes: [],

})

createApp(App).mount('#app')
.use(router)
