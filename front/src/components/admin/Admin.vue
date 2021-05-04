<template>
    <div class="header">
        <div class="left">
            <router-link to="/home">
                <img src="../../assets/logo.png" alt="">
            </router-link>
        </div>
        <div class="right">
            <p class="weclome">你好，admin</p>
            <span class="logout">退出</span>
        </div>
    </div>
    <el-row class="tac">
        <el-col :span="4" class="nav-container">
            <el-menu
                default-active="1"
                class="el-menu-vertical-demo"
                @select="handleSelect">
                <el-menu-item index="1" class="item">
                    <i class="el-icon-menu"></i>
                    <template #title>图片管理</template>
                </el-menu-item>
                <el-menu-item index="2" class="item">
                    <i class="el-icon-document"></i>
                    <template #title>留言管理</template>
                </el-menu-item>
                <el-menu-item index="3" class="item">
                    <i class="el-icon-setting"></i>
                    <template #title>用户管理</template>
                </el-menu-item>
            </el-menu>
        </el-col>
        <el-col :span="20" class="view">
            <router-view></router-view>
        </el-col>
    </el-row>
</template>

<script lang="ts">
import {defineComponent, onMounted} from "vue";
import { useRouter } from "vue-router";

export default defineComponent({
    name: "Admin",
    setup() {
        const router = useRouter() // 路由对象

        const handleSelect = (key: string) => {
            let path = ""
            switch(key) {
                case "1":
                    path = "picture"
                    break
                case "2":
                    path = "comment"
                    break
                case "3":
                    path = "user"
                    break
                default:
                    return
            }
            router.push("/admin/" + path)
        }

        onMounted(() => {
            handleSelect("1")
        })

        return {
            handleSelect
        }
    }
})
</script>
<style scoped>
    .tac, .nav-container, .el-menu-vertical-demo{
        width: 100%;
        height: 100%;
    }
    .item {
        padding-left: 50px !important;
    }
    .view{
        width: 100%;
        height: 100%;
    }
    .header {
        width: 100%;
        height: 50px;
        background: #5DCEC6;
        line-height: 50px;
    }

    .left {
        float: left;
    }

    .left  img {
        margin: 0 20px;
        height: 50px;
    }

    .right {
        float: right;
        right: 50px;
    }

    .weclome {
        float: left;
        margin: 0 20px;
    }
    .logout {
        float: right;
        margin-right: 30px;
    }
</style>