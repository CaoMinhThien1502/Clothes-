<%-- 
    Document   : customer
    Created on : Jun 11, 2023, 12:21:56 PM
    Author     : thien
--%>

<%@page import="dto.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.OrderDAO"%>
<%@page import="dao.AccountDAO"%>
<%@page import="dto.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/historyOrder.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <%
            String email = (String) session.getAttribute("email");

            if (name == null && email == null) {
        %>
        <h1>pls login to view Personal page</h1>
        <a href="login.jsp">Login</a>
        <%} else {
        %>
        <div style="padding-top: 100px">
            <table border="1">
                <thead>
                    <tr>

                        <th>Order Date</th>
                        <th>Ship Date</th>
                        <th>Order's status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <%
                    ArrayList<Order> list = OrderDAO.getOrders(email);
                    String[] status = {"", "Processing", "Completed", "Canceled"};
                    if (list != null && !list.isEmpty()) {
                        for (Order ord : list) {%>
                <tbody>
                    <tr>

                        <td><%=ord.getOrderDate()%></td>
                        <td><%=ord.getShipDate()%></td>
                        <td><%=status[ord.getStatus()]%>
                            <br/><%if (ord.getStatus() == 1) {%>
                            <a href="mainController?action=received&orderid=<%=ord.getOrderID()%>"><button>Received</button></a>
                            <a href="mainController?action=cancelOrder&orderid=<%=ord.getOrderID()%>"><button>Cancel order</button></a>
                            <%}%>
                        </td>
                        <td><a href="orderDetail.jsp?orderid=<%=ord.getOrderID()%>"><button>Detail</button></a>

                        </td>
                    </tr>
                </tbody>
                <%
                    }
                } else {
                %>
                <h1>order list is empty</h1>
                <%}%>
            </table>
        </div>




        <% }%>
    </body>

</html>