<%--
  Created by IntelliJ IDEA.
  User: EKVINC
  Date: 2021/4/27
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="DB" class="com.example.FirstJavaEEPro.DB"></jsp:useBean>
<html>
<head>
    <title>quit</title>
</head>
<body>
<%
    DB.disconnect();
    session.invalidate();
    response.sendRedirect("login.jsp");
%>

</body>
</html>
