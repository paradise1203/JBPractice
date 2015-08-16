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

    <h4> Session id: ${sessionId} </h4>

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
        <ul>
            <c:forEach items="${tasks}" var="task">
                <li>
                    <c:out value="Task number ${task.index} : ${task.text}"/> <br> <br>
                </li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
