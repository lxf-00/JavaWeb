package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext
 * servlet 上下文
 * 域对象：共享数据
 * 可以读取全局配置参数
 * 可以搜索当前工程目录下面的资源文件
 * 可以获取当前工程名字（了解）
 */
@WebServlet("/requestDemo7")
public class ServletDemo7 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ServletContext获取方式一：
        /*ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);*/

        // ServletContext方式二：
        ServletContext context = this.getServletContext();



          /*

            ServletContext功能：
               1. 获取MIME类型：
                * MIME类型:在互联网通信过程中定义的一种文件数据类型
                    * 格式： 大类型/小类型   text/html		image/jpeg

                * 获取：String getMimeType(String file)
                2. 域对象：共享数据
                3. 获取文件的真实(服务器)路径
         */
          // 定义文件名称
        String filename = "a.jpg";
        // 获取 MIME类型
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType); // imag/jpeg

        // 设置共享数据
        context.setAttribute("msg", "hah");
    }
}
