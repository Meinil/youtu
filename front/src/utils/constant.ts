const BASE_URL = "http://127.0.0.1:8080/youtu/api/" // 基础URL
const TOKEN = localStorage.getItem('token') === null ? '' : localStorage.getItem('token') // token

// 状态码
const OK = 0                // 请求成功
const NOT_AUTHORIZATION = 1 // 未授权
const NOT_FOUND = 2         //未找到资源
const RESOURCE_CONFLICT = 3 // 资源冲突
const ERROR = 4             //未知的错误

export {
    BASE_URL,
    TOKEN,
    OK,
    NOT_AUTHORIZATION,
    NOT_FOUND,
    RESOURCE_CONFLICT,
    ERROR
}