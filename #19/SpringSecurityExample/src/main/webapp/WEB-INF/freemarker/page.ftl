<html>

    <head>
        <title> Login page </title>
    </head>

    <body>
        <form method="post" action="/j_spring_security_check">
            <fieldset>
                <legend> Information </legend>
                User: <input type="text" name="j_username">
                Password: <input type="password" name="j_password">
                Remember me <input type="checkbox" name="_spring_security_remember_me">
                <input type="submit" value="Log in">
            </fieldset>
        </form>
    </body>

</html>