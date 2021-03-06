import { createApp } from 'vue'
import App from './App.vue'
import router from './router/routes'
import store from './store/store'

import ElementPlus from 'element-plus';
import 'element-plus/lib/theme-chalk/index.css';

const app = createApp(App)

app.use(ElementPlus)

app.use(store) // vuex
app.use(router) // 路由

app.mount('#app')
