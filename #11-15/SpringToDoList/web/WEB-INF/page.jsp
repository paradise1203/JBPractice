<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ToDo</title>
</head>
<body>

    <c:if test="${hasCookie}">
        <h3> Hello, ${cookie.name.value}! </h3>
    </c:if>

    <form action="/list/clearUserInf" method="post">
        <input type="submit" value="Logout&clear">
    </form>

    <form action="/list" method="post">
        <fieldset>
            <legend> Task: </legend>
            <c:if test="${!hasCookie}">
                Enter your name, please: <input type="text" name="firstName"> <br> <br>
            </c:if>
            <textarea name="task" rows="10" cols="45"> </textarea> <br>
            <input type="submit" value="Save">
        </fieldset>
    </form>

    <c:if test="${!listIsEmpty}">
        <ol>
            <c:forEach items="${tasks}" var="task">
                <li>
                    <c:out value="${task.task}"/> <br> <br>
                </li>
            </c:forEach>
        </ol>
    </c:if>
</body>
</html>
