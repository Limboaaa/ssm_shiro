<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/9/3
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<html>
<head>
<base href="<%=basePath%>">
    <title>登录页</title>
</head>
<body>
<form action="users/login" method ="post">
    <table align="center" width="900px">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2">
                <div style="color:red;font-size: 12px;">${msg}</div>
            </td>
        </tr>
        <td colspan="2">
            <input type="submit"/>
        </td>
    </table>
</form>
</body>
</html>
