<%--
  Created by IntelliJ IDEA.
  User: EKVINC
  Date: 2021/4/27
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="DB" class="com.example.FirstJavaEEPro.DB"></jsp:useBean>
<html>
<head>
    <title>add_page</title>
</head>
<body>
<%
    DB.connect();
    int id= Integer.parseInt(request.getParameter("id"));
    String productCode =request.getParameter("productCode");
    String productName =request.getParameter("productName");

    DB.add_product(id,productCode,productName);

%>
<p><a href="shop.jsp">返回商店</a></p>
</body>
</html>
