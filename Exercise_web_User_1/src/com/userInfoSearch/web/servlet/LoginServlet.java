package com.userInfoSearch.web.servlet;

import com.userInfoSearch.domain.User;
import com.userInfoSearch.service.UserService;
import com.userInfoSearch.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("utf-8");
        // 获取数据
            // 获取用户填写的验证码
        String verifyCode = req.getParameter("verifycode");
        // 验证码校验
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        if(!checkcode_server.equalsIgnoreCase(verifyCode)){
            // 验证码不正确
            // 提示信息
            req.setAttribute("login_msg", "验证码错误");
            // 跳转到登录页
            req.getRequestDispatcher("login.jsp").forward(req, resp);

            return;
        }
        Map<String, String[]> map = req.getParameterMap();
        // 封装User对象
        User user = new User();
        try{
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }

        // 调用service 查询方法
        UserService us =  new UserServiceImpl();
        User loginUser = us.login(user);
        // 判断是否登录成功
        if(loginUser != null){
            // 登录成功
            // 将用户存入session
            session.setAttribute("user", loginUser);


            // 跳转页面
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }else{
            // 登录失败
            req.setAttribute("login_msg", "用户名或密码错误！");
            // 跳转到登录页
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
