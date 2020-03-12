package com.userInfoSearch.web.servlet;

import com.userInfoSearch.service.UserService;
import com.userInfoSearch.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectUserServlet")
public class DelSelectUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String[] uids = req.getParameterValues("uid");

        UserService us = new UserServiceImpl();
        us.delSelectUser(uids);

        resp.sendRedirect(req.getContextPath() + "/userListServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
