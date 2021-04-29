import axios from "axios"

import { BASE_URL, TOKEN } from "./constant"

export default axios.create({
    baseURL: BASE_URL,
    timeout: 10000,
    headers: {
        'Authorization': TOKEN
    }
})