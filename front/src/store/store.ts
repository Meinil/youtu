import { createStore } from 'vuex'

import { TOKEN, AUTH, EXP, NAME, BASE_URL } from "../utils/constant"

interface State {
    isLogin: boolean,
    auth: number | string | null,
    exp: number | string | null,
    name: string | null,
    isLoading: boolean,
    avatarUrl: string
}

export default createStore({
    state () {
        return {
            isLogin: TOKEN !== null,
            auth: AUTH,             // 权限
            exp: EXP,               // 过期时间
            name: NAME,             // 用户名
            avatarUrl: "",             // 用户头像
            isLoading: false
        }
    },
    // 不能有异步代码
    mutations: {
        // 设置从token中解析的信息
        setInfo: (state: State, info) => {
            if (info === null) {
                state.isLogin = false
                state.auth = -1
                state.exp = -1
                state.name = ""
                localStorage.clear() // 移除token
            } else {
                state.auth = parseInt(info.auth)
                state.exp = parseInt(info.exp)
                state.name = info.username
                state.isLogin = true
            }
        },
        // 设置登陆状态
        setLogin: (state: State) => {
            state.isLogin = !state.isLogin
        },

        // 设置加载状态
        setLoading: (state: State) => {
            state.isLoading = !state.isLoading;
        },

        // 设置头像
        setAvatarUrl: (state: State, avatarUrl: string | undefined) => {
            if (avatarUrl == undefined) {
                avatarUrl = import.meta.env.VITE_HOST  + "/youtu/favicon.ico"
            } 
            state.avatarUrl = avatarUrl
            console.log(state.avatarUrl)
        }
    },
    // 存放异步操作
    actions: {

    },

    // 加工数据
    getters: {

    }
})