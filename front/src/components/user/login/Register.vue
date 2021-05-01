<template>
    <el-form
        status-icon
        ref="ruleForm2" 
        label-position="left" 
        label-width="0px" 
        class="demo-ruleForm login-page"
        v-loading="isLoading">
            <h3 class="title">注册</h3>
            <el-form-item prop="userName">
                <el-input type="text"
                    v-model="userName" 
                    auto-complete="off" 
                    placeholder="用户名" />
            </el-form-item>
            <el-form-item prop="password1">
                <el-input type="password" 
                    v-model="password1" 
                    auto-complete="off" 
                    placeholder="请输入密码" />
            </el-form-item>
            <el-form-item prop="password2">
                <el-input type="password" 
                    v-model="password2" 
                    auto-complete="off" 
                    placeholder="请再次输入密码" />
            </el-form-item>
        <el-form-item style="width:100%;">
            <el-button 
                type="primary" 
                style="width:100%;" 
                @click="submit"
                >注册</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
import {computed, defineComponent, ref} from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

import axios from "../../../utils/axios"
import {saveToken, showMessage} from "../../../utils/resultUilts"
import {OK} from "../../../utils/constant"

export default defineComponent({
    name: "Register",
    setup() {
        const userName = ref("")    // 用户名
        const password1 = ref("")    // 密码
        const password2 = ref("")    // 密码
        const router = useRouter()  // 路由对象
        const store = useStore()    // store对象

        const submit = () => {
            let name = userName.value.trim()
            let pwd1 = password1.value.trim()
            let pwd2 = password2.value.trim()
            if (pwd1 !== pwd2) {
                showMessage("两次输入的密码不一样，请重新输入")
                userName.value = ""
                password1.value = ""
                password2.value = ""
            } else if (name !== "" && pwd1 !== "") {
                axios.post("/user/register", {
                    userName: name,
                    password: pwd1
                })
                .then(
                    res => {
                        if (res.code !== OK) {
                            showMessage(res.msg, false)
                        } else {
                            saveToken(res.data.token)
                            store.commit("setLoading")
                            showMessage("注册成功", true)
                            router.replace("/home/recommend")
                        }
                    },
                    err => {
                        console.log(err)
                        showMessage("网络无连接,请重试", false)
                    })
            } else {
              showMessage("用户名密码不能为空", false)
            }
        }

        return{
            userName,
            password1,
            password2,
            submit,
            isLoading: computed(() => store.state.isLoading)
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
</style>