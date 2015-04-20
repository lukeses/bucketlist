<%-- 
    Document   : homePage
    Created on : 2015-04-20, 19:39:20
    Author     : lukasz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bucketlist.model.BucketlistListItem"%>
<%@page import="java.util.List"%>
<%@page import="bucketlist.model.BucketlistUserInfo"%>
<%@page import="bucketlist.controller.BucketlistController"%>

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

        <div class="span7">   
            <div class="widget stacked widget-table action-table">

                <div class="widget-header">
                    <i class="icon-th-list"></i>
                    <form class="form-inline" method="GET">
                        <div class="form-group col-lg-6">
                            <h3>Items</h3>
                        </div>
                        <input type="hidden" name="logout"  value="logout"/>
                        <div class="form-group col-lg-6">
                            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Logout</button> 
                        </div>

                    </form>
                </div> <!-- /widget-header -->

                <div class="widget-content">

                    <table class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Content</th>
                            </tr>
                        </thead>
                        <tbody>

                            <%
                                BucketlistController controller = new BucketlistController();
                                List<BucketlistListItem> items = controller.getAllItems();
                                controller.CloseSession();

                                for (BucketlistListItem item : items) {
                                    out.print("<tr><td>");
                                    out.print(item.getContent());
                                    out.print("</td>");
                                }
                            %>
                        </tbody>
                    </table>

                </div>

            </div> 
        </div>
    </body>
</html>