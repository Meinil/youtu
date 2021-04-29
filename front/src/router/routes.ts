import {createRouter, createWebHashHistory} from "vue-router";

import Home from '../components/Home.vue'
import Admin from '../components/admin/Admin.vue'
import Picture from '../components/user/picture/Picture.vue'
import Login from '../components/user/login/Login.vue'

import store from '../store/store'
import { TOKEN } from '../utils/constant'

const routes = [
    {
        path: '/',
        redirect: '/home'
    },
    {
        path: '/home',
        component: Home,
        children: [
            {
                path: 'recommend',
                component: Picture
            },
            {
                path: 'comic',
                component: Picture
            },
            {
                path: 'scenery',
                component: Picture
            },
            {
                path: 'life',
                component: Picture
            },
        ]
    },
    {
        path: '/admin',
        component: Admin,
        meta: {}
    },
    {
        path: '/login',
        component: Login,
        meta: {}
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
})

// router.beforeEach((to, from, next) => {
//     if (!store.state.isLogin || TOKEN === "") {
//         next("/login")
//     } else {

//     }
//     next()
// })

export default router