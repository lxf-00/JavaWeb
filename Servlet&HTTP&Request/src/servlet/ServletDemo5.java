package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * post 获取参数
 */
@WebServlet("/requestDemo5")
public class ServletDemo5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取存储的数据
        /*System.out.println("requestDemo5 被访问.........");
        Object msg = req.getAttribute("msg");
        System.out.println("存储的数据：" + msg);*/


        // 根据参数名称获取参数值
        String username = req.getParameter("username");
        // System.out.println("username:" + username);

        // 根据参数名称获取参数的数组
        String[] passwords = req.getParameterValues("password");
        /*for (String password : passwords) {
            System.out.println(password);
        }*/

        // 获取所有请求的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        /*while(parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println(s);
            String value = req.getParameter(s);
            System.out.println(value);
            System.out.println("-----------------");
        }*/

        // 获取所有参数的Map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 遍历
        Set<String> keysets = parameterMap.keySet();
        for (String key : keysets) {
            String[] strings = parameterMap.get(key);
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println("--------------------");
        }


    }
}