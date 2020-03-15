package www.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1， 获取用户名
        String username = req.getParameter("username");
        // 2， 调用service层判断用户名是否存在

        // 3， 设置响应的数据格式
        resp.setContentType("application/json;charset=utf-8");
        Map<String, Object> map = new HashMap<>();

        if("tom".equals(username)){
            // 存在
            map.put("userExist", true);
            map.put("msg", "用户名已存在.....");
        }else{
            //不存在
            map.put("userExist",false);
            map.put("msg","用户名可用");
        }
        //将map转为json，并且传递给客户端
        //将map转为json
        ObjectMapper mapper = new ObjectMapper();
        //并且传递给客户端
        mapper.writeValue(resp.getWriter(),map);
    }
}
