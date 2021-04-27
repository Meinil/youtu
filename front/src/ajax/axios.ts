import axios from "axios";

export default axios.create({
    baseURL: 'http://127.0.0.1:8080/youtu/api/',
    timeout: 2000,
    headers: {
        'Authorization': localStorage.getItem('token') === null ? '' : localStorage.getItem('token')
    }
})