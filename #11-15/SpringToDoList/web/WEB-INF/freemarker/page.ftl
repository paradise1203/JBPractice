<html>
    <head>
        <title>ToDo</title>
    </head>
    <body>
        <form action="/list" method="post">
            <fieldset>
                <legend> Task: </legend>
                <textarea name="task" rows="10" cols="45"> </textarea> <br>
                <input type="submit" value="Save">
            </fieldset>
        </form>

        <#if listIsEmpty==false>
            <ul>
                <#list tasks as task>
                    <li> Task number ${task.index} : ${task.text}</li> <br>
                </#list>
            </ul>
        </#if>
    </body>
</html>
