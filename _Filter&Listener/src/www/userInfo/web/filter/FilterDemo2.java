package www.userInfo.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;
//@WebFilter("/hello.jsp")
public class FilterDemo2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException{
        // 对request对象请求消息增强
        System.out.println("filterDemo2被执行.....");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        // 对response对象响应消息增强
        System.out.println("filterDemo2回来了.......");
    }
}
