<template>
    <ul class="img-container">
        <li class="block" v-for="img in data" :key="img.id">
            <div class="picture">
                <img :src="STATIC_PATH + img.name" alt="图片列表" class="picture-img"/>
            </div>
            <div class="desc">
                <el-button>
                    <a :href="STATIC_PATH + img.name" :download="getPictureName(img.name)">下载</a>
                </el-button>
                <el-button>收藏</el-button><br />
                <p class="story author">{{img.story}}</p>
                <p class="author">Author: {{img.owner}}</p>
            </div>
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

<script lang="ts">
import {defineComponent, ref, toRefs, watch, Ref} from "vue";

import { getPictureName } from "../../../utils/utils"
import axios from "../../../utils/axios"
import { STATIC_PATH } from "../../../utils/constant"

interface Data{
    id: string,
    name: string,
    story: string,
    owner: string
}
export default defineComponent({
    name: "Picture",
    props: [
        "activeName"
    ],
    setup(props) {
        const total = ref(100) // 分页对象的总数
        const page = ref(1) // 当前的页数

        // const data = ref([])
        const data: Ref<Data[]> = ref([])
        const {activeName} = toRefs(props)

        // 请求图片内容
        const request = (path: string) => {
            axios.get(`/picture/${path}/${page.value}`)
            .then(res => {
                data.value = res.data.pictures
            })
        }

        // 请求total
        const reqTotal = (path: string) => {
            axios.get(`/picture/${path}`)
            .then(res => {
                total.value = res.data.total
            })
        }

        // 监控激活的导航
        watch(activeName, (current: string) => {
            page.value = 1
            reqTotal(current) // 请求总数
            request(current) // 请求内容
        }, {
            immediate: true
        })

        // 翻页
        const currentChange = (p: number) => {
            page.value = p
            request(activeName.value)
        }
        return {
            total,
            currentChange,
            data,
            page,
            STATIC_PATH,
            getPictureName
        }
    }
})
</script>
<style scoped>
    .img-container {
        text-align: center;
        width: 1200px;
        margin: 0 auto;
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
        box-shadow: 10px 10px 10px rgba(226, 226, 226, .8);
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

    a{
        text-decoration: none;
        color: #606266;
    }
    a:hover{
        color: #409EFF;
    }

    .story {
        margin-bottom: 5px;
        margin-top: 5px;
    }

    .author{
        color: #606266;
    }
</style>