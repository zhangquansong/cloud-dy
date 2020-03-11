package com.cloud.dy.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author zhangquansong
 * @Description :
 * @Date 9:55 2020/3/11
 **/
@Slf4j
public class CheckUtil {

    public static final boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            return "".equals(o);
        }

        if (o instanceof List) {
            return ((List<?>) o).size() == 0;
        }
        return false;
    }

}
