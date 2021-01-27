<%--
  Created by IntelliJ IDEA.
  User: adilb
  Date: 27.01.2021
  Time: 6:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="AuthServlet" method="post">
    Name:<input type="text" name="username"/><br/>
    Password:<input type="password" name="password"/><br/>
    <input type="submit" value="login">
    <a href="register.jsp">Register</a>
</form>
</body>
</html>
