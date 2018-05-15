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
        Ways to sum to N using array elements with repetition
    </h2>
    The goal: To find how many ways we have to represent one number with a given array of numbers
</div>

<div id="task">
    <form action="/task5" method="post">
        <h4>Input: The positive integer- n</h4>
        <br>
        <input type="text" name="n">
        <br>
        Input: The array:
        <input type="text" name="array">
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
