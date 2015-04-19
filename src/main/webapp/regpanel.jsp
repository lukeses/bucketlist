<%-- 
    Document   : regpanel
    Author     : Adam
--%>

<%@page import="java.util.List"%>
<%@page import="bucketlist.model.BucketlistUserInfo"%>
<%@page import="bucketlist.controller.BucketlistController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    </head>
    <body>

        <%

            BucketlistController controller = new BucketlistController();
            String email = (String) request.getParameter("email1");
            List<BucketlistUserInfo> user = controller.getUserByEmail(email);
            controller.CloseSession();

            if (email != null) {
                if (!user.isEmpty()) {
                    out.println("<div class='alert alert-danger' type='alert'>User does exist!</div>");
                } else {
                    controller = new BucketlistController();
                    controller.addNewUser((String) request.getParameter("fName"),
                            (String) request.getParameter("lName"),
                            (String) request.getParameter("email1"),
                            (String) request.getParameter("pass1"));
                    controller.CloseSession();
                    response.sendRedirect("logpanel.jsp");
                }
            }
        %>




        <div class="container-fluid">
            <section class="container">
                <div class="container-page">				
                    <div class="col-md-6">
                        <h3 class="dark-grey">Registration</h3>
                        <form method="POST">
                            <div class="form-group col-lg-6">
                                <label>First name</label>
                                <input type="text" name="fName" class="form-control" value="" required>
                            </div>
                            <div class="form-group col-lg-6">
                                <label>Last name</label>
                                <input type="text" name="lName" class="form-control" value="" required>
                            </div>

                            <div class="form-group col-lg-6">
                                <label>Password</label>
                                <input type="password" name="pass1" class="form-control" value="" required>
                            </div>

                            <div class="form-group col-lg-6">
                                <label>Repeat Password</label>
                                <input type="password" name="pass2" class="form-control" value="" required>
                            </div>

                            <div class="form-group col-lg-6">
                                <label>Email Address</label>
                                <input type="email" name="email1" class="form-control" value="" required>
                            </div>

                            <div class="form-group col-lg-6">
                                <label>Repeat Email Address</label>
                                <input type="email" name="email2" class="form-control" value="" required>
                            </div>			


                            <button type="submit" class="btn btn-primary">Register</button>
                        </form>
                    </div>
                </div>
            </section>
        </div>

    </body>
</html>
