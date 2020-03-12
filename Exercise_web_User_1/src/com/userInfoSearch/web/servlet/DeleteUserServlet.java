package com.userInfoSearch.web.servlet;

import com.userInfoSearch.service.UserService;
import com.userInfoSearch.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 定义编码
        req.setCharacterEncoding("utf-8");
        // 获取参数:要删除的用户id
        int uid = Integer.parseInt(req.getParameter("id"));
        // 调用方法：删除该用户
        UserService us = new UserServiceImpl();
        us.deleteUser(uid);
        // 跳转到列表页
        resp.sendRedirect(req.getContextPath() + "/userListServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
