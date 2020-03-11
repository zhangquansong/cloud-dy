package com.cloud.dy.common.exception;

import java.io.IOException;

/**
 * @ClassName : FilterExceptionHelper
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:11
 * @Description :Filter异常处理
 **/
public class FilterExceptionHelper {

    /**
     * 处理BizException错误
     *
     * @param bz
     * @param request
     * @param response
     * @throws IOException
     */
    /*public static void handleBizException(BizException bz, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        MyExceptionHandler.sendErrorMessage(bz.getMessage(), request, response);
    }

    *//**
     * 处理BizException错误
     *
     * @param bz
     * @param request
     * @param response
     * @throws IOException
     *//*
    public static void handleBizException(BizException bz, int httpStatus, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(httpStatus);
        MyExceptionHandler.sendErrorMessage(bz.getMessage(), request, response);
    }*/

}
