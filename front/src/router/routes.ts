import {createRouter, createWebHashHistory} from "vue-router";

import store from "../store/store"

import { TOKEN } from "../utils/constant"
import { showMessage } from "../utils/resultUilts"

import Home from "../components/Home.vue"
import Admin from "../components/admin/Admin.vue"
import Picture from "../components/user/picture/Picture.vue"
import Login from "../components/user/login/Login.vue"
import Register from "../components/user/login/Register.vue"

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
                component: Picture,
            },
            {
                path: 'comic',
                component: Picture,
            },
            {
                path: 'scenery',
                component: Picture,
            },
            {
                path: 'life',
                component: Picture,
            }
        ]
    },
    {
        path: '/admin',
        component: Admin,
        children: [
            {
                path: "picture",
                component: () => import("../components/admin/UploadManager.vue")
            },
            {
                path: "comment",
                component: () => import("../components/admin/PictureManager.vue")
            },
            {
                path: "user",
                component: () => import("../components/admin/UploadManager.vue")
            }
        ]
    },
    {
        path: '/login',
        component: Login,
    },
    {
        path: '/register',
        component: Register,
    },
    {
        path: "/profile",
        component: () => import("../components/user/profile/Profile.vue"),
        meta: {
            isCheck: true
        }
    },
    {
        path: "/upload",
        component: () => import("../components/user/Upload.vue"),
        meta: {
            isCheck: true
        }
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

router.beforeEach((to, from, next) => {
    if (to.meta.isCheck) {
        if (TOKEN === null) {
            next("/login")
        } else if (store.state.exp !== null) {
            if (store.state.exp <= Date.now() / 1000) {
                showMessage("???????????????????????????", false)
                if (store.state.isLogin) {
                    store.commit("setInfo") // ??????????????????
                }
                next("/login")
            } else {
                next()
            }
        }
    } else {
        next()
    }
})

export default router