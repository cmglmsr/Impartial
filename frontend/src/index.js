import { createRouter, createWebHistory } from 'vue-router'
import Home_page from "@/pages/Home_page"
import News_detail_page from "@/pages/News_detail_page"

const routes = [
  {
    path: "/",
    name: "Home_page",
    component: Home_page
  },
  {
    path: "/news-detail",
    name: "News_detail_page",
    component: News_detail_page
  }
]

const router = createRouter({history: createWebHistory(process.env.BASE_URL), routes})
export default router