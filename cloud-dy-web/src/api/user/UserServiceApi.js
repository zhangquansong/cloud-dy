/**
 * 大华平台相关api
 */

import fetch from '@/util/request'

export function queryUser(query) {
    let uri = "cloud-dy-user/user/login";
    return fetch({
        url: uri,
        method: "post",
        data: query
    })
}
