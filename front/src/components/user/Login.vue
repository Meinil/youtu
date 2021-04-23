<template>
    <el-input class="username" v-model="userName" placeholder="请输入账号"></el-input>
    <el-input placeholder="请输入密码" v-model="password" show-password></el-input>
    <el-button type="primary">主要按钮</el-button>
</template>

<script>
import {defineComponent, ref} from "vue";

export default defineComponent({
    name: "Login",
    setup() {
        const userName = ref("")
        const password = ref("")

        return{
            userName,
            password
        }
    }
})
</script>
<style scoped>

</style>