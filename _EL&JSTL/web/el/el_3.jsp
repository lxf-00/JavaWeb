<%@ page import="domain.www.userInfo.domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  www.userInfo.domain.User: lxf
  Date: 2020/3/8
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取数据</title>
</head>
<body>
    <%
        www.userInfo.domain.User user = new www.userInfo.domain.User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());

        request.setAttribute("u", user);

        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);

        request.setAttribute("list", list);

        Map map = new HashMap();
        map.put("sname", "李四");
        map.put("gender", "男");
        map.put("user", user);

        request.setAttribute("map",map);
    %>
    <h3>获取对象中的值</h3>
    ${requestScope.u}<br>
    ${requestScope.u.name}<br>
    ${u.age}<br>
    ${u.birthday}<br>
    ${u.birthday.month}<br>

    ${u.birStr}
    <hr>
    <h3>获取list对象中的数据</h3>
    ${list}
    ${list[0]}
    ${list[1]}
    ${list[2]}
    ${list[4]}

    <h3>el获取Map值</h3>
    ${map.gender}<br>
    ${map["gender"]}<br>
    ${map.user.name}

</body>
</html>
