<%-- 
    Document   : viewcart
    Created on : May 28, 2023, 10:34:12 PM
    Author     : thien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dao.ClothesDAO"%>
<%@page import="dto.Clothes"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/css.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <div class="containerViewcart">
            <form action="mainController" method="post">
                <table style="width: 100%; padding: 20px" class="shopping" width="100%" border=1px>
                    <%
                        HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");
                        int money = 0;
                        if (cart != null && cart.size() > 0) {
                            Set<String> cids = cart.keySet();
                            for (String cid : cids) {
                                int quantity = cart.get(cid);
                                Clothes c = ClothesDAO.getClothes(Integer.parseInt(cid));
                                if (c.getStatus() == 1) {
                                    if (c != null) {
                    %>
                    <tbody>
                        <tr>
                            <td>Name: <%=c.getClothesName()%></td>
                            <td>Quantity:<input type="number" value="<%=quantity%>" min="0" name="quantity" required="" ></td>
                            <td>Price: <%=c.getPrice()%></td>
                            <td><input type="hidden" value="<%=cid%>" name="cid"><a href="getClothesServlet?cid=<%=cid%>"><img src="<%=c.getImgPath()%>" class="plantimg"></a></td>
                            <td><input style="color: white;
                                       cursor: pointer;
                                       background-color: #285ce7;
                                       padding: 10px;
                                       font-size: 1rem;
                                       font-weight: 500;
                                       width: 100%;
                                       border: none;
                                       letter-spacing: 1px;" type="submit" value="update" name="action"></td>
                            <td><input  style="color: white;
                                        cursor: pointer;
                                        background-color: #e70d0d;
                                        padding: 10px;
                                        font-size: 1rem;
                                        font-weight: 500;
                                        width: 100%;
                                        border: none;
                                        letter-spacing: 1px;" type="submit" value="delete" name="action"</td>
                        </tr>
                    </tbody>
                    <% money = money + c.getPrice() * quantity;
                        }
                    %>

                    <%
                            }
                        }
                    %>
                </table>
            </form>         
            <footer class="viewcartpay">
                <p>Total money: <%=money%></p>
                <p>Order Date: <%= new java.util.Date()%></p>
                <form action="mainController" method="post">
                    <button type="submit" value="saveOrder" name="action" class="submitorder" style="color: white;
                            cursor: pointer;
                            background-color: burlywood;
                            padding: 10px;
                            font-size: 1rem;
                            font-weight: 500;
                            width: 100%;
                            border: none;
                            letter-spacing: 1px;">Save order</button>
                </form>
            </footer>
        </div>  
        <%  } else {
        %>
        <p>Your cart is empty</p>
        <%
            }
        %>
    <c:if test="${mess != null}">
        <div id="notification" class="notification">
            <p>${mess}</p>
        </div>
        <style>
            .notification {
                display: flex;
                justify-content: center;
                align-items: center;
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                padding: 20px;
                background-color: black;
                color: white;
                font-weight: bold;
                opacity: 1;
                transition: opacity 0.5s ease;
            }
            .notification.hide {
                opacity: 0;
            }
        </style>
        <script>
            window.addEventListener('DOMContentLoaded', function () {
                var notification = document.getElementById('notification');
                setTimeout(function () {
                    notification.classList.add('hide');
                }, 3000);
            });
        </script>
    </c:if>
    
</body>
</html>