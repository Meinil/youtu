import { ElMessage } from "element-plus"
import store from "../store/store"
import { parseToken } from "./utils" 


// 设置TOKEN
const saveToken = (token: string | null) => {
    if (token != null) {
        let info = parseToken(token)
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
            duration: 800
        })
    } else {
        ElMessage.error({
            message: msg,
            type: "error",
            duration: 800
        })
    }
}

export {
    saveToken,
    showMessage
}
