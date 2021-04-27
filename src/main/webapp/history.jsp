<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: EKVINC
  Date: 2021/4/26
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="DB" class="com.example.FirstJavaEEPro.DB"></jsp:useBean>
<html>
<head>
    <title>history</title>
</head>
<body>
    <%
        DB.connect();
        int user_id= (int) session.getAttribute("id");
        ResultSet rs = DB.history(user_id);
        ResultSet rs2 = DB.history_count2(user_id);
    %>

    <table border="1">
        <tr>
            <td>productID</td>
            <td>shopDate</td>
        </tr>
        <%
            while(rs.next())
            {%>
    <tr>
        <td><%=rs.getInt("productId") %></td>
        <td><%=rs.getDate("shopDate") %></td>
    </tr>
            <%}
        %>
        <%
            while(rs2.next())
            {%>
        <tr>
            <td><%=rs2.getString("productName") %></td>
            <td><%=rs2.getInt("COUNT(productId)") %></td>
        </tr>
        <%}
        %>
<%--    <td>商品1:<%=rs1.getInt("count(productId)")%></td>--%>
<%--        <td>商品2:<%=rs2.getInt("count(productId)")%></td>--%>
<%--        <td>商品3:<%=rs3.getInt("count(productId)")%></td>--%>
    </table>

</body>
</html>
