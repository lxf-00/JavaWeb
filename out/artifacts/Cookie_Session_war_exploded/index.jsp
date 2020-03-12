<%--
  Created by IntelliJ IDEA.
  User: lxf
  Date: 2020/3/7
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
      System.out.println("hello jsp");
      int i = 5;
      String context_path = request.getContextPath();
      out.print(context_path);
    %>
    <%! int i = 3;%>
    <%="hello"%>
    <% response.getWriter().write("response....."); %>
  </body>
</html>
