<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10.04.20
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<h3>Welcome</h3>

<hr>
${sessionScope.user.firstName}, hello!<br>
Your role is: ${sessionScope.user.role}
<br>
<a href="controller?command=logout">Logout</a>
</body>
</html>
