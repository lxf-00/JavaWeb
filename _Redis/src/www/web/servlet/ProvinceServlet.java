package www.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import www.domain.Province;
import www.service.ProvinceService;
import www.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 0， 设置响应格式
        resp.setContentType("application/json;charset=utf-8");
        /*// 1， 调用方法：查找全部的省会
        ProvinceService service = new ProvinceServiceImpl();
        List<Province> provinces = service.findAll();
        // 2， 转换为Json格式，写出
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), provinces);*/

       // 使用redis缓存
       /* ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();

        resp.getWriter().write(json);*/


    }
}
