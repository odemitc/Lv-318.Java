<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 6</title>
    <link href="/styles/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="description">
    <h2>
        Ways to write n as sum of two or more positive integers
    </h2>
    The goal: To find in how many ways is possible to calculate n with positive integers.
</div>

<div id="task">
    <form action="/task6" method="post">
        <h4>Input: The positive integer- n</h4>
        <br>
        <input type="text" name="n">
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
