package com.example.FirstJavaEEPro;

import com.example.FirstJavaEEPro.DB;
import java.io.*;
import java.sql.*;
import java.sql.Date;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        DB DBcontrol = new DB();
        DBcontrol.connect();
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>shop page</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    public void destroy() {

    }
}