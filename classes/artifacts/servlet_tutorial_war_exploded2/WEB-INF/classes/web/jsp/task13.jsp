<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 13</title>
    <link href="/styles/task12.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="description">
    <h2>
        Painting the fence
    </h2>
    The goal:Given a fence with n posts and k colors, find out the number of ways of painting
    the fence such that at most 2 adjacent posts have the same color.


</div>

<div id="task">
    <form action="/task13" method="post">
        <h4>Input: n posts - which is integer</h4>
        <input type="text" name="n">
        <h4>Input: k colors - which is integer</h4>
        <input type="text" name="k">
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