<%--
  Created by IntelliJ IDEA.
  User: EKVINC
  Date: 2021/4/27
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="DB" class="com.example.FirstJavaEEPro.DB">
</jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
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

%>
<p><a href="shop.jsp">返回商店</a></p>
</body>
</html>
