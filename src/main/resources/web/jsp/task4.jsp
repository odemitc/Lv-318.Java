<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 4</title>
    <link href="/styles/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="description">
    <h2>
        Longest subsequence with difference one
    </h2>
    The goal: To find how many numbers we have with difference one in the maximum sub sequence
</div>

<div id="task">
    <form action="/task4" method="post">
        <h4>Input: Sequence with integer numbers separate only by ",". Example: 3,4,7,8,9</h4>
        <br>
        <input type="text" name="seq">
        <input id="button" type="submit" value="Go">
    </form>
</div>
<c:if test="${requestScope.output != null}">
    <div id="result">
        <h4>Output: <c:out value="${requestScope.output}"/></h4>
    </div>
</c:if>

</body>
</html>
