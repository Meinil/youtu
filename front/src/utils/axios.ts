import axios from "axios"

import { BASE_URL, TOKEN } from "./constant"
import store from "../store/store"


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
    if (!store.state.isLoading) {
        store.commit("setLoading")
    }
    return Promise.reject(error)
})

// 添加响应拦截器
youtu.interceptors.response.use(function (res) {
    // 对响应数据做点什么
    if (store.state.isLoading) {
        store.commit("setLoading")
    }
    return res.data
}, function (error) {
    // 对响应错误做点什么
    if (store.state.isLoading) {
        store.commit("setLoading")
    }
    return Promise.reject(error)
})

export default youtu