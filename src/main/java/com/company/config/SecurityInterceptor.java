package com.company.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SecurityInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        String url = "";
        if (session.getAttribute("loginUser") != null){
            return true;
        }else{
            if(isAjaxRequest(request)){
                // 跳转登录
                url = "/";
            }else{
                // 跳转登录
                url = "/";
            }
        }
        response.sendRedirect(url);
        return false;
    }

    /**
     * 判断是否为Ajax请求
     *
     * @param request
     *            HttpServletRequest
     * @return 是true, 否false
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if (requestType != null && requestType.equals("XMLHttpRequest")) {
            return true;
        } else {
            return false;
        }
    }

}
