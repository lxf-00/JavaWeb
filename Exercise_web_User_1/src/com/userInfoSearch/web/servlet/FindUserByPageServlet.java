package com.userInfoSearch.web.servlet;

import com.userInfoSearch.domain.PageBean;
import com.userInfoSearch.domain.User;
import com.userInfoSearch.service.UserService;
import com.userInfoSearch.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1, 获取参数: 当前页码，每页显示条数
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        // 2 校验参数
        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }

        if(rows == null || "".equals(rows)){
            rows = "5";
        }
        // 2.1 获取参数：查询条件参数
        Map<String, String[]> condition = req.getParameterMap();
        System.out.println("currentPage:" + currentPage+";rows:"+rows+";map:"+condition );
        // 3 业务处理： 
        UserService us = new UserServiceImpl();
        PageBean<User> pb = us.findUserByPage(currentPage, rows, condition);

        System.out.println(pb);
        //3.将PageBean存入request
        req.setAttribute("pb",pb);
        req.setAttribute("condition",condition);//将查询条件存入request
        //4.转发到list.jsp
        req.getRequestDispatcher("/list.jsp").forward(req,resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
