<%--
  Created by IntelliJ IDEA.
  User: 17822
  Date: 2022/8/10
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/JavaWeb/">
</head>
<body>
<form action="LoginServlet" method="get">
        name: <input type="text" name="username" value="${cookie.username.value}">
        password: <input type="text" name="password" id="">
    <input type="submit" value="登录">
</form>
</body>
</html>
