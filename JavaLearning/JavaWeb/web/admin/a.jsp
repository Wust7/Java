<%--
  Created by IntelliJ IDEA.
  User: 17822
  Date: 2022/8/11
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
a.jsp
    <%
        System.out.println("运行到a.jsp");
        Object user = session.getAttribute("user");
        //如果等于null，说明还没有登录
        if(user==null){
            request.getRequestDispatcher("../login.jsp").forward(request,response);
            return;
        }
    %>

</body>
</html>
