<%-- 
    Document   : header
    Created on : May 25, 2023, 2:39:17 PM
    Author     : thien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/header.css" type="text/css" />
    </head>
    <body>
        <%
            String name = (String) session.getAttribute("name");
        %>
        <div class="menu">
            <ul class="item">
                <li><a href="index.jsp">Home</a></li>
 
                <li><a href="mainController?action=viewcart">View cart</a></li>  
                <%  Object getRole = session.getAttribute("role");
                if(getRole!=null){
                    int r = Integer.parseInt(getRole.toString());
                   if(r==0){
                %>
                <li><a href="myProfile.jsp">My Profile</a></li>
                <li><a href="historyOrder.jsp">History Orders</a></li>
                <%}}%>
            </ul>
            <ul class="item-login" >
                
                    <%
                        if (name != null) {
                    %>
                    <li><a href="myProfile.jsp" style="color: aquamarine"><%=name%></a><a href="mainController?action=logout">  /  Logout</a></li>
                    <%
                        } else{
                    %>
                    <li><a href="login.jsp">Login</a>     
                    <%}%>
                </li>
            </ul>


          

        </div>
    </body>
</html>
