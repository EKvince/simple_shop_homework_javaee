<%@ page import="javax.xml.transform.Result" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: EKVINC
  Date: 2021/4/26
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="DB" class="com.example.FirstJavaEEPro.DB"></jsp:useBean>
<html>
<head>
    <title>manage_page</title>
</head>
<body>
<form method="post" action="delepage.jsp">
<%
    DB.connect();
    ResultSet rs =DB.get_product();
    while(rs.next())
    {%>
<%--        <tr><%=rs.getInt("id")%></tr>--%>
        <tr><%=rs.getString("productCode")%></tr>
        <tr><%=rs.getString("productName")%></tr>
    <input type="checkbox" name="item" value = "<%=rs.getString("productName")%>"/><br/>
    <%}

%>
    <input type="submit" value="del"/>
</form>
<form method="post" action="add_page.jsp">
    id:<input type="text" name="id">
    productcode:<input type="text" name="productCode">
    productName:<input type="text" name="productName">
    <input type="submit" value="add"/>
</form>

<form method="post" action="add_user.jsp">
    id_user:<input type="text" name="id_user">
    username:<input type="text" name="username">
    password:<input type="text" name="password">
    <input type="submit" value="add_user"/>
</form>

<form method="post" action="dele_user.jsp">
    username:<input type="text" name="username">
    <input type="submit" value="dele_user"/>
</form>
<p><a href="shop.jsp">返回商店</a></p>
</form>
</body>
</html>
