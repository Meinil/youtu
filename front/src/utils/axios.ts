import axios from "axios"

import { BASE_URL, ERROR, NOT_AUTHORIZATION, NOT_FOUND, OK, RESOURCE_CONFLICT, TOKEN } from "./constant"
import store from "../store/store"
import { showMessage } from "./resultUilts"
import router from "../router/routes"


const youtu = axios.create({
    baseURL: BASE_URL,
    timeout: 10000,
    headers: {
        'Authorization': TOKEN
    }
})

// 添加请求拦截器
youtu.interceptors.request.use(function (config) {
    if (!store.state.isLoading) {
        store.commit("setLoading")
    }
    return config
}, function (error) {
    if (store.state.isLoading) {
        store.commit("setLoading")
    }
    return Promise.reject(error)
})

// 添加响应拦截器
youtu.interceptors.response.use(res => {
    if (res.data.code != OK) {
        let msg = "";
        switch(res.data.code) {
            case NOT_AUTHORIZATION:
                msg = "未授权或权限不足，请登陆后重试"
                break
            case NOT_FOUND:
                msg = "未找到资源"
                break
            case RESOURCE_CONFLICT:
                msg = "资源冲突"
                break
            default:
                msg = "未知的错误"
        }
        showMessage(msg, false)
        if (res.data.code == NOT_AUTHORIZATION) {
            router.push("/login")
        }
        return Promise.reject(msg)
    } else if(store.state.isLoading){
        store.commit("setLoading")
    }
    return res.data
}, error => {
    // 对响应错误做点什么
    if (store.state.isLoading) {
        store.commit("setLoading")
    }
    return Promise.reject(error)
})

export default youtu