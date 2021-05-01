<template>
    <el-menu
        class="el-menu-demo"
        mode="horizontal"
        default-active="recommend">
        <router-link to="/home">
            <img class="logo" src="../assets/logo.png" alt="logo">
        </router-link>
        <el-menu-item index="recommend" @click="select">推荐</el-menu-item>
        <el-menu-item index="comic" @click="select">动漫</el-menu-item>
        <el-menu-item index="scenery" @click="select">风景</el-menu-item>
        <el-menu-item index="life" @click="select">生活</el-menu-item>

        <el-submenu index="personal" class="login-container">
            <template #title>{{loginMsg}}</template>
            <el-menu-item index="5-1" v-if="isLogin" @click="jump('/profile/personal')">个人资料</el-menu-item>
            <el-menu-item index="5-2" v-if="isLogin" @click="jump('/profile/personal')">我的收藏</el-menu-item>
            <el-menu-item index="5-3" v-if="isLogin" @click="jump('/profile/personal')">我的上传</el-menu-item>
            <el-menu-item index="5-4" v-if="isLogin" @click="logOut">退出登陆</el-menu-item>
            <el-menu-item index="5-5" v-if="!isLogin" @click="jump('/login')">点我登陆</el-menu-item>
        </el-submenu>
    </el-menu>
    <Picture :activeName="activeName"/>
</template>

<script lang="ts">
import { computed, defineComponent, onMounted, ref } from "vue"
import { useRouter} from "vue-router";

import Login from "./user/login/Login.vue"
import Register from "./user/login/Register.vue"
import Third from "./user/login/Third.vue"
import Picture from "./user/picture/Picture.vue"

import { showMessage } from "../utils/resultUilts"

import { useStore } from 'vuex';

interface Nav {
    index: string,
    indexPath?: string[]
}

export default defineComponent({
    name: 'Home',
    components: {
        Third,
        Register,
        Login,
        Picture
    },
    setup() {
        const router = useRouter() // 路由
        const store = useStore() // store

        const loginMsg = ref("登陆")
        const activeName = ref("recommend")

        // 默认回调
        const select = (nav: Nav) => {
            activeName.value = nav.index
            router.push(`/home/${nav.index}`)
        }

        // 路由跳转
        const jump = (path: string) => {
            router.push({
                path
            })
        }

        // 退出登陆
        const logOut = () => {
            store.commit("setInfo")
            showMessage("退出成功", true)
        }

        onMounted(() => {
            select({index: "recommend"})
        })

        return {
            loginMsg,
            select,
            jump,
            logOut,
            activeName,
            isLogin: computed(() => store.state.isLogin),
            isLoading: computed(() => store.state.isLoading)
        }
    }
})
</script>

<style scoped>
    .el-menu-demo {
        position: relative;
    }
    .login-container{
        position: absolute; 
        right: 0;
    }
    .logo {
        height: 61px;
        float: left;
    }
    .account{
        margin: 0 auto;
        width: 60%;
    }
    .github-img {
        float: right;
        position: relative;
    }
    .github-img img {
        width: 32px;
        position: absolute;
        right: 10px;
    }
    .login {
        width: 150px;
        position: relative;
        top: -20px;
    }
</style>
