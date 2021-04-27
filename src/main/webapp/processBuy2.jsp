<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<jsp:useBean id="DB" class="com.example.FirstJavaEEPro.DB"></jsp:useBean>

<%
    DB.connect();

//    int pid= Integer.parseInt(request.getParameter("id"));
    String productCode =request.getParameter("productCode");
    String productName =request.getParameter("productName");
    String[] del_list=request.getParameterValues("item");
    int id = (int) session.getAttribute("id");

    for(int i=0;i< del_list.length;i++)
    DB.updata(id,Integer.parseInt(del_list[i]),1);
//        System.out.println(del_list[i]);
%>
<p><a href="shop.jsp">ты╢н╧╨бР</a></p>

</body>

