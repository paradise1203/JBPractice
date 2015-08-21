<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ToDo</title>
    <script type="text/javascript" src="/resources/jquery-2.1.4.js"> </script>
    <script type="text/javascript">
        function doAjaxPostAndLogin() {
            var firstName = $("#firstName").val();
            var task = $("#task").val();

            if (task.length <= 10) {
                alert("Sorry, but your task should contain of more than 10 letters");
                return;
            }

            $.ajax({
                url: 'list',
                type: 'POST',
                data: {
                    task: task,
                    firstName: firstName
                },
                success: function () {
                    var tasks=$('#tasks');
                    tasks.append("<li>" + task + "</li>" + "<br>");
                    tasks.slideDown();
                    if (firstName!=null && firstName.length!=0) {
                        var greeting=$('#greeting');
                        greeting.text("Hello, " + firstName + "!");
                        greeting.slideDown();
                        $('#logout').slideDown();
                        $('#login').hide();
                    }
                }
            });
        }
    </script>
    <script type="text/javascript">
        function doAjaxLogout() {
            $.ajax({
                url: 'list/clearUserInf',
                type: 'POST',
                success: function (response) {
                    $('#greeting').hide();
                    $('#logout').hide();
                    $('#login').slideDown();
                    $('#tasks').hide();
                }
            });
        }
    </script>
</head>
<body>

    <h3 id="greeting">
        <c:if test="${hasCookie}">
            Hello, ${cookie.name.value}!
        </c:if>
    </h3>

    <form id="logout" method="post"
            <c:if test="${!hasCookie}">
                style="display:none"
            </c:if> >
        <input type="button" value="Logout&clear" onclick="doAjaxLogout()">
    </form>

    <form method="post">
        <fieldset>
            <legend> Task: </legend>
            <div id="login"
                    <c:if test="${hasCookie}">
                        style="display:none"
                    </c:if> >
                Enter your name, please: <input type="text" id="firstName" > <br> <br>
            </div>
            <textarea id="task" rows="10" cols="45"> </textarea> <br>
            <input type="button" value="Save" onclick="doAjaxPostAndLogin()">
        </fieldset>
    </form>

    <ol id="tasks">
        <c:forEach items="${tasks}" var="task">
            <li>
                <c:out value="${task.task}"/> <br> <br>
            </li>
        </c:forEach>
    </ol>

</body>
</html>
