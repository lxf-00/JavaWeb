package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示Request对象获取请求行数据
 */

@WebServlet("/requestDemo1")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的方式
        String method = req.getMethod();
        System.out.println("请求的方式：" + method);

        System.out.println("---------------------------");
        // 获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println("虚拟目录：" + contextPath);

        System.out.println("---------------------------");
        // 获取servlet路径
        String servletPath = req.getServletPath();
        System.out.println("servlet路径：" + servletPath);

        // 获取（get/post)方式请求参数
        String queryString = req.getQueryString();
        System.out.println("参数：" + queryString);

        // 获取请求的URI
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("统一资源标识符：" + requestURI);
        System.out.println("统一资源定位符：" + requestURL);

        // 获取协议及其版本
        String protocol = req.getProtocol();
        System.out.println("协议版本：" + protocol);

        // 获取客户机的ip地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println("客户端ip:" + remoteAddr);

        // 0:0:0:0:0:0:0:1是ipv6的表现形式，对应ipv4来说相当于127.0.0.1，也就是本机

    }
}
