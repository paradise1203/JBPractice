<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aidar_2
  Date: 13.08.2015
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

    <form action="/additionForm" method="post">
        <input type="text" name="firstNumber">
        <input type="text" name="secondNumber">
        <input type="submit" value="Summarize">
    </form>

    <br>

    <c:if test="${result}">
        <c:out value="${firstNumber+secondNumber}" />
    </c:if>

</body>
</html>
