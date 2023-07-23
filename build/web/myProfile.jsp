<%-- 
    Document   : myProfile
    Created on : Jun 13, 2023, 7:15:59 PM
    Author     : thien
--%>

<%@page import="dto.Account"%>
<%@page import="dao.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link href="css/myprofile.css" rel="stylesheet">
    </head>
    <header>
        <%@include file="header.jsp" %>
    </header>
    <body>
        <%
            String email = (String) session.getAttribute("email");

            Account acc = AccountDAO.getAccountByEmail(email);
            if (email != null) {
        %>
        <div style="      
             width: 100%;
             min-height: 100vh;
             padding-top: 100px;
             background-color: #e0e0e0ba;
             ">
            <div style="    width: 650px;
                 height: 450px;
                 border: 1px solid #c7c7c7;
                 padding: 16px;
                 margin: 50px auto;
                 background-color: white;
                 border-radius: 18px;
                 box-shadow: 1px 1px 7px 0px #0000009e;">
                <h1 style="font-size: 2rem;
                    padding-bottom: 20px;
                    border-bottom: 1px solid #a79797;">My Profile</h1>    
                <form action="mainController" method="post" style="padding: 0 30px;">
                    <table class="table" style="width: 100%; margin-top: 20px;">
                        <tr>
                            <td>Fullname</td>
                            <td><input type="text" name="newName" value="<%=acc.getFullname()%>"</td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><input type="text" name="email" value="<%=acc.getEmail()%>" readonly=""></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="newPass" value="<%=acc.getPassword()%>"></td>
                        </tr>

                        <tr>
                            <td>Phone</td>
                            <td><input type="number" name="newPhone" value="<%=acc.getPhone()%>"></td>
                        </tr>
                        <tr>

                            <td><input style="    background: #f15c28;
                                       color: white;
                                       padding: 7px;
                                       font-size: 17px;
                                       font-weight: 500;
                                       border: none;
                                       border-radius: 6px;" type="submit" name="action" value="updateProfile"></td>
                        </tr>                              
                    </table> 
                        <p style="color: red;text-align: center;counter-reset: ">${mess}</p>
                </form>
            </div>
        </div>
        <% }%>   
    </body>
</html>