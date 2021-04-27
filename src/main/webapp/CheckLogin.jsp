<%--
  Created by IntelliJ IDEA.
  User: EKVINC
  Date: 2021/4/23
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.net.URLEncoder" %>
<jsp:useBean id="DB" class="com.example.FirstJavaEEPro.DB"></jsp:useBean>
<html>
<head>
    <title>Checklogin</title>
</head>
<body>
<%
    Class.forName("com.mysql.cj.jdbc.Driver");//记载数据库驱动，注册到驱动管理器
    String url="jdbc:mysql://127.0.0.1:3306/shopdb?serverTimezone=UTC";
    String username_sql="root";
    String password_sql="root";
    Connection conn=DriverManager.getConnection(url,username_sql,password_sql);
//    if(conn!=null){
//    out.println("数据库连接成功！！！");
//    }
//    else{
//    out.println("数据库连接失败！！！");
//    }
    String username = request.getParameter("card");
    String password=  request.getParameter("password");
    DB.connect();
    PreparedStatement pStmt = conn.prepareStatement("select * from user where username = '"+ username+"' and password='"+password+"'");
    ResultSet rs =pStmt.executeQuery();
    if(rs.next()){
        int id = (int) rs.getObject("id");
        session.setAttribute("username",username);
        session.setAttribute("id",id);
        if(username.equals("ali"))
            response.sendRedirect("shop2.jsp");
        else
        response.sendRedirect("shop.jsp?username="+ URLEncoder.encode(username));
//        out.print("登录成功");
    }else
    {
        session.setAttribute("errMsg","登陆错误");
        response.sendRedirect("login.jsp?errNO");
//        out.print("登陆失败");

    }
//    rs.close();
//    pStmt.close();
//    conn.close();
%>
</form>
</body>
</html>
