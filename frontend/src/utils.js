import axios from 'axios';
let isDev = import.meta.env.DEV
const serverUrl = isDev ? "http://localhost:8080" : ""
export const axiosInstance = axios.create({
    baseURL : serverUrl + "/api",
    headers: {
        Authorization : `${localStorage.getItem("accessToken")}`
    }
})

export const noAuthAxiosInstance = axios.create({
    baseURL : serverUrl + "/home"
})