<%-- 
    Document   : admin_header
    Created on : Jun 14, 2023, 7:23:49 AM
    Author     : thien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/admin-home.css" rel="stylesheet">
    </head>
    <body>
        <div class="nav-admin">
            <ul>
                <li><a href="mainController?action=manageAccount">Account</a></li>
                <li><a href="mainController?action=manageOrder">Orders</a></li>
                <li><a href="mainController?action=manageClothes">Clothes</a></li>
                <li><a href="mainController?action=logout">Logout</a></li>
            </ul>
        </div>

    </body>
</html>
