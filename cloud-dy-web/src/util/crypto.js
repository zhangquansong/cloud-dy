import CryptoJs from 'crypto-js'

const KP = {
    appKey: 'ZJEIOT',
    secret: 'WeJ8TY88vbakCcnvH8G1tDUqzLWY8yss'
};

const md5 = (data) => {
    return CryptoJs.MD5(data).toString();
};

/**
 * 签名
 * @param params 签名数据
 */
const sign = (params) => {
    if(!!!params) params ={};
    let paramStr = "";
    params.appKey = KP.appKey;
    params.timestamp = parseInt(new Date().getTime() / 1000);
    let keys = Object.keys(params);
    keys.sort();
    for (let i = 0; i < keys.length; i++) {
        if (keys[i] !== "sign" && typeof params[keys[i]] !== 'object' && params[keys[i]] !== "")
            paramStr += keys[i] + "=" + params[keys[i]] + "&";
    }
    params.sign = md5(paramStr.substring(0, paramStr.length - 1) + KP.secret);
    return JSON.stringify(params);
};

export {sign}



