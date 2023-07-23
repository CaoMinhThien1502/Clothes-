<%-- 
    Document   : login
    Created on : May 27, 2023, 11:45:14 AM
    Author     : thien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>
        <link rel="stylesheet" href="css/formlogin.css" type="text/css" />
    </head>
    <body>
        <section>
            <div class="form-box">
                <div class="form-value">

                    <form action="mainController" method="post">
                        <h2>Login</h2>
                        <div class="inputbox">
                            <ion-icon name="mail-outline"></ion-icon>
                            <input type="email" name="txtemail" required="">
                            <label for="txtemail">Email</label>
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="password" name="txtpassword" required="">
                            <label for="txtpassword">Password</label>
                        </div>
                        <div class="forget">
                            <label for="savelogin"><input type="checkbox" name="savelogin" value="savelogin">Remember me</label>
                        </div>
                        <input class="nutlogin" type="submit" value="login" name="action">
                        <div style="text-align: center; margin-top:25px"><font style='color: red;'><%=(request.getAttribute("mess") == null) ? "" : (String) request.getAttribute("mess")%></font></div>
                        <div class="register">
                            <p>Don't have a account <a href="registration.jsp"> Register</a></p>
                        </div>
                    </form>
                </div>             
            </div>
            <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
            <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
        </section>
    </body>
</html>
