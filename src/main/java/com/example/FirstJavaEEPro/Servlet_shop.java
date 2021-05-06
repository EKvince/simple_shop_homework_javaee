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

@WebServlet(name = "Servlet_shop",value = "/processBuy2-s")
public class Servlet_shop extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB DBcontrol= new DB();
        DBcontrol.connect();
        HttpSession session = request.getSession();
//    int pid= Integer.parseInt(request.getParameter("id"));
        String productCode =request.getParameter("productCode");
        String productName =request.getParameter("productName");
        String[] del_list=request.getParameterValues("item");
        int id = (int) session.getAttribute("id");

        for(int i=0;i< del_list.length;i++)
            DBcontrol.updata(id,Integer.parseInt(del_list[i]),1);
        response.getWriter().println("<p><a href=\"shop.jsp\">再次购买</a></p>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>error type</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("asdsadasda！！");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}