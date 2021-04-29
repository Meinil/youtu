import { createStore } from 'vuex'

interface State {
    isLogin: boolean,
    auth: number,
    exp: number,
    name: string,
    isLoading: boolean
}

export default createStore({
    state () {
        return {
            isLogin: false,
            auth: -1, // 权限
            exp: -1, // 过期时间
            name: "", // 用户名

            isLoading: false
        }
    },
    // 不能有异步代码
    mutations: {
        // 设置从token中解析的信息
        setInfo: (state: State, info) => {
            if (info == null) {
                state.isLogin = false
                state.auth = -1
                state.exp = -1
                state.name = ""
            } else {
                state.auth = parseInt(info.auth)
                state.exp = parseInt(info.exp)
                state.name = info.username
            }
        },
        // 设置登陆状态
        setLogin: (state: State, login: boolean) => {
            state.isLogin = login
        },

        // 设置加载状态
        setLoading: (state: State) => {
            state.isLoading = !state.isLoading;
        }
    },
    // 存放异步操作
    actions: {

    },

    // 加工数据
    getters: {

    }
})