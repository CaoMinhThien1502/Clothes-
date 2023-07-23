<%-- 
    Document   : allOrder
    Created on : Jun 14, 2023, 6:35:20 PM
    Author     : thien
--%>

<%@page import="dto.ManageOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/listAdmin.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <%@include file="admin_header.jsp" %>
        </header>
        <div class="list-order">
            <table border="1">
                <thead>
                    <tr  style="background-color: #bde3e1;">
                        <th>Order ID</th>
                        <th>Order Date</th>
                        <th>Ship Date</th>
                        <th>Status</th>
                        <th>Name of customer</th>
                        <th>Phone Number</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<ManageOrder> list = OrderDAO.getAlltOrder();
                        String[] status = {"", "Processing", "Completed", "Canceled"};
                        if (list != null && !list.isEmpty()) {
                            for (ManageOrder ord : list) {%>


                    <tr>
                        <td><%=ord.getOrderID()%></td>
                        <td><%=ord.getOrderDate()%></td>
                        <td><%=ord.getShipDate()%></td>
                        <td><%=status[ord.getStatus()]%></td>
                        <td><%=ord.getFullname()%></td>
                        <td><%=ord.getPhone()%></td>
                    </tr>

                    <%
                        }
                    } else {
                    %>
                <h1>order list is empty</h1>
                <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
