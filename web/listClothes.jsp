<%-- 
    Document   : listClothes
    Created on : Jun 15, 2023, 12:59:50 PM
    Author     : thien
--%>

<%@page import="dao.ClothesDAO"%>
<%@page import="dto.Clothes"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/listAdmin.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <%@include file="admin_header.jsp" %>
        </header>
        <div class="list-clothes">
            <form action="mainController" method="post">
                <input type="text" name="searchClothes" value="<%=(request.getParameter("searchAccount") == null) ? "" : request.getParameter("searchAccount")%>" placeholder="Enter category">
                <input type="submit" name="action" value="searchClothes">
            </form>
            <a href="addClothes.jsp" style="text-decoration: none;background-color: black;color: white">Add new item</a>
            <table border="1" width="100%">
                <thead>
                    <tr>
                        <th style="width:100px">Clothes ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Image</th>
                        <th>Description</th>
                        <th>Status</th>
                        <th>Type Name</th>
                        <th>Active</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <%
                    ArrayList<Clothes> list = new ArrayList<>();
                    String search = request.getParameter("searchClothes");
                    if (search == null || search.equals("")) {
                        list = ClothesDAO.getClothes("");
                    } else {
                        list = ClothesDAO.getClothes(search);
                    }
                    for (Clothes c : list) {
                %>
                <tbody>
                <form action="mainController" method="post">
                    <tr>
                        <td><input type="text" name="clothesid" value="<%=c.getClothesID()%>" readonly="" style="width:100px"></td>
                        <td><input type="text" name="newName" value="<%=c.getClothesName()%>"></td>
                        <td><input type="text" name="newPrice" value="<%=c.getPrice()%>" min="0"></td>
                        <td><img src='<%=c.getImgPath()%>' class='plantimg' style="width: 100px;"></td>
                        <td><input type="text" name="newDes" value="<%=c.getDescription()%>"></td>
                        <td><input type="text"  name="status" value="<%=c.getStatus() == 1 ? "Active" : "Inactive"%>" readonly=""></td>
                        <td><input type="text"  value="<%=c.getTypeName()%>" readonly=""></td>
                        <td><input type="submit" name="action" value="blocked"></td>
                        <td><input type="submit" name="action" value="updateClothes"></td>
                    </tr>
                </form>
                </tbody>
                <% }%>
            </table>
        </div>
    </body>
</html>
