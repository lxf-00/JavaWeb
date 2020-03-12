package servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Request 设置编码流
 * 转发资源
 * 存储资源
 */
@WebServlet("/requestDemo6")
public class ServletDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("utf-8");

        // 转发资源访问
        System.out.println("requestDemo6 被访问.....");
        /*RequestDispatcher requestDispatcher = req.getRequestDispatcher("/requestDemo5");
        requestDispatcher.forward(req, resp);*/


        // 存储数据到request 域中
        req.setAttribute("msg", "hello");
        req.getRequestDispatcher("/requestDemo5").forward(req, resp);

    }
}
