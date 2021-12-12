import moment from "moment"

const saveItem = (key: string, item: string | number) => {
    localStorage.setItem(key, item + "")
}

const getItem = (key: string) => {
    return localStorage.getItem(key)
}

// 解析TOKEN并保存
const parseToken = (token: string | null) => {
    let info = null
    if (token === null) { // 如果token为空则从本地获取
        token = getItem("token");
    }
    if (token != null) { // 如果token为空说明未登录
        let tokenInfo = token.split(".")
        info =JSON.parse(window.atob(tokenInfo[1]))
        if (parseInt(info.exp) <=( Date.now() / 1000)) return null // TOKEN过期
        saveItem("token", token)
        saveItem("auth", info.auth)
        saveItem("exp", info.exp)
        saveItem("name", info.username)
    }
    return info
}


// 获取URL对应的名字
const getPictureName = (name: string) => {
    return name.substring(name.lastIndexOf("/") + 1)
}

// 获取时间
const getTime = (time: string) => {
    return moment(time).format('lll')
}
export {
    parseToken,
    saveItem,
    getItem,
    getPictureName,
    getTime
}