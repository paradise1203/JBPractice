<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${hasCookie}">

    <h3> Hello, ${cookie.name.value}! </h3>

    <form action="/list/clearUserInf" method="post">
        <input type="submit" value="Logout&clear">
    </form>

</c:if>

<c:if test="${!listIsEmpty}">
    <ol>
        <c:forEach items="${tasks}" var="task">
            <li>
                <c:out value="${task.task}"/> <br> <br>
            </li>
        </c:forEach>
    </ol>
</c:if>