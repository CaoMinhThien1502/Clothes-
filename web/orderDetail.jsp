<%-- 
    Document   : orderDetail
    Created on : Jun 13, 2023, 10:26:55 PM
    Author     : thien
--%>

<%@page import="dto.OrderDetail"%>
<%@page import="dao.OrderDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css.css" rel="stylesheet">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/css.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <div class="containerOrderDetail">
            <% String orderid = request.getParameter("orderid");
                if (orderid != null) {
                    int orderID = Integer.parseInt(orderid.trim());
                    ArrayList<OrderDetail> list = OrderDAO.getOrderDetail(orderID);
                    if (list != null && !list.isEmpty()) {
                        int money = 0;
                        for (OrderDetail detail : list) {%>

            <table class="order" width="100%" border="1">
                <tr>
                    <td>Clothes Name</td>
                    <td>Image</td>
                    <td>Price</td>
                    <td>quantity</td>
                </tr>
                <tr>
                    <td><%=detail.getClothesName()%></td>
                    <td><img src='<%=detail.getImgPath()%>' class='plantimg' style="width: 100px" /></td>
                    <td><%=detail.getPrice()%></td>
                    <td><%=detail.getQuantity()%></td>
                    <% money = money + detail.getPrice() * detail.getQuantity(); %>
                    
                </tr>

            </table>
            <%          }%>
            <h3>Total money: <%= money%></h3>
            <%      } else {
            %>
            <p>You don't have any order</p>
            <%
                    }
                }
            %>  
        </div>
    </body>
</html>
