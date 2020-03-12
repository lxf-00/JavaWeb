package servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Request 对象，获取请求消息体---请求参数
 */

@WebServlet("/requestDemo4")
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取字符流
        BufferedReader br = req.getReader();
        // 读取数据
        String line = null;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

    }
}
