import {createRouter, createWebHistory} from "vue-router"
import Home_page from "../src/pages/Home_page.vue"
import Login_page from "../src/pages/Login_page.vue"
import Reg_page from "../src/pages/Reg_page.vue"
import Bookmarks_page from "../src/pages/Bookmarks_page.vue"
import Generated_article_page from "../src/pages/Generated_article_page.vue"
import Read_more_page from "../src/pages/Read_more_page.vue"
import Manual_test_page from "../src/pages/Manual_test_page.vue"

const routes = [
    {path: '/', name: 'main-page', component: Home_page},
    {path: '/login-page', name: 'login-page', component: Login_page},
    {path: '/reg-page', name: 'reg-page', component: Reg_page},
    {path: '/read-more-page/:id', name: 'read-more-page', component: Read_more_page, props: true},
    {path: '/bookmarks-page', name: 'bookmarks-page', component: Bookmarks_page},
    {path: '/manual-test-page', name: 'manual-test-page', component: Manual_test_page},
    {path: '/generated-article-page/:id', name: 'generated-article-page', component: Generated_article_page, props: true},
]

const router = createRouter({routes, history: createWebHistory()})
export default router;