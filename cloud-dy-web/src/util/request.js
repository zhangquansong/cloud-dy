import axios from 'axios'
import {Message,MessageBox} from 'element-ui'

/**
 * 创建实例
 */
const service = axios.create({
    baseURL: 'http://39.101.188.7:8095/',
    timeout: 50000,
    headers: {'Content-Type': 'application/json;charset=UTF-8'},
    transformRequest: [function (data) { //请求前操作请求参数
        return data;
    }]
});


export default service
