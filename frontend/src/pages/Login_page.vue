<template>
  <div class="wrapper-login">
    <div class="container main-login">
      <div class="row">
        <div class="col-md-6 side-image">
          <div class="text-login">
            <p class="p-login">Impartial</p>
          </div>
        </div>
        <div class="col-md-6 right-login">
          <div class="input-box">
            <header class="login-header">Login</header>
            <div class="input-field">
              <input
                v-model="email"
                type="text"
                class="login-input"
                id="email"
                required
                autocomplete="off"
              />
              <label for="email" class="login-label">Email</label>
            </div>
            <div class="input-field">
              <input
                v-model="password"
                type="password"
                class="login-input"
                id="password"
                required
              />
              <label for="password" class="login-label">Password</label>
            </div>
            <div class="input-field">
              <input
                v-if="!this.request"
                @click="login"
                type="submit"
                class="submit"
                value="Login"
              />
              <input
                v-else
                type="submit"
                class="submit"
                value="Login"
                disabled
              />
            </div>
            <div class="signin">
              <span class="login-span"
                >Create an account!
                <a href="/reg-page" class="login-a">Register</a></span
              >
            </div>
            <div class="signin">
              <span class="login-span"
                >Forgot your password?
                <a href="/reg-page" class="login-a">Click Here!</a></span
              >
            </div>
          </div>
        </div>
      </div>
    </div>
    <error_popup></error_popup>
  </div>
</template>

<script>
import { noAuthAxiosInstance } from "@/utils";
import { eventBus } from "../event-bus";
import error_popup from "../resp_components/popups/error_popup.vue";
export default {
  data() {
    return {
      email: "",
      password: "",
      request: false,
    };
  },
  components:{
    error_popup
  },
  methods: {
    async login(e) {
      e.preventDefault();
      if (!this.request) {
        this.request = true;
        try {
          const resp = await noAuthAxiosInstance.post("/login", {
            mail: this.email,
            password: this.password,
          });
          this.email = "";

          window.localStorage.setItem("token", resp.data);
          this.$store.commit("login");
          this.$router.push({ path: "/" }).then(() => {
            this.$router.go(0);
          });
        } catch (err) {
          eventBus.emit(
            "api-error",
            "An unexpected error occurred. Please try again later."
          );
        }
        this.password = "";
        this.request = false;
      }
    },
  },
};
</script>

<style scope>
.wrapper-login {
  padding-top: 1vw;
}

.main-login {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

.side-image {
  background-image: url("../images/wp4.jpg");
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
  position: relative;
  border-radius: 10px 0 0 10px;
}

.row {
  width: 900px;
  height: 550px;
  border-radius: 10px;
  background: #fff;
  box-shadow: 5px 5px 10px 1px rgba(0, 0, 0, 0.2);
}

.text-login {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.text-login .p-login {
  color: #fff;
  font-size: 40px;
  font-weight: 600;
}

.right-login {
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
}

.input-box {
  width: 330px;
  box-sizing: border-box;
}

.input-box .login-header {
  font-weight: 700;
  text-align: center;
  margin-bottom: 45px;
  font-size: x-large;
}

.input-field {
  display: flex;
  flex-direction: column;
  position: relative;
  padding: 0 10px 0 10px;
}

.login-input {
  height: 45px;
  width: 100%;
  background: transparent;
  border: none;
  border-bottom: 1px solid rgba(0, 0, 0, 0.2);
  outline: none;
  margin-bottom: 20px;
  color: #40414a;
}

.input-box .input-field .login-label {
  position: absolute;
  top: 10px;
  left: 10px;
  pointer-events: none;
  transition: 0.5s;
}

.input-field .login-input:focus ~ .login-label {
  top: -10px;
  font-size: 13px;
}

.input-field .login-input:valid ~ .login-label {
  top: -10px;
  font-size: 13px;
  color: #5d5076;
}

.input-field .login-input:focus,
.input-field .login-input:valid {
  border-bottom: 1px solid #5d5076;
}

.submit {
  border: none;
  outline: none;
  height: 45px;
  background: #ececec;
  border-radius: 5px;
  transition: 0.4s;
}

.submit:hover {
  background: rgba(37, 95, 156, 0.5);
  color: #11101d;
}

.signin {
  text-align: center;
  font-size: medium;
  margin-top: 25px;
}

.login-span .login-a {
  text-decoration: none;
  font-weight: 700;
  color: #11101d;
  transition: 0.5s;
}

.login-span .login-a:hover {
  text-decoration: underline;
  color: #11101d;
}

@media only screen and (max-width: 768px) {
  .side-image {
    border-radius: 10px 10px 0 0;
  }
  .text-login {
    position: absolute;
    top: 70%;
    text-align: center;
  }
  .text-login .p-login {
    font-size: 18px;
  }
  .row {
    max-width: 420px;
    width: 100%;
  }
}
</style>
