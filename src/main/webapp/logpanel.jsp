<%-- 
    Document   : logpanel
    Author     : Adam
--%>

<%@page import="java.util.List"%>
<%@page import="bucketlist.model.BucketlistUserInfo"%>
<%@page import="bucketlist.controller.BucketlistController"%>
<%@page import="java.util.Enumeration"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bucketlist.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    </head>
    <body>
        <!-- <table width="100%" border="1" align="center">
             <tr bgcolor="#949494">
                 <th>Header Name</th><th>Header Value(s)</th>
             </tr> -->
        <%
            String email = (String) request.getParameter("inputEmail");
            
            if (email != null) {
                BucketlistController controller = new BucketlistController();
                List<BucketlistUserInfo> user = controller.getUserByEmail(email);
                controller.CloseSession();
                if (!user.isEmpty()) {
                    if (user.get(0).getPasswordHash().equals(request.getParameter("inputPassword"))) {
                        session.setAttribute("valid", new String("valid"));
                        Integer id = user.get(0).getId();
                        session.setAttribute("userID", new String(id.toString()));
                        response.sendRedirect("userItems.jsp");
                    } else {
                        out.println("<div class='alert alert-danger' type='alert'>Wrong password!</div>");
                    }

                } else {
                    out.println("<div class='alert alert-danger' type='alert'>User does not exist!</div>");
                }
            }
        %>
        <!--  </table> -->

        <div class="container">
            <div class="col-sm-4">
                <div class="card card-container">
                    <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
                    <p id="profile-name" class="profile-name-card"></p>
                    <form name="login_form" class="form-signin" method="POST">
                        <span id="reauth-email" class="reauth-email"></span>
                        <input type="email" name="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                        <input type="password" name="inputPassword" class="form-control" placeholder="Password" required>
                        <input id="btnLogin" name="btnLogin" class="btn btn-lg btn-primary btn-block btn-signin" type="submit" value="Sign in" />
                    </form>
                    <a href="regpanel.jsp"><button id="btnRegister" name="btnRegister" class="btn btn-lg btn-primary btn-block btn-signin">Register</button></a>
                </div>
            </div>
        </div>

    </body>
</html>
