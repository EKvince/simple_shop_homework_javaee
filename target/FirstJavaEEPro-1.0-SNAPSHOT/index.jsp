<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<%
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");//记载数据库驱动，注册到驱动管理器
        String url="jdbc:mysql://127.0.0.1:3306/shopdb?serverTimezone=UTC";
        String username="root";
        String password="root";
        Connection conn=DriverManager.getConnection(url,username,password);
//        Con=DriverManager.getConnection(url,user,password);
        if(conn!=null){
            out.println("数据库连接成功！！！");
        }else{
            out.println("数据库连接失败！！！");
        }
    }catch(ClassNotFoundException e){
        e.printStackTrace();
    }


//    Class.forName("com.mysql.jdbc.Driver");//记载数据库驱动，注册到驱动管理器
//    Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shopdb?serverTimezone=UTC","root","root");
//    if(!conn.isClosed())
//    {
//        out.print("hell!");
//    }
%>
</body>
</html>