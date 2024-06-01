<%@ page import="com.example.lab6_20213830.beans.PeliculaB" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: josti
  Date: 31/05/2024
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //aqui va codigo java
    ArrayList<PeliculaB> lista = (ArrayList<PeliculaB>) request.getAttribute("Lista");

%>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <h1>Lista de películas</h1>
    <table>
        <tr>

            <th>Título</th>
            <th>Director</th>
            <th>Ano publicacion</th>
            <th>Raiting</th>
            <th>Box Office</th>
            <th>Genero</th>


        </tr>
        <% for (PeliculaB peliculaB : lista){ %>
        <tr>
            <td> <%=peliculaB.getTitulo()%> </td>
            <td> <%=peliculaB.getDirector()%></td>
            <td> <%=peliculaB.getAnoPublicacion()%></td>
            <td> <%=peliculaB.getRaiting()%></td>
            <td> <%=peliculaB.getBoxOffice()%></td>
            <td> <%=peliculaB.getGenero()%></td>


        </tr>
        <% } %>

    </table>
    </body>

<body>

</body>
</html>
