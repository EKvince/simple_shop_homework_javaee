<%--
  Created by IntelliJ IDEA.
  User: EKVINC
  Date: 2021/4/27
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="DB" class="com.example.FirstJavaEEPro.DB"></jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    DB.connect();
    String username=request.getParameter("username");
    System.out.println(username);
    DB.del_user(username);

%>
</body>
</html>
