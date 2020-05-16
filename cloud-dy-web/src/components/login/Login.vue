<template>
    <div id="login" class="container">
        <el-form :model="formData" :rules="formRule" ref="formData">
            <el-form-item prop="username">
                <el-input name="username" v-model="formData.username" placeholder="请输入用户名" auto-complete="on"></el-input>
            </el-form-item>

            <el-form-item prop="password">
                <el-input  name="password" v-model="formData.password" placeholder="请输入密码" auto-complete="on"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="handleSubmit">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>


<script>
import {queryUser} from '@/api/user/UserServiceApi'

export default {
  name: "#login",
  data() {
    const validateUserName = (rule, value, callback) => {
        if (!value) {
            callback(new Error("请输入用户名"))
        }
    }
    return {
      formData: {
            username: "",
            password: ""
          },
       formRule: {
           username: [{required: true, trigger: 'blur', validator: validateUserName}],
          }
      }
  },

  methods: {
      handleSubmit(){
              queryUser(this.formData).then(response => {
                  console.log(response.data);
                  //if (response.data.data) {
                  //}
                  setTimeout(() => {
                  }, 0.5 * 1000);
              })
          }
  },
  mounted() {

  }
};
</script>
<style scoped>
.el-input {
        width:300px;
}
 .container {
    text-align: center;
    margin:0 auto;
  }
</style>
