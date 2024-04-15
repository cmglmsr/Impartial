import axios from 'axios';
let isDev = import.meta.env.DEV
const serverUrl = isDev ? "https://api.newsimpartial.com" : "https://api.newsimpartial.com"
export const axiosInstance = axios.create({
    baseURL : serverUrl + "/home",
    headers: {
        Authorization : `Bearer ${localStorage.getItem("token")}`
    }
})

export const noAuthAxiosInstance = axios.create({
    baseURL : serverUrl + "/home"
})
