<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>
        <title> Login page </title>
    </head>

    <body>
    <form action="<c:url value='/j_spring_security_check'/>" method="post">
        <fieldset>
            <legend> Information </legend>
            User: <input type="text" name="j_username">
            Password: <input type="password" name="j_password">
            Remember me <input type="checkbox" name="_spring_security_remember_me">
            <input type="submit" value="Log in">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </fieldset>
    </form>
    </body>

</html>
