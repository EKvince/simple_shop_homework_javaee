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

@WebServlet(name = "Servlet_adduser",value ="/add_user-s")
public class Servlet_adduser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB DB=new DB();
        DB.connect();
        int id= Integer.parseInt(request.getParameter("id_user"));
        String username =request.getParameter("username");
        String password =request.getParameter("password");

        DB.add_user(id,username,password);
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>add_page</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<p><a href=\"shop.jsp\">返回商店</a></p>");
        response.getWriter().println("<body>");
        response.getWriter().println("</tr>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
