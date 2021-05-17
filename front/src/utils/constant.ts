import { parseToken, getItem } from "./utils"

const TOKEN = parseToken(null) === null ? null : getItem("token") // token

// 状态码
const OK = 0                // 请求成功
const NOT_AUTHORIZATION = 1 // 未授权
const NOT_FOUND = 2         //未找到资源
const RESOURCE_CONFLICT = 3 // 资源冲突
const ERROR = 4             //未知的错误

const STATIC_PATH = import.meta.env.VITE_SERVER                   // 静态资源
const BASE_URL = STATIC_PATH + "/youtu/api/"                    // 基础URL

const AUTH = getItem("auth") === null ? -1 : getItem("auth")    // 权限
const EXP = getItem("exp") === null ? -1 : getItem("exp")       // 过期时间
const NAME = getItem("exp") === null ? "" : getItem("name")     // 用户名

const GITHUB_CLIENT_ID = "73a12faa667ecb9e0cbb"                 // github client_id
const REDIRECT_URL = BASE_URL + "callback/github"               // 授权回调地址

export {
    BASE_URL,
    TOKEN,
    OK,
    NOT_AUTHORIZATION,
    NOT_FOUND,
    RESOURCE_CONFLICT,
    ERROR,
    STATIC_PATH,
    AUTH,
    EXP,
    NAME,
    GITHUB_CLIENT_ID,
    REDIRECT_URL
}