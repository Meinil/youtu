<template>
    <ul class="img-container">
        <li class="block" v-for="img in data" :key="img.id">
            <div class="picture">
                <img :src="STATIC_PATH + img.name" alt="图片列表" class="picture-img"/>
            </div>
            <div class="desc">{{img.story}}</div>
        </li>
    </ul>
    <el-pagination
        v-if="total > 8"
        :page-size="8"
        layout="prev, pager, next"
        :total="total"
        class="page"
        @current-change="currentChange">
    </el-pagination>
</template>

<script>
import {defineComponent, ref, toRefs, watch} from "vue";

import { showMessage } from "../../../utils/resultUilts"
import axios from "../../../utils/axios"
import { STATIC_PATH } from "../../../utils/constant"

export default defineComponent({
    name: "Picture",
    props: [
        "activeName"
    ],
    setup(props) {
        const total = ref(100) // 分页对象的总数
        const page = ref(1) // 当前的页数

        const data = ref([])
        const {activeName} = toRefs(props)

        // 请求图片内容
        const request = (path) => {
            axios.get(`/picture/${path}/${page.value}`)
            .then(res => {
                data.value = res.data.pictures
            })
            .catch(err => {
                showMessage("网络错误", false)
            })
        }

        // 请求total
        const reqTotal = (path) => {
            axios.get(`/picture/${path}`)
            .then(res => {
                total.value = res.data.total
            })
            .catch(err => {
                showMessage("网络错误", false)
            })
        }

        watch(activeName, (current) => {
            page.value = 1
            reqTotal(current) // 请求总数
            request(current) // 请求内容
        }, {
            immediate: true
        })

        const currentChange = (p) => {
            page.value = p
            request(activeName.value)
        }
        return {
            total,
            currentChange,
            data,
            page,
            STATIC_PATH
        }
    }
})
</script>
<style scoped>
    .img-container {
        text-align: center;
        margin-top: 20px;
    }
    .block{
        width: 220px;
        height: 280px;
        padding: 10px;
        margin-left: 12px;
        margin-right: 12px;
        margin-bottom: 15px;
        box-sizing: border-box;
        text-align: center;
        display: inline-block;
        border: 2px rgba(193, 193, 193, .4) solid;
    }

    .block:hover {
        transform:translateY(-3px) translateX(-3px);
        box-shadow: 10px 10px 5px rgba(226, 226, 226, .8);
        transition: 2s;
    }
    .img-container:first-child {
        margin-left: 0;
    }
    .img-container:first-child {
        margin-right: 0;
    }
    .picture {
        width: 196px;
        height: 150px;
        overflow: hidden;
    }

    .picture-img {
        width: 196px;
        height: 150px;
    }

    .desc {
        box-sizing: border-box;
        padding: 10px;
    }

    .page {
        margin-bottom: 10px;
        text-align: center;
    }
</style>