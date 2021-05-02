<template>
    <div id="upload">
        <el-upload
            class="upload-demo"
            drag
            ref="upload"
            multiple="false"
            show-file-list="true"
            auto-upload="false"
            :action="BASE_URL+'picture/upload'"
            :file-list="fileList"
            :data="radio"
            :headers="headers"
            submit>
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <template #tip>
                <div class="el-upload__tip">
                只能上传 图片 文件，且不超过 1MB
                </div>
            </template>
        </el-upload>
        <div>
            <p class="title">请选择分类</p>
            <el-radio-group v-model="radio" >
                <el-radio :label="cl.id" v-for="cl in classify" :key="cl.id">
                    {{cl.name}}
                </el-radio>
            </el-radio-group>
            <p class="title" >请填写描述</p>
            <el-input 
                v-model="story" 
                placeholder="请填写描述"
                class="story" /><br/>
            <el-button 
                class="submit" 
                type="primary" 
                @click="submit">上传</el-button>
        </div>
    </div>
</template>

<script>
import {defineComponent, onMounted, ref} from "vue";

import axios from "../../utils/axios";
import { BASE_URL, TOKEN } from "../../utils/constant"
import { showMessage } from "../../utils/resultUilts"

export default defineComponent({
    name: "Upload",
    setup() {
        const classify = ref() // 分类数据
        const radio = ref() // 选择的按钮
        const story = ref("") // 选择的按钮
        const fileList = ref([]) // 文件列表
        const upload = ref(null) // 文件列表

        onMounted(() => {
            axios.get("/classify/total")
            .then((res => {
                classify.value = res.data.classify
                radio.value = classify.value[0].id
            }))
            .catch(err => {
                console.log(err)
            })
        })

        const submit = () => {
            if (fileList.value.length < 1) {
                showMessage("文件不能为空", false)
                return
            } 
            
            if (story.trim() === "") {
                showMessage("描述信息不能为空", false)
                return
            } 

            upload.value.submit()
            axios.get("")
        }

        return {
            BASE_URL,
            headers: {
                'Authorization': TOKEN
            },
            classify,
            radio,
            story,
            submit,
            fileList,
        }
    }
})
</script>
<style scoped>
    #upload{
        width: 1200px;
        margin: 0 auto;
        text-align: center;
    }
    .upload-demo {
        margin: 20px 0;
    }
    .title{
        margin: 10px 0;
    }
    .story{
        width: 300px;
    }
    .submit {
        margin: 10px 0;
        width: 200px;
    }
</style>