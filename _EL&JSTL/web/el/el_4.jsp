<%--
  Created by IntelliJ IDEA.
  www.userInfo.domain.User: lxf
  Date: 2020/3/8
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>隐式对象</title>
</head>
<body>
    ${pageContext.request}
    <h3>在jsp页面动态获取虚拟目录</h3>
    ${pageContext.request.contextPath}
</body>
</html>
