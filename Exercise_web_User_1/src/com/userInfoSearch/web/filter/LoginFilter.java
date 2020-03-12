package com.userInfoSearch.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException{
        // 1， 转换类型（ServletRequest - > HttpServletRequest)
        HttpServletRequest request = (HttpServletRequest) req;
        // 2， 获取资源请求的路径
        String uri = request.getRequestURI();
        // 3, 判断是否含有登录相关的资源路径，要注意排除css/js/图片验证码资源
        if(uri.contains("login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/font/") || uri.contains("/checkCodeServlet")){
            // 包含，用户想要登录，放行
            chain.doFilter(req, resp);
        }else{
            // 不包含，需要验证用户是否登录
            // 从session中获取user
            Object user = request.getSession().getAttribute("user");
            if(user != null){
                // 登录了，放行
                chain.doFilter(req, resp);
            }else{
                // 没有登录，返回登录页面
                request.setAttribute("login_msg", "您尚未登录，请先登录！");
                request.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }
}
