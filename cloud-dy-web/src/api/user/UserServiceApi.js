/**
 * 大华平台相关api
 */

import fetch from '@/util/request'

export function queryUser(query) {
    let uri = "cloud-dy-user/userSentinel";
    return fetch({
        url: uri,
        method: "get",
        data: query
    })
}
