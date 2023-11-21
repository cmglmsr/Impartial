import {createRouter, createWebHistory} from "vue-router"
import Home_page from "../src/pages/Home_page.vue"
import Login_page from "../src/pages/Login_page.vue"
import Reg_page from "../src/pages/Reg_page.vue"
import News_detail_page from "../src/pages/News_detail_page.vue"


const routes = [
    {path: '/', name: 'Home_page', component: Home_page},
    {path: '/Login_page', name: 'Login_page', component: Login_page},
    {path: '/Reg_page', name: 'Reg_page', component: Reg_page},
    {path: '/News_detail_page', name: 'News_detail_page', component: News_detail_page},

]

const router = createRouter({routes, history: createWebHistory()})

export default router;