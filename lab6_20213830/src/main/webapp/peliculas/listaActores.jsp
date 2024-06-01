<%@ page import="com.example.lab6_20213830.beans.ActorB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab6_20213830.beans.PeliculaB" %><%--
  Created by IntelliJ IDEA.
  User: josti
  Date: 31/05/2024
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //aqui va codigo java
    ArrayList<ActorB> lista = (ArrayList<ActorB>) request.getAttribute("Lista");
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


<table>
    <tr>
        <th>idActor</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Año Nacimiento</th>
        <th>Ganador Premio Oscar</th>
    </tr>
    <% for (ActorB actorB : lista) { %>
    <tr>
        <td><%= actorB.getIdActor() %></td>
        <td><%= actorB.getNombre() %></td>
        <td><%= actorB.getApellido() %></td>
        <td><%= actorB.getAnoNacimiento() %></td>
        <td><%= actorB.isGanoOscar() ? "True" : "False" %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
