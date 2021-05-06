<%--
  Created by IntelliJ IDEA.
  User: EKVINC
  Date: 2021/3/31
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="DB" class="com.example.FirstJavaEEPro.DB"></jsp:useBean>
<html>
<head>
    <title>Login</title>
    <style>
        #p1{
            background: rgba(255, 255, 255, 0.8);
            width: 300px;
            height: 220px;
            position: absolute;
            top: 50%;
            left: 50%;
            margin: -110px 0 0 -150px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #login{
            margin-left: 20px;

        }
    </style>
</head>
<body background="bg2.jpg">
<div id="p1">
    <div id="p2">
        <table align=center >
            <form id="form1" method="post" action="http://localhost:8080/FirstJavaEEPro_war_exploded/login_check_serverlet">
                <tr>
                    <td>
                        用户名(管理员账号为ali
                    </td>
                    <td>
                        <input type="text" name="card">
                    </td>
                </tr>
                <tr>
                    <td>
                        密码
                    </td>
                    <td>
                        <input type="password" name="password">
                    </td>
                </tr>
                <tr id="register">
                    <td><input type="submit" value="登录" ></td>
                </tr>
            </form>
        </table>
    </div>
</div>
<%//显示登录错误信息
    Object errMsg = session.getAttribute("errMsg");
    if(errMsg != null){%>
<div style="color:#ff0000;text-align:center"><%=errMsg%></div>
<%session.removeAttribute("errMsg");}%>
</body>
</html>
