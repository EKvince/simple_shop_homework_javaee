package com.example.FirstJavaEEPro;

import java.sql.*;
import java.sql.Date;
import java.io.*;


public class DB {
    private Connection conn;
    private String userID;
//    int id=0;

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//记载数据库驱动，注册到驱动管理器
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url="jdbc:mysql://127.0.0.1:3306/shopdb?serverTimezone=UTC";
        String username_sql="root";
        String password_sql="root";
        try {
            conn= DriverManager.getConnection(url,username_sql,password_sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public int updata(int userId,int productID,int number){
        int id=get_maxid()+1;
//        System.out.println(id);
        Date time= new Date(new java.util.Date().getTime());
        try {
            PreparedStatement ptmt=conn.prepareStatement("insert into shop_records (id,userId,productId,number,shopDate) values(?,?,?,?,CURRENT_DATE()); ");
            ptmt.setInt(1,id);
            ptmt.setInt(2,userId);
            ptmt.setInt(3,productID);
            ptmt.setInt(4,number);

            ptmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
        return -1;
    }
    public int get_maxid(){
        try {
            PreparedStatement ptmt=conn.prepareStatement("select count(*) from shop_records;");
            ResultSet rs =ptmt.executeQuery();
            if(rs.next())
            return rs.getInt("count(*)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
    public void setUserID(String ID){
        userID=ID;
    }
    public void disconnect(){
        if (conn!=null)
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public ResultSet history(int uid){
        PreparedStatement ptmt= null;
        try {
            ptmt = conn.prepareStatement("SELECT * FROM shop_records where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(shopDate) and userId =?;");
            ptmt.setInt(1,uid);
            ResultSet rs =ptmt.executeQuery();
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public ResultSet history_count(int uid,int productid){
        PreparedStatement ptmt= null;
        try {
            ptmt = conn.prepareStatement("SELECT count(productId) FROM shop_records where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(shopDate) and productId=? and userId=?;");
            ptmt.setInt(1,productid);
            ptmt.setInt(2,uid);
            ResultSet rs =ptmt.executeQuery();
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public ResultSet history_count2(int uid){
        PreparedStatement ptmt= null;
        try {
            ptmt = conn.prepareStatement("SELECT productName,COUNT(productId) FROM product,shop_records where shop_records.productId=product.id and userId=? GROUP BY productId;");
            ptmt.setInt(1,uid);
            ResultSet rs =ptmt.executeQuery();
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;


    }
    public ResultSet get_product(){
        PreparedStatement ptmt= null;
        try {
            ptmt = conn.prepareStatement("SELECT * FROM product ");
            ResultSet rs =ptmt.executeQuery();
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public int DEl_product(int pid){
        PreparedStatement ptmt= null;
        try {
            ptmt = conn.prepareStatement("DELETE FROM product WHERE id=?");
            ptmt.setInt(1,pid);
            ptmt.execute();
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
    public int get_product_id(String productname){
        PreparedStatement ptmt= null;
        try {
            ptmt = conn.prepareStatement("SELECT * FROM product WHERE productName=?;");
            ptmt.setString(1,productname);
            ResultSet rs =ptmt.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
    public void add_product(int id,String productcode,String productname){
        try {
            PreparedStatement ptmt=conn.prepareStatement("insert into product (id,productCode,productName) values(?,?,?); ");
            ptmt.setInt(1,id);
            ptmt.setString(2,productcode);
            ptmt.setString(3,productname);

            ptmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void add_user(int id,String username,String password){
        try {
            PreparedStatement ptmt=conn.prepareStatement("insert into user (id,username,password) values(?,?,?); ");
            ptmt.setInt(1,id);
            ptmt.setString(2,username);
            ptmt.setString(3,password);

            ptmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void del_user(String username){
        PreparedStatement ptmt= null;
        try {
            ptmt = conn.prepareStatement("DELETE FROM user WHERE username=?");
            ptmt.setString(1,username);
            ptmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }
}
