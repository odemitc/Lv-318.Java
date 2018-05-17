<%--
  Created by IntelliJ IDEA.
  User: hpg6
  Date: 12.05.2018
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>
        .res{
            padding-left: 200px;
            margin: 50px;
        }
    </style>
</head>
<body>
<div class="res">
    <span class="badge badge-success"><h4>Success!</h4></span>  <%
    if (request.getAttribute("result") != null) {
        out.println("The result of calculation is " + "<b>"+ request.getAttribute("result")+ "</b>");
    } else out.println("<p> Try again please! </p>");
%>
    <a href="../index.html"><button type="button" class="btn">Back</button></a>
</div>



</body>
</html>
