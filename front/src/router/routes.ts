import {createRouter, createWebHashHistory} from "vue-router";

import Home from '../components/Home.vue'
import Admin from '../components/admin/Admin.vue'
import Picture from '../components/user/picture/Picture.vue'

const routes = [
    {
        path: '/',
        redirect: '/home'
    },
    {
        path: '/home',
        component: Home,
        children: [
            // {
            //     path: '/:path',
            //     component: Picture
            // },
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
        component: Admin
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
})

export default router