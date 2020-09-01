package com.cloud.dy.user.config.seata;

import io.seata.core.context.RootContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SeataHandlerInterceptor extends HandlerInterceptorAdapter {

    /**
     * 拦截前处理
     * 将全局事务ID绑定到上下文中
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param handler  handler
     * @return 是否继续下一步
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String currentXid = RootContext.getXID();
        String globalXid = request.getHeader(RootContext.KEY_XID);
        if (StringUtils.isBlank(currentXid) && StringUtils.isNotBlank(globalXid)) {
            RootContext.bind(globalXid);
        }
        return true;
    }

    /**
     * 拦截后处理
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param handler  handler
     * @param ex       异常
     * @throws Exception 异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String globalXid = request.getHeader(RootContext.KEY_XID);
        if (StringUtils.isBlank(globalXid)) {
            return;
        }
        String unBindXid = RootContext.unbind();
        //在事务期间被更改过
        if (!globalXid.equalsIgnoreCase(unBindXid)) {
            RootContext.bind(unBindXid);
        }
    }

}