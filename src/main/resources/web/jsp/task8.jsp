<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 8</title>
    <link href="/styles/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="description">
    <h2>
        Paths without crossing
    </h2>
    The goal: Program to count number of ways to connect n (where n is even) points on a circle
    such that no two connecting lines cross each other and every point is connected with one other point.
</div>

<div id="task">
    <form action="/task8" method="post">
        <h4>Input:number of points - where n is an even and integer</h4>
        <br>
        <input type="text" name="n">
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