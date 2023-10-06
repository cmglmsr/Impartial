import "./assets/styles/base.css"
import PrimeVue from 'primevue/config';

import { createApp } from 'vue'
import App from './App.vue'

createApp(App).mount('#app')
App.use(PrimeVue);
