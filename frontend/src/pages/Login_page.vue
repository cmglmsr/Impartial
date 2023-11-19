<template>
  <body>
    <div class="box">
        <div class="container">
            <div class="top-header">
                <span>Have an account?</span>
                <header>Login</header>
            </div>
            <div class="input-field">
                <input type="email" class="input" placeholder="Email" required>
                <i class="bx bx-user"></i>
            </div>
            <div class="input-field">
                <input type="password" class="input" placeholder="Password" required>
                <i class="bx bx-lock-alt"></i>
            </div>
            <div class="input-field">
                <input type="submit" class="submit" value="Login">
            </div>
            <div class="bottom">
                <div class="left">
                    <input type="checkbox" id="check">
                    <label for="check"> Remember Me </label>
                </div>
                <div class="right">
                    <label><a href="#">Forgot password?</a></label>
                </div>
            </div>
        </div>
    </div>
  </body>
</template>

<script>
export default {

}
</script>

<style scope>
body{
    background-color: #11101d;
}

.box{
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 90vh;
}

.container{
    width: 350px;
    display: flex;
    flex-direction: column;
    padding: 0 15px 0 15px
}

span{
    color: #fff;
    font-size: medium;
    display: flex;
    justify-content: center;
    padding: 10px 0 10px 0;
}

header{
    color: #fff;
    font-size: 35px;
    display: flex;
    justify-content: center;
    padding: 10px 0 10px 0;
}
.input-field{
    display: flex;
    flex-direction: column;
}
.input{
    height: 45px;
    width: 100%;
    border: none;
    outline: none;
    border-radius: 30px;
    color: #fff;
    padding: 0 0 0 42px;
    background: rgba(255, 255, 255, 0.1);
}

i{
    position: relative;
    top: -31px;
    left: 17px;
    color: #fff;
}

::-webkit-input-placeholder{
    color: #fff;
}

.submit{
    border: none;
    border-radius: 30px;
    font-size: 20px;
    height: 45px;
    outline: none;
    width: 100%;
    background: rgba(255, 255, 255, 0.7);
    cursor: pointer;
    transition: .3s;
}

.submit:hover{
    box-shadow: 1px 5px 7px 1px rgba(0, 0, 0, 0.2);
}

.bottom{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    font-size: small;
    color: #fff;
    margin-top: 10px;
}

.left{
    display: flex;
    font-size: 15px;
}

label a{
    color: #fff;
    text-decoration: none;
    font-size: 15px;
}
</style>