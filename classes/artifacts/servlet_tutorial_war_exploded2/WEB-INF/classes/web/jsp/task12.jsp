<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 12</title>
    <link href="/styles/task12.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="description">
    <h2>
        Ways to tile the floor
    </h2>
    The goal:Given a floor of size n x m and tiles of size 1 x m.
    The problem is to count the number of ways to tile the given floor using 1 x m tiles.
    A tile can either be placed horizontally or vertically.


</div>

<div id="task">
    <form action="/task12" method="post">
        <h4>Input:a floor length - n which is integer</h4>
        <input type="text" name="n">
        <h4>Input: a floor width - m>= 2 which is integer</h4>
        <input type="text" name="m">
        <br>
        <input id="button" type="submit" value="Go">
    </form>
</div>
<c:if test="${requestScope.output != null}">
    <div id="result">
        <br>
        <h4>Output: <c:out value="${requestScope.output}"/></h4>
    </div>
</c:if>

</body>
</html>
