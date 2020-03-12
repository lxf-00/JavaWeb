package www.userInfo.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 浏览器直接请求index.jsp资源时，该过滤器会被执行
// @WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)

// 只有转发访问index.jsp时，该过滤器才会被执行
// @WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)

// 浏览器直接访问index.jsp，或转发访问index.jsp，该过滤器执行
@WebFilter(value = "/index.jsp", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class FilterDemo4 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo4正执行.......");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
