<%-- 
    Document   : add
    Created on : 02.09.2015, 20:55:35
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавление пользователя</title>
    </head>
    <body>
        <h1>Данные пользователя</h1>
       <form action="add" method="post">
           Имя: <input type="text" name="name"/>
           Фамилия: <input type="text" name="lastname"/>
           Возраст: <input type="text" name="age"/>
           <input type="submit"/>
       </form>
    </body>
</html>
