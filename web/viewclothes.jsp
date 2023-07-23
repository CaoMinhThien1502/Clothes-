<%-- 
    Document   : viewclothes
    Created on : Jun 11, 2023, 12:58:18 PM
    Author     : thien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dao.ClothesDAO"%>
<%@page import="dto.Clothes"%>
<%@page import="dao.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/css.css" rel="stylesheet">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link href="css/viewClothes.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <style>
            *{
                box-sizing: border-box;
                margin: 0;
                padding: 0
            }
            .productdetail{
                padding-top: 100px;
            }
        </style>
        <% int cid = Integer.parseInt(request.getParameter("cid"));
            Clothes c = ClothesDAO.getClothes(cid);
        %>
        <div style="background-color:#e8e8e8">
            <div class="container productdetail">
                <div class="row" style="margin: 100px;
                     border: 1px solid #d4d1d154;
                     background-color: #ffffff52;
                     border-radius: 14px;">
                    <div class="col-6" style="    padding: 40px;">
                        <div>
                            <img style="width: 100%"  src='<%=c.getImgPath()%>' />
                        </div>
                    </div>
                    <div class="col-6" style=" position: relative;   padding: 40px;">
                        <h3 style="    font-size: 2.5rem;
                            font-family: sans-serif;
                            font-weight: 700;"><%=c.getClothesName()%></h3>
                        <h3 style="    font-size: 1.5rem;
                            color: #00000057;
                            margin-left: 5%;"><%=c.getDescription()%></h3>
                        <div style="    margin-top: 63%;
                             display: flex;
                             justify-content: space-around;">
                            <h3><span style="    color: red;
                                      margin-right: 1%;
                                      font-weight: 700;">$</span><%=c.getPrice()%></h3>
                            <h4><%=c.getStatus() == 1 ? "Avaible" : "Out of stock"%></h4></div>
                        <a style="  
                           width: 85%;
                           position: absolute;
                           bottom: 9%;
                           padding: 10px;
                           background-color: black;
                           color: white;
                           text-decoration: none;
                           text-transform: uppercase;
                           text-align: center;
                           font-weight: 700;
                           font-size: 19px;
                           " href="mainController?action=addtocart&cid=<%=c.getClothesID()%>">Add to cart</a>
                    </div>
                </div>
            </div>
        </div>
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
                    background-color:black;
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