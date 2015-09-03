<%@page import="webapp2.Film"%>
<%@page language="java" pageEncoding="UTF-8" import="java.util.*" %>
<html>
    <head>
        <title>Название</title>
    </head>
    <body>
        <table border="1" width="303">
            <tr>
                <td width="119"><b>ID</b></td>
                <td width="168"><b>Название</b></td>
                <td width="168"><b>Описание</b></td>
                <td width="168"><b>Жанр</b></td>
                <td width="168"><b>Год</b></td>
            </tr>
            <%Iterator itr;%>
            <% ArrayList<Film> data = (ArrayList) request.getAttribute("data");
                for (Film film: data) {
                   
                   
            %>
            <tr>
                <td width="119"><%=film.id%></td>
                <td width="168"><%=film.name%></td>
                <td width="168"><%=film.desc%></td>
                <td width="168"><%=film.genre%></td>
                <td width="168"><%=film.year%></td>
                
            </tr>
            <%}%>
        </table>
    </body>
</html>
