<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 7</title>
    <link href="/styles/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="description">
    <h2>
        Ways to cover in 3 steps
    </h2>
    The goal: We want to calculate our possibility to cover the distance with 1, 2 and 3 steps.
</div>

<div id="task">
    <form action="/task7" method="post">
        <h4>Input: The distance- n which is integer bigger than 2.</h4>
        <br>
        <input type="text" name="distance">
        <input id="button" type="submit" value="Go">
    </form>
</div>
<c:if test="${requestScope.output != null}">
    <div id="result">
        <h4>Output: <c:out value = "${requestScope.output}"/></h4>
    </div>
</c:if>

</body>
</html>