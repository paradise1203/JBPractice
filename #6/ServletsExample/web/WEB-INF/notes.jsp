<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aidar_2
  Date: 10.08.2015
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Notes </title>
</head>
<body>

<ul style="font-size: 25px">
    <c:forEach items="${notes}" var="note">
        <li>
            <c:out value="${note.txt}"/>
        </li>
    </c:forEach>
    <li>
        <form action="/add" method="post">
            <input name="txt" type="text">
            <input type="submit">
        </form>
    </li>
</ul>

</body>
</html>
