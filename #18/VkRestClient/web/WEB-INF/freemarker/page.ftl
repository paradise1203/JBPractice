<html>

    <head>
        <title> Rest-client </title>
    </head>

    <body>
        <form action="http://oauth.vk.com/authorize?client_id=5042953&display=popup&redirect_uri=http://localhost:8080/login&scope=audio&response_type=code&v=5.37"
              method="post">
            <input type="submit" value="Login vk">
        </form>

        <#if token??>
        <p> Token information: ${token} </p>
        </#if>

        <#if audios??>
        <p> Audio information: ${audios} </p>
        </#if>

        <#if deleteRes??>
            <p> Delete was successful: ${deleteRes} </p>
        </#if>

    </body>

</html>