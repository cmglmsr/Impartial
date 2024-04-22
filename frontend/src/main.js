import "./assets/styles/base.css"
import "bootstrap/dist/css/bootstrap.css"
import { createApp } from 'vue';
import App from './App.vue';
import { store } from './store'; // Import the Vuex store
import router from './router';
import {axiosInstance} from "@/utils";

router.beforeEach(async (to, from) => {
    if(localStorage.getItem("token") == null) {
        store.commit("logout")
    }
    else {
        try {
            const response = await axiosInstance.post(`/user/check-token`);
            store.commit("login")
        } catch (err) {
            store.commit("logout")        }
    }

});

createApp(App).use(router).use(store).mount('#app');