package com.userInfoSearch.web.servlet;

import com.userInfoSearch.domain.User;
import com.userInfoSearch.service.UserService;
import com.userInfoSearch.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码方式
        req.setCharacterEncoding("utf-8");
        // 获取参数：map集合
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

        // 调用方法：更新用户信息
        UserService us = new UserServiceImpl();
        us.updateUser(user);

        // 跳转到列表页
        resp.sendRedirect( req.getContextPath() + "/userListServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
