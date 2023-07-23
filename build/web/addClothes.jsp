<%-- 
    Document   : addClothes
    Created on : Jul 10, 2023, 10:47:33 PM
    Author     : thien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Add clothes</p>
        <form action="mainController" method="post">
            <table>
                <tr><td>Name</td><td><input type="text" name="name" required=""></td></tr>
                <tr><td>Price</td><td><input type="number" name="price" required=""></td></tr>
                <tr><td>Description</td><td><input type="text" name="des" required=""></td></tr>
                <tr><td>Type</td>
                    <td>
                        <select name="type">
                            <option value="shirt">Shirt</option>
                            <option value="jean">Jean</option>
                            <option value="jacket">Jacket</option>
                        </select>
                    </td></tr>
            </table>
            <button type="submit" name="action" value="addClothes">Add item</button>
        </form>
    </body>
</html>
