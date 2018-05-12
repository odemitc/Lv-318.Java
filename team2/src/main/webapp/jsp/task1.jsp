<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 1</title>
    <link href="/styles/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="index.jsp"/>

<div id="task">
    <form action="/task1" method="post">
        Input position :
        <br>
        <input type="text" name="n">
        <br>
        <input type="submit" value="Go">
    </form>
</div>
<div> <c:out value="${requestScope.fib}"/> </div>


<div id="result">
    <c:if test="${requestScope.fib != null}">
        Output:
        <c:out value = "${requestScope.fib}"/>
    </c:if>
</div>

</body>
</html>
