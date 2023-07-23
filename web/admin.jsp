<%-- 
    Document   : admin
    Created on : Jun 11, 2023, 12:22:07 PM
    Author     : thien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@include file="admin_header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/css.css" rel="stylesheet">
        <link href="css/admin-home.css" rel="stylesheet">
    </head>
    <body>
        <%
            String email = (String) session.getAttribute("email");
            String name = (String) session.getAttribute("name");
            if (name == null && email == null) {
        %>
        <h1>pls login to view Admin page</h1>
        <a href="login.jsp">Login</a>
        <%} else {
        %>
        <div>
            <%@include file="admin_header.jsp" %>
      </div>
        <div class="home-admin">
            <img src="images/background-admin.jpg" />
            <h1>Have a  fantastic day </h1>
        </div>
        <%}%>
    </body>
</html>
