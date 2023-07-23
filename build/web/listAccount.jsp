<%-- 
    Document   : listAccount
    Created on : Jun 14, 2023, 8:19:34 AM
    Author     : thien
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dto.Account"%>
<%@page import="dao.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">  
        <link href="css/listAdmin.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <%@include file="admin_header.jsp" %>
        </header>
        <div class="list-acc">
            <table  border="1">
                <div class="search-input">
                    <form  action="mainController" method="post">
                        <input type="text" name="searchAccount" value="<%=(request.getParameter("searchAccount") == null) ? "" : request.getParameter("searchAccount")%>" placeholder="Enter email">
                        <input type="submit" name="action" value="searchAccount">
                    </form>
                </div>
                <thead>
                    <tr style="background-color: #bde3e1;">
                        <th>ID</th>
                        <th>EMAIL</th>
                        <th>FULLNAME</th>
                        <th>STATUS</th>
                        <th>PHONE</th>
                        <th>ROLE</th>
                        <th>ACTION</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Account> list = new ArrayList<>();
                        String search = request.getParameter("searchAccount");
                        if (search == null || search.equals("")) {
                            list = AccountDAO.getAccountListByEmail("");
                        } else {
                            list = AccountDAO.getAccountListByEmail(search);
                        }
                        for (Account l : list) {
                    %>

                    <tr>
                        <td><%=l.getAccID()%></td>
                        <td><%=l.getEmail()%></td>
                        <td><%=l.getFullname()%></td>
                        <td><%=l.getStatus() == 1 ? "Active" : "Inactive"%></td>
                        <td><%=l.getPhone()%></td>
                        <td><%=l.getRole() == 1 ? "Admin" : "User"%></td>
                        <td><a href="mainController?action=changeStatusAccount&email=<%=l.getEmail()%>&status=<%=l.getStatus()%>" style="font-weight: bold">Block/UnBlock</a></td>
                    </tr>

                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>
