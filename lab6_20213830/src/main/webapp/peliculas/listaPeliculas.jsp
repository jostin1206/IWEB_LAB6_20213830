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
    <h1>Lista de películas</h1>

    <table>
        <tr>

            <th>Título</th>
            <th>Director</th>
            <th>Ano publicacion</th>
            <th>Raiting</th>
            <th>Box Office</th>
            <th>Genero</th>
            <th>Actores</th>


        </tr>
        <% for (PeliculaB peliculaB : lista){ %>
        <tr>
            <td><a href="DetallesServlet?idPelicula=<%= peliculaB.getIdPelicula() %>"><%= peliculaB.getTitulo() %></a></td>
            <td> <%=peliculaB.getDirector()%></td>
            <td> <%=peliculaB.getAnoPublicacion()%></td>
            <td>
                <div >
                    <p style="font-size: 20px; color: black; margin: 0;"><%= peliculaB.getRaiting() %>/10</p>
                </div>
            </td>
            <td> <%= String.format("$%,.0f", peliculaB.getBoxOffice()) %></td>
            <td> <%=peliculaB.getGenero()%></td>
            <td><a href="ActorServlet?idPelicula=<%= peliculaB.getIdPelicula() %>">Ver Actores</a></td>

        </tr>
        <% } %>

    </table>
    </body>

<body>

</body>
</html>
