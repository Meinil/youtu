<template>
    <el-form
        status-icon
        ref="ruleForm2" 
        label-position="left" 
        label-width="0px" 
        class="demo-ruleForm login-page"
        v-loading="isLoading">
            <h3 class="title">登陆</h3>
            <p class="register">
                没有账号?
                <router-link to="/register"> 点此注册</router-link>
            </p>

            <el-form-item prop="userName">
                <el-input type="text"
                    v-model="userName" 
                    auto-complete="off" 
                    placeholder="用户名" />
            </el-form-item>
            <el-form-item prop="password">
                <el-input type="password" 
                    v-model="password" 
                    auto-complete="off" 
                    placeholder="密码" />
            </el-form-item>
        <el-checkbox v-model="checked" class="rememberme">记住密码</el-checkbox>
        <el-form-item style="width:100%;">
            <el-button 
                type="primary" 
                style="width:100%;" 
                @click="submit"
                >登录</el-button>
        </el-form-item>
        <a :href="url">
            <img class="github" src="../../../assets/github.png" alt="github">
        </a>
    </el-form>
</template>

<script>
import {computed, defineComponent, ref} from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

import axios from "../../../utils/axios"
import {saveToken, showMessage} from "../../../utils/resultUilts"
import {OK, REDIRECT_URL, GITHUB_CLIENT_ID} from "../../../utils/constant"

export default defineComponent({
    name: "Login",
    setup() {
        const userName = ref("")    // 用户名
        const password = ref("")    // 密码
        const checked = ref(false)  // 记住密码
        const router = useRouter()  // 路由对象
        const store = useStore()    // store对象

        const submit = () => {
            let name = userName.value.trim()
            let pwd = password.value.trim()
            if (name !== "" && pwd !== "") {
                axios.post("/login", {
                    userName: name,
                    password: pwd
                })
                .then(
                    res => {
                        if (res.code !== OK) {
                            showMessage(res.msg, false)
                        } else {
                            saveToken(res.data.token)
                            showMessage("登陆成功，跳转主页面", true)
                            store.commit("setLoading")
                            router.replace({path: "/home/recommend"}).catch(err => {
                                console.log(err)
                            })
                        }
                    },
                    err => {
                        showMessage("网络无连接,请重试", false)
                    })
            } else {
              showMessage("用户名密码不能为空", false)
            }
        }

        return{
            userName,
            password,
            checked,
            submit,
            isLoading: computed(() => store.state.isLoading),
            url: `https://github.com/login/oauth/authorize?client_id=${GITHUB_CLIENT_ID}&redirect_uri=${REDIRECT_URL}&scope=user&state=1`

        }
    }
})
</script>
<style scoped>
    .login-page {
        -webkit-border-radius: 5px;
        border-radius: 5px;
        margin: 180px auto;
        width: 350px;
        padding: 35px 35px 15px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
        text-align: center;
    }

    .title {
        margin-bottom: 15px;
    }
    label.el-checkbox.rememberme {
        margin: 0px 0px 15px;
        text-align: left;
    }
    .register {
        font-size: 12px;
        margin-bottom: 10px;
    }

    .github {
        width: 30px;
    }
</style>