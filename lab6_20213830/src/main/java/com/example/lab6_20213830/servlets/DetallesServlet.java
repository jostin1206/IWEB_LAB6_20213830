package com.example.lab6_20213830.servlets;

import com.example.lab6_20213830.beans.PeliculaB;
import com.example.lab6_20213830.daos.PeliculaDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DetallesServlet", value = "/DetallesServlet")
public class DetallesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String idPelicula = request.getParameter("idPelicula");

        // Crear una instancia de PeliculaDao
        PeliculaDao peliculaDao = new PeliculaDao();

        // Buscar la película con el idPelicula
        PeliculaB pelicula = peliculaDao.obtenerPorId(Integer.parseInt(idPelicula));

        // Establecer la película como un atributo de la solicitud
        request.setAttribute("pelicula", pelicula);

        // Reenviar la solicitud a la vista viewPelicula.jsp
        RequestDispatcher rd = request.getRequestDispatcher("peliculas/viewPelicula.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
