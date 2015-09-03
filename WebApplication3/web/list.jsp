<%-- 
    Document   : index
    Created on : 02.09.2015, 19:14:47
    Author     : Alexander
--%>

<%@page import="entities.User"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Пользователи</title>
    </head>
    <body>
        <h1>Список пользователей</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Возраст</th>
                <th></th>
            </tr>
            <%
                 ArrayList<User> data = (ArrayList) request.getAttribute("data");
                if (data != null){
                 for (User user: data) {
          %>
            <tr>
                <td width="119"><a href="edit?id=<%=user.id%>" title="Редактировать"><%=user.id%></a></td>
                <td width="168"><%=user.name%></td>
                <td width="168"><%=user.lastname%></td>
                <td width="168"><%=user.age%></td>
                <td><a href="del?id=<%=user.id%>">Удалить</a></td>
                 
            </tr>
            <%}
                
    }else{%>
    <tr><td colspan="4">Список пуст</td></tr>
            <%}%>
        </table>
        
            <p><a href="add">Добавить пользователя</a></p>   
        
    </body>
</html>
