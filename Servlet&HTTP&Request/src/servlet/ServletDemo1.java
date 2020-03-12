package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 使用Servlet3.0 注解配置
 */

@WebServlet("/demo1")
public class ServletDemo1 implements Servlet {
    //生命周期方法:当Servlet第一次被创建对象时执行该方法,该方法在整个生命周期中只执行一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("----init------");
    }


    //生命周期方法:对客户端响应的方法,该方法会被执行多次，每次请求该servlet都会执行该方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo1....");
    }



    //生命周期方法:当Servlet被销毁时执行该方法
    @Override
    public void destroy() {
        System.out.println("-----destroy-----");
    }

    //当停止tomcat时也就销毁的servlet。
    @Override
    public ServletConfig getServletConfig(){
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }



}
