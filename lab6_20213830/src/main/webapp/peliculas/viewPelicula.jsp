<%@ page import="com.example.lab6_20213830.beans.PeliculaB" %><%--
  Created by IntelliJ IDEA.
  User: josti
  Date: 31/05/2024
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Aquí va código java
    PeliculaB pelicula = (PeliculaB) request.getAttribute("pelicula");
%>

<html>
<head>
    <title><%= pelicula.getTitulo() %></title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>


</head>

<body>

<h1><%= pelicula.getTitulo() %></h1>

<table>
    <tr>
        <th>idPelicula</th>
        <td><%= pelicula.getIdPelicula() %></td>
    </tr>
    <tr>
        <th>Director</th>
        <td><%= pelicula.getDirector() %></td>
    </tr>
    <tr>
        <th>Año Publicacion</th>
        <td><%= pelicula.getAnoPublicacion() %></td>
    </tr>
    <tr>
        <th>Rating</th>
        <td><%= pelicula.getRaiting() %>/10</td>
    </tr>
    <tr>
        <th>BoxOffice</th>
        <td><%= String.format("$%,.0f", pelicula.getBoxOffice()) %></td>
    </tr>
    <tr>
        <th>Genero</th>
        <td><%= pelicula.getGenero() %></td>
    </tr>
    <tr>
        <th>Actores</th>
        <td><a href="ActorServlet?idPelicula=<%= pelicula.getIdPelicula() %>">Ver Actores</a></td>
    </tr>
</table>

</body>
</html>
