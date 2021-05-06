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

@WebServlet(name = "Servlet_delepage",value = "/delepage-s")
public class Servlet_delepage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB DB=new DB();
        int id=0;
        int msg=-2;
        DB.connect();
        String[] del_list=request.getParameterValues("item");
//    if(del_list!=null){
//        for (String item : del_list)
//        {
////            id=DB.get_product_id(item);
////            DB.DEl_product(id);
//        }
        if(del_list!=null)
        {
            for(int i=0;i< del_list.length;i++)
            {
                id=DB.get_product_id(del_list[i]);
//            System.out.println(id);
                DB.DEl_product(id);
//            System.out.println(msg);
//            System.out.println(del_list[i]);
            }
        }
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
