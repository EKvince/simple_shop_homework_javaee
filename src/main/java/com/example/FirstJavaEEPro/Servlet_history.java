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

@WebServlet(name = "Servlet_history",value = "/history-s")
public class Servlet_history extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB DB=new DB();
        DB.connect();
        HttpSession session = request.getSession();
        int user_id= (int) session.getAttribute("id");
        ResultSet rs = DB.history(user_id);
        ResultSet rs2 = DB.history_count2(user_id);


        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>历史信息</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println(" <table border=\"1\">");
        response.getWriter().println("<tr>");
        response.getWriter().println("<td>productID</td>");
        response.getWriter().println("<td>shopDate</td>");
        response.getWriter().println("</tr>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            response.getWriter().println("<tr>");
            try {
                response.getWriter().println("<td>"+rs.getInt("productId")+"</td>");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                response.getWriter().println("<td>"+rs.getDate("shopDate")+"</td>");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            response.getWriter().println("/<tr>");
        }

        while(true)
        {
            try {
                if (!rs2.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            response.getWriter().println("<tr>");
            try {
                response.getWriter().println("<td>"+rs2.getString("productName")+"</td>");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                response.getWriter().println("<td>"+rs2.getInt("COUNT(productId)")+"</td>");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            response.getWriter().println("/<tr>");
        }

        response.getWriter().println("</table>");
    }
}
