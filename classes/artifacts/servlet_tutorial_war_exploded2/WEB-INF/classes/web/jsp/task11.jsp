<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 11</title>
    <link href="/styles/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="description">
    <h2>
        Friend pairs
    </h2>
    Goal: Given n friends, each one can remain single or can be paired up with some other friend.
    Each friend can be paired only once.
    Find out the total number of ways in which friends can remain single or can be paired up.
</div>

<div id="task">
    <form action="/task11" method="post">
        <h4>Input: Number of friends- n integer. </h4>
        <br>
        <input type="text" name="number">
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
