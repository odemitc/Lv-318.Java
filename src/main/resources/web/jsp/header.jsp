<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="/styles/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="head">
    <div id="picture">
        <div id="form">
            <div id="text">
                Dynamic <br/>
                Programming
            </div>
            <div id="selector">
                <form action="/gettask" method="GET">
                    <select name="task">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                    </select>
                    <input type="submit" value="Go !"/>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
