<template>
    <el-row class="m-t-20">
        <el-table :data="list"
            border
            :height="h"
            :key="toggleIndex"
            id="out-table"
            class="nowrap">
        <el-table-column
            label="用户ID"
            width="200"
            align="center"
            v-if="isAccount">
        </el-table-column>
        <el-table-column 
            prop="roomId"
            label="聊天室ID"
            width="200"
            align="center"
            v-if="!isAccount">
        </el-table-column>
      </el-table>
    </el-row>
    <el-button type="primary"  @click="toggleData">切换表格</el-button>
</template>
<script lang="ts">
import { defineComponent, ref } from "vue";


export default defineComponent({
    name: "PictureManager",
    setup() {
        const isAccount = ref(true)
        const toggleIndex = ref(0)
        const toggleData = () => {
    		isAccount.value = !isAccount.value
    		toggleIndex.value = Math.random()
    	}
        return {
            isAccount, // 默认显示某些数据
    		toggleIndex,// 设置索引默认值
            toggleData 
        }
    }
})
</script>
<style scoped>

</style>