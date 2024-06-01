package com.example.lab6_20213830.daos;

import com.example.lab6_20213830.beans.PeliculaB;

import java.sql.*;
import java.util.ArrayList;

public class PeliculaDao {

    public ArrayList<PeliculaB> listar(){

        ArrayList<PeliculaB> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql = "SELECT \n" +
                "\tp.idPelicula,\n" +
                "    p.titulo, \n" +
                "    p.director, \n" +
                "    p.anoPublicacion, \n" +
                "    p.rating, \n" +
                "    p.boxOffice as boxOffice, \n " +
                "    g.nombre AS Genero\n" +
                "FROM \n" +
                "    Pelicula p\n" +
                "JOIN \n" +
                "    Genero g ON p.idGenero = g.idGenero\n" +
                "ORDER BY \n" +
                "    p.rating DESC, \n" +
                "    p.boxOffice DESC;";

        try (Connection conn = DriverManager.getConnection(url,username,password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){

                PeliculaB peliculaB = new PeliculaB();

                peliculaB.setIdPelicula(rs.getInt(1));
                peliculaB.setTitulo(rs.getString(2));
                peliculaB.setDirector(rs.getString(3));
                peliculaB.setAnoPublicacion(rs.getString(4));
                peliculaB.setRaiting(rs.getDouble(5));
                peliculaB.setBoxOffice(rs.getDouble(6));
                peliculaB.setGenero(rs.getString(7));
                lista.add(peliculaB);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }



    public PeliculaB obtenerPorId(int id) {
        PeliculaB pelicula = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql = "SELECT \n" +
                "    p.idPelicula,\n" +
                "    p.titulo,\n" +
                "    p.director,\n" +
                "    p.anoPublicacion,\n" +
                "    p.rating,\n" +
                "    p.boxOffice,\n" +
                "    g.nombre AS Genero\n" +
                "FROM \n" +
                "    Pelicula p\n" +
                "JOIN \n" +
                "    Genero g ON p.idGenero = g.idGenero\n" +
                "WHERE \n" +
                "    p.idPelicula = ?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    pelicula = new PeliculaB();
                    pelicula.setIdPelicula(rs.getInt(1));
                    pelicula.setTitulo(rs.getString(2));
                    pelicula.setDirector(rs.getString(3));
                    pelicula.setAnoPublicacion(rs.getString(4));
                    pelicula.setRaiting(rs.getDouble(5));
                    pelicula.setBoxOffice(rs.getDouble(6));
                    pelicula.setGenero(rs.getString(7));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pelicula;
    }

}
