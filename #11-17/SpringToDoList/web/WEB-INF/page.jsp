<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ToDo</title>
    <script type="text/javascript" src="/resources/jquery-2.1.4.js"> </script>
    <script type="text/javascript">

        function doAjax() {

            var firstName = $("#firstName").val();
            var task = $("#task").val();

            if (task.length<=10) {
                alert("Sorry, too few words");
                return;
            }

            $.ajax({
                url: 'list',
                type: 'POST',
                data: {
                    task: task,
                    firstName: firstName
                },
                success: function (response) {
                    $("#subView").html(response);
                }
            });
        }
    </script>
</head>
<body>

<div id="subView">

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

</div>

<form method="post">
    <fieldset>
        <legend> Task: </legend>
        <c:if test="${!hasCookie}">
            Enter your name, please: <input type="text" id="firstName"> <br> <br>
        </c:if>
        <textarea id="task" rows="10" cols="45"> </textarea> <br>
        <input type="button" value="Save" onclick="doAjax()">
    </fieldset>
</form>

</body>
</html>
