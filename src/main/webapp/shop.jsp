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
<%--<form method="post" action="processBuy.jsp">--%>
<%--    book:<input type="checkbox" name="item" value="book"/><br/>--%>
<%--    电脑：<input type="checkbox" name="item" value="computer"/><br/>--%>
<%--    汽车：<input type="checkbox" name="item" value="car"/><br/>--%>
<%--    <input type="submit" value="购买"/>--%>
<%--</form>--%>

<form method="post" action="processBuy2.jsp">
    <%
        DB.connect();
        ResultSet rs =DB.get_product();
        while(rs.next())
        {%>
    <tr><%=rs.getInt("productCode")%></tr>
    <tr><%=rs.getString("productName")%></tr>
    <input type="checkbox" name="item" value = "<%=rs.getInt("id")%>"/><br/>
    <%}

    %>
    <input type="submit" value="buy"/>
</form>
<form action="history.jsp">
    <input type="submit" value="历史">
</form>
<form action="quit.jsp">
    <input type="submit" value="退出">
</form>
</body>
</html>
