<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 9</title>
    <link href="/styles/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="description">
    <h2>
        Work to be with High-effort or with Low-effort
    </h2>
    The goal: We have n days and for each day (d) you could either perform
    a high effort tasks (hi) or a low effort tasks (li) or no task with the constraint
    (it is written 0) that you can choose a high-effort tasks only if you chose no task on the previous day.
    Write a program to find the maximum amount of cost you can perform within these n days.
</div>

<div id="task">
    <form action="/task9" method="post">
        <h4>The number of days- n which is integer. </h4>
        <br>
        <input type="text" name="n">

        <h4>The cost of low effort work (f.e :  1, 5, 4, 3) </h4>
        <br>
        <input type="text" name="low">

        <h4>The cost of high effort work (f.e. : 3, 6, 8, 7, 6) </h4>
        <br>
        <input type="text" name="high">


        <input id="button" type="submit" value="Go">
    </form>
</div>
<c:if test="${requestScope.output != null}">
    <div id="result" style="margin: 170px 170px ">
        <h4>Output: <c:out value = "${requestScope.output}"/></h4>
    </div>
</c:if>