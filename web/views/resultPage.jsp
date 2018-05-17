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
</head>
<body>

    <h3>Result of calculation</h3>
<%
    if (request.getAttribute("result") != null) {
        out.println("<p> The result of calculation is " + request.getAttribute("result")+ " </p>");
    }


%>

</body>
</html>
