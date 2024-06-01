package com.example.lab6_20213830.daos;

import com.example.lab6_20213830.beans.ActorB;

import java.sql.*;
import java.util.ArrayList;

public class ActorDao {

    public ArrayList<ActorB> listarPorPelicula(int idPelicula) {
        ArrayList<ActorB> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql = "SELECT \n" +
                "    a.idActor,\n" +
                "    a.Nombre,\n" +
                "    a.Apellido,\n" +
                "    a.anoNacimiento,\n" +
                "    a.premioOscar\n" +
                "FROM \n" +
                "    Actor a\n" +
                "JOIN \n" +
                "    Protagonistas p ON a.idActor = p.idActor\n" +
                "WHERE \n" +
                "    p.idPelicula = ?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPelicula);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ActorB actorB = new ActorB();
                    actorB.setIdActor(rs.getInt(1));
                    actorB.setNombre(rs.getString(2));
                    actorB.setApellido(rs.getString(3));
                    actorB.setAnoNacimiento(rs.getInt(4));
                    actorB.setGanoOscar(rs.getBoolean(5));
                    lista.add(actorB);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
