package com.example.lab6_20213830.servlets;

import com.example.lab6_20213830.beans.ActorB;
import com.example.lab6_20213830.beans.PeliculaB;
import com.example.lab6_20213830.daos.ActorDao;
import com.example.lab6_20213830.daos.PeliculaDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ActorServlet", value = "/ActorServlet")
public class ActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String idPelicula = request.getParameter("idPelicula");
        ActorDao actorDao = new ActorDao();
        ArrayList<ActorB> list = actorDao.listarPorPelicula(Integer.parseInt(idPelicula));

        PeliculaDao peliculaDao = new PeliculaDao();
        PeliculaB pelicula = peliculaDao.obtenerPorId(Integer.parseInt(idPelicula));
        request.setAttribute("pelicula", pelicula);

        String vista = "peliculas/listaActores.jsp";
        request.setAttribute("Lista",list);

        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
