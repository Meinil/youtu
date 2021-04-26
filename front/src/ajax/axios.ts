import axios from "axios";

export default axios.create({
    baseURL: 'https://localhost:8080/youtu/api/',
    timeout: 2000,
    headers: {
        'Authorization': localStorage.getItem('token') === null ? '' : localStorage.getItem('token')
    }
})