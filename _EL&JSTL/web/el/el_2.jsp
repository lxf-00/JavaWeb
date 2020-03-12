<%--
  Created by IntelliJ IDEA.
  www.userInfo.domain.User: lxf
  Date: 2020/3/8
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 在域中存储数据
        session.setAttribute("name", "张三");
        request.setAttribute("name", "李四");
        session.setAttribute("age", "23");
        request.setAttribute("str", "");
    %>
    <h3>获取值</h3>
    ${requestScope.name}
    ${sessionScope.name}
    ${sessionScope.haha}

    ${name}
</body>
</html>
