<template>
    <el-table
        :data="data"
        style="width: 100%">
        <el-table-column
            label="日期"
            width="200">
            <template #default="scope">
                <i class="el-icon-time"></i>
                <span style="margin-left: 10px">{{ getTime(scope.row.createTime) }}</span>
            </template>
        </el-table-column>
        <el-table-column
            label="姓名"
            width="180">
            <template #default="scope">
                <el-popover effect="light" trigger="hover" placement="top">
                <template #default>
                    <img :src="STATIC_PATH + scope.row.name" class="img-container">
                </template>
                <template #reference>
                    <div class="name-wrapper">
                    <el-tag size="medium">{{ scope.row.story }}</el-tag>
                    </div>
                </template>
                </el-popover>
            </template>
        </el-table-column>
        <el-table-column
            label="状态"
            width="180">
            <template #default="scope">
                <el-tag :type="scope.row.isShow ? 'success' : 'danger'">
                    {{ scope.row.isShow ? "已审核" : "未审核" }}
                </el-tag>
            </template>
        </el-table-column>
        <el-table-column 
            label="操作">
            <template #default="scope">
                <el-button
                    size="mini"
                    @click="handleEdit(scope.$index, scope.row)">修改状态</el-button>
                <el-button
                    size="mini"
                    type="danger"
                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
</template>
<script lang="ts">
import { computed, defineComponent, onMounted, Ref, ref } from "vue"

import axios from "../../utils/axios"
import { STATIC_PATH } from "../../utils/constant"
import store from "../../store/store"
import { getTime } from "../../utils/utils"


interface Data{
    id: string,
    name: string,
    createTime: string,
    isShow: boolean,
    owner: string,
    story: string,
}

export default defineComponent({
    name: "UploadManager",
    setup() {
        const data: Ref<Data[]> = ref([])
        const total = ref(0)
        let dom: any
        const page = ref(1)
        
        // 修改图片状态
        const handleEdit = (index: number, row: Data) => {
            axios.post(`/admin/update/${row.id}`)
            .then(res => {
                data.value[index].isShow = !data.value[index].isShow 
            })
        }
        const handleDelete = (index: number, row: Data) => {
        }

        const request = () => {
            axios.get(`/admin/recommend/${page.value}`)
            .then(res => {
                data.value = res.data.pictures
                console.log(data.value)
            })
        }

        // 组件刚开始挂载时，默认请求第一页和总数
        onMounted(() => {
            request()
            axios.get("admin/examine/recommend")
            .then(res => {
                console.log(res)
                total.value = res.data.total / 8
            })
        })

        return {
            data,
            STATIC_PATH,
            handleEdit,
            handleDelete,
            total,
            getTime,
            isLoading: computed(() => store.state.isLogin),
        }
    }
})
</script>
<style lang="less" scoped>
    .block {
        text-align: center;
        margin: 20px 0;
    }
    .img-container {
        width: 125px;
    }
</style>>