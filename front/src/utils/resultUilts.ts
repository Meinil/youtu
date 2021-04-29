import { ElMessage } from "element-plus"
import store from "../store/store"

// 设置TOKEN
const saveToken = (token: string) => {
    if (token != null) {
        let tokenInfo = token.split(".")
        let info =JSON.parse(window.atob(tokenInfo[1]))
        store.commit("setInfo", info)
        store.commit("setLogin", true)
    } else {
        store.commit("setInfo", null)
    }
}


// 校验code
const showMessage = (msg: string, isSuccess: boolean) => {
    if(isSuccess) {
        ElMessage.success({
            message: msg,
            type: "success",
            duration: 2000
        })
    } else {
        ElMessage.error({
            message: msg,
            type: "error",
            duration: 2000
        })
    }
    store.commit("setLoading")
}

export {
    saveToken,
    showMessage
}
