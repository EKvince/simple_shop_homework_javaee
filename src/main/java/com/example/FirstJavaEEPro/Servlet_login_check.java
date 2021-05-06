package com.example.FirstJavaEEPro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.example.FirstJavaEEPro.DB;
import jakarta.servlet.http.HttpSession;

import java.io.*;
import java.net.URLEncoder;
import java.sql.*;

@WebServlet(name = "Servlet_login_check",value = "/login_check_serverlet")
public class Servlet_login_check extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url="jdbc:mysql://127.0.0.1:3306/shopdb?serverTimezone=UTC";
        String username_sql="root";
        String password_sql="root";
        Connection conn= null;
        try {
            conn = DriverManager.getConnection(url,username_sql,password_sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HttpSession session = request.getSession();
        String username = request.getParameter("card");
        String password=  request.getParameter("password");
        PreparedStatement pStmt = null;
        try {
            pStmt = conn.prepareStatement("select * from user where username = '"+ username+"' and password='"+password+"'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = pStmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(rs.next()){
                int id = (int) rs.getObject("id");
                session.setAttribute("username",username);
                session.setAttribute("id",id);
                if(username.equals("ali"))
                    response.sendRedirect("shop2_serverlet.jsp");
                else
                    response.sendRedirect("shop_serverlet.jsp?username="+ URLEncoder.encode(username));
    //        out.print("登录成功");
            }else
            {
                session.setAttribute("errMsg","登陆错误");
                response.sendRedirect("login.jsp?errNO");
    //        out.print("登陆失败");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>登录信息</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("欢迎【】用户登录成功！sdadasdsad！！");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
