<%-- 
    Document   : add
    Created on : 02.09.2015, 20:55:35
    Author     : Alexander
--%>

<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактирование данных пользователя</title>
    </head>
    <body>
        <h1>Данные пользователя</h1>
       <% User user = (User)request.getAttribute("user"); %>
        <form action="edit" method="post">
           Имя: <input type="text" name="name" value="<%=user.name%>"/>
           Фамилия: <input type="text" name="lastname" value="<%=user.lastname%>"/>
           Возраст: <input type="text" name="age" value="<%=user.age%>"/>
           <input type="hidden" name="id" value="<%=user.id%>"/>
           <input type="submit"/>
       </form>
    </body>
</html>