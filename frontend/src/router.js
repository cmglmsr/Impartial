import {createRouter, createWebHistory} from "vue-router"
import Home_page from "../src/pages/Home_page.vue"
import Login_page from "../src/pages/Login_page.vue"
import Reg_page from "../src/pages/Reg_page.vue"
import News_detail_page from "../src/pages/News_detail_page.vue"
import Profile_page from "../src/pages/Profile_page.vue"
import Generated_article_page from "../src/pages/Generated_article_page.vue"

const routes = [
    {path: '/main-page', name: 'main-page', component: Home_page},
    {path: '/', name: 'login-page', component: Login_page},
    {path: '/reg-page', name: 'reg-page', component: Reg_page},
    {path: '/news-detail-page/:id', name: 'news-detail-page', component: News_detail_page, props: true},
    {path: '/profile-page', name: 'profile-page', component: Profile_page},
    {path: '/generated-article-page/:id', name: 'generated-article-page', component: Generated_article_page, props: true},
]

const router = createRouter({routes, history: createWebHistory()})

export default router;