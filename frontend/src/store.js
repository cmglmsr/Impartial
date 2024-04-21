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
        },
        login(state){
            state.authorized = true
        },
        logout(state){
            state.authorized = false
        }
    },
    getters: {
        isAuthorized (state) {
            return state.authorized
        }
    },

});