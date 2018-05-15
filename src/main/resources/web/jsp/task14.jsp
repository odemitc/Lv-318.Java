<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 14</title>
    <link href="/styles/mian.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="description">
    <h2>
        Optimized painting fence: use one variable instead of a table
    </h2>
    The goal: Given a fence with n posts and k colors,
    find out the number of ways of painting the fence
    such that at most 2 adjacent posts have the same color.
    Both n and k are positive integers

</div>

<div id="task">
    <form action="/task14" method="post">
        <h4>Input: n</h4>
        <input type="text" name="countOfPosts">
        <h4>Input: k</h4>
        <input type="text" name="countOfColors">
        <br>
        <input id="button" type="submit" value="Go">
    </form>
</div>
<c:if test="${requestScope.output != null}">
    <div id="result" style="margin: 100px 170px">

        <h4>Output: <c:out value="${requestScope.output}"/></h4>
    </div>
</c:if>

</body>
</html>
