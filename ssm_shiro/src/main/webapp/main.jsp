<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/9/3
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>主页面</title>
</head>
<body>

<h1>主页面</h1>
<a href="users/logout">退出登录</a>
<a href="logout">退出登录的第二种方式</a>
</body>
</html>
