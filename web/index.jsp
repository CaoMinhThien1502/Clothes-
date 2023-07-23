<%-- 
    Document   : index
    Created on : May 25, 2023, 1:28:57 PM
    Author     : thien
--%>

<%@page import="dao.ClothesDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Clothes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/css.css" rel="stylesheet" >
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <div class="pageindex">
            <div class="containerIndex">
                <div class="imgblog">
                    <img src="images/blog.png" width="100%" height="500px" style="padding: 20px"> 
                </div>
                <h1 style="text-align: center; margin-top: 8px">SẢN PHẨM MỚI</h1>
                <form action="mainController" method="post" class="formsearch">
                    <input type="text" name="txtsearch" value="<%=(request.getParameter("txtsearch") == null) ? "" : request.getParameter("txtsearch")%>">
                    <select name="searchby">
                        <option value="byname">by name</option>
                        <option value="bycate">by category</option>
                    </select>
                    <input type="submit" value="search" name="action">
                </form>
                <%
                    String keyword = request.getParameter("txtsearch");
                    String searchby = request.getParameter("searchby");
                    String[] tmp = {"out of stock", "availble"};
                    ArrayList<Clothes> list;
                    if (keyword == null && searchby == null) {
                        list = ClothesDAO.getClothes("", "");
                    } else {
                        list = ClothesDAO.getClothes(keyword, searchby);
                    }
                    if (list != null && !list.isEmpty()) {
                %>
                <div class="product-list row align-items-start">   
                    <%
                        for (Clothes c : list) {
                    %>


                    <div class="box-card col-lg-3"> 
                        <div class="card " style="    margin-bottom: 10%;">
                            <a style="max-height: 300px;" <%if (c.getStatus() != 0) {%>href="mainController?action=clothesdetail&cid=<%=c.getClothesID()%>"<%}%>><img src=" <%=c.getImgPath()%>" style="  max-width: 100%; max-height: 100%;" class="card-img-top" alt=""></a>               
                            <div class="card-body">
                                <h5 class="card-title" style="text-align: center;    font-size: 1.5rem;"><%=c.getClothesName()%></h5>
                                <div style="
                                     display: flex;
                                     justify-content: space-around;
                                     margin-top: 7%;
                                     white-space: nowrap;">
                                    <h3 style="    font-size: 1.2rem"><span style="    color: red;
                                                                            margin-right: 1%;
                                                                            font-weight: 700;">$</span><%=c.getPrice()%></h3>
                                    <h4 style="    font-size: 1.2rem"><%=tmp[c.getStatus()]%></h4></div>
                                <p class="card-text" style="text-align: center"><%=c.getTypeName()%></p>
                                <%if (c.getStatus() == 0) { %>
                                <%} else {%>
                                <a class="btn btn-primary" href="mainController?action=clothesdetail&cid=<%=c.getClothesID()%>" style=" padding: 4px;
                                   background-color: black;
                                   color: white;
                                   text-decoration: none;
                                   /* text-transform: uppercase; */
                                   text-align: center;
                                   font-weight: 600;
                                   width: 100%;
                                   font-size: 19px;">View Item</a>
                                <%} %>
                            </div>
                        </div>
                    </div>
                    <%
                        } %>
                </div>
                <%  }%>
            </div>
        </div>

        <%@include file="footer.jsp" %>

    </body>
</html>
