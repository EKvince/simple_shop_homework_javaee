<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<jsp:useBean id="DB" class="com.example.FirstJavaEEPro.DB"></jsp:useBean>

<%
    //ȡ��session��Χ��itemMap����
    Map<String,Integer> itemMap = (Map<String,Integer>)session.getAttribute("itemMap");

//���Map����Ϊ�գ����ʼ��Map����
    if (itemMap == null)
    {
        itemMap = new HashMap<>();
        itemMap.put("�鼮" , 0);
        itemMap.put("����" , 0);
        itemMap.put("����" , 0);
    }
    DB.connect();
//��ȡ�ϸ�ҳ����������
    String[] buys = request.getParameterValues("item");
    String user= (String) session.getAttribute("username");
    int user_id= (int) session.getAttribute("id");
//��������ĸ�Ԫ��
    if(buys!=null){
        for (String item : buys)
        {
            //���itemΪbook����ʾѡ�����鼮
            if(item.equals("book"))
            {
                int num1 = itemMap.get("�鼮").intValue();
                //���鼮key��Ӧ��������1
                itemMap.put("�鼮" , num1 + 1);
                DB.updata(user_id,1,1);
            }
            //���itemΪcomputer����ʾѡ�������
            else if (item.equals("computer"))
            {
                int num2 = itemMap.get("����").intValue();
                //������key��Ӧ��������1
                itemMap.put("����" , num2 + 1);
                DB.updata(user_id,2,1);
            }
            //���itemΪcar����ʾѡ��������
            else if (item.equals("car"))
            {
                int num3 = itemMap.get("����").intValue();
                //������key��Ӧ��������1
                itemMap.put("����" , num3 + 1);
                DB.updata(user_id,3,1);
            }
        }
    }
//��itemMap����ŵ����ó�session��Χ��itemMap����
    session.setAttribute("itemMap" , itemMap);
%>


<head>
    <title> �������Ʒ�б� </title>
    <meta name="website" />
</head>
<body>
�����������Ʒ��<br/>
�鼮��<%=itemMap.get("�鼮")%>��<br/>
���ԣ�<%=itemMap.get("����")%>̨<br/>
������<%=itemMap.get("����")%>��
<p><a href="shop.jsp">�ٴι���</a></p>

</body>

