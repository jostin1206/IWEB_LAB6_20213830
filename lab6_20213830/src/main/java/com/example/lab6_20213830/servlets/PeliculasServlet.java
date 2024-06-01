package com.example.lab6_20213830.servlets;

import com.example.lab6_20213830.beans.PeliculaB;
import com.example.lab6_20213830.daos.PeliculaDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PeliculasServlet", value = "/PeliculasServlet")
public class PeliculasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // Hello
        PeliculaDao peliculaDao = new PeliculaDao();
        ArrayList<PeliculaB> list = peliculaDao.listar();

        String vista = "peliculas/listaPeliculas.jsp";
        request.setAttribute("Lista",list);

        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
