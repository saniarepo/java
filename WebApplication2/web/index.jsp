<%-- 
    Document   : index
    Created on : 31.08.2015, 21:59:41
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="/login" method="post">
            login: <input type="text" name="userId" />
            password: <input type="password" name="password" />
            <input type="submit" />
        </form>
    </body>
</html>
