package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 服务器输出书记到浏览器: 字符输出流
 */

@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取流对象之前，先设置流的默认编码方式：ISO-8859-1 设置为：GBK
        // resp.setCharacterEncoding("utf-8");
        // 告诉浏览器，服务器发送数据的编码，建议浏览器使用该编码解码
        // resp.setHeader("content-type", "text/html;charset=utf-8");

        // 简便设置编码形式
        resp.setContentType("text/html;charset=utf-8");

        // 获取字节输出流
        PrintWriter pw = resp.getWriter();
        // 输出数据
        pw.write("你好啊（来自response printwriter)");
    }
}
