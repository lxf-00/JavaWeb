package com.userInfoSearch.web.servlet;

import com.userInfoSearch.domain.User;
import com.userInfoSearch.service.UserService;
import com.userInfoSearch.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        // 获取用户id参数
        int id = Integer.parseInt(req.getParameter("id"));
        // 调用方法，返回用户
        UserService us = new UserServiceImpl();
        User user =us.findById(id);

        // 存储user到request域中
        req.setAttribute("user", user);
        // 跳转到update.jsp页面
        req.getRequestDispatcher("/update.jsp").forward(req, resp);

    }
}
