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
    <title>shop page</title>
</head>
<body>
<form method="post" action="delepage.jsp">
    <%
        DB.connect();
        ResultSet rs =DB.get_product();
        while(rs.next())
        {%>
    <tr><%=rs.getInt("productCode")%></tr>
    <tr><%=rs.getString("productName")%></tr>
    <input type="checkbox" name="item" value = "<%=rs.getString("productName")%>"/><br/>
    <%}

    %>
    <input type="submit" value="del"/>
</form>
<p><a href="shop.jsp">返回商店</a></p>
</form>
</body>
</html>
