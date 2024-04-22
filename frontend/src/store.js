import { createStore } from 'vuex';

export const store = createStore({
    state() {
        return {
            authorized: false,

        };
    },
    mutations: {
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
        },
    },

});