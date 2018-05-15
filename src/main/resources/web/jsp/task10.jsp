<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 10</title>
    <link href="/styles/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="description">
    <h2>
        The longest palindromic subsequence
    </h2>
    The goal: Given a string which we have to check how many symbols has the biggest palindrome
    which is included in the given one.
</div>

<div id="task">
    <form action="/task10" method="post">
        <h4>Input: String not more than 100 symbols </h4>
        <br>
        <input type="text" name="word">
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
