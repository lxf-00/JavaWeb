package www.userInfo.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * Filter 注解配置
 * '@WebFilter("/index.jsp")'  拦截具体的路径的访问
 * '@WebFilter("/user/*")'  拦截目录下
 * '@WebFilter("*.jsp")'  后缀名拦截
 */

//@WebFilter("/hello.jsp")
public class FilterDemo3  implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("filterDemo3正在运行.....");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
