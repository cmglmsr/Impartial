import { createStore } from 'vuex';

export const store = createStore({
    state() {
        return {
            authorized: false,
            name: "",
            token: ""
        };
    },
    mutations: {
        setToken(state, token) {
            state.token = token;
        },
        clearToken(state) {
            state.token = "";
        }
    },
    getters: {
        getToken: state => state.token
    }
});