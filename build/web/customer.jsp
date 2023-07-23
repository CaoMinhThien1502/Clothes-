<%-- 
    Document   : customer1
    Created on : Jun 14, 2023, 9:44:34 AM
    Author     : thien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/css.css" rel="stylesheet">
    </head>
    <body>
        <%
            String email = (String) session.getAttribute("email");
            if (email == null) {
        %>
        <h1>pls login to view customer page</h1>
        <a href="login.jsp">Login</a>
        <%} else {
        %>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <div class="ContainerCustomer">
            
        </div>
        <%}%>
    </body>
</html>
