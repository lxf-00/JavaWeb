<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  www.userInfo.domain.User: lxf
  Date: 2020/3/8
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
    el表达式： 简化jsp中的java代码：
    代码格式：${代码}
    忽视el代码：\${代码}
    --%>
    ${3 > 4}
    \${3>4}
    <hr>

    <h3>算术运算符</h3>
    ${3 + 4}<br>
    ${3 - 2}<br>
    ${3 * 2}<br>
    ${3 / 2}<br>
    div <br>
    ${3 div 4}<br>
    ${3 / 4}<br>
    ${7 mod 2}<br>

    <hr>
    <h3>比较运算符</h3>
    ${3 == 4}<br>
    <h3>逻辑运算符</h3>
    ${3 > 4 && 3 < 4}<br>
    ${3 > 4 || 3 < 4}<br>

    <hr>
    <h3>empty 运算符</h3>
    <%
        String str = "";
        request.setAttribute("str", str);
        List list = new ArrayList();
        request.setAttribute("list", list);
    %>
    ${not empty str}<br>
    ${not empty list}<br>





</body>
</html>
