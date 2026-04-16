package DAO;

import DAO.ConexionBD;
import Modelo.Habitacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDAO {

    public List<Habitacion> listarHabitaciones() {
        List<Habitacion> habitaciones = new ArrayList<>();
        String sql = """
            SELECT h.id, h.id_hotel, h.tiempo_alquiler, h.capacidad, h.precio
            FROM habitacion h
            JOIN hotel ho ON h.id_hotel = ho.id
            """;

        try (Connection conn = ConexionBD.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Habitacion hab = new Habitacion(
                        rs.getInt("id"),
                        rs.getInt("id_hotel"),
                        rs.getInt("tiempo_alquiler"),
                        rs.getInt("capacidad"),
                        rs.getDouble("precio")
                );
                habitaciones.add(hab);
            }
        } catch (SQLException e) {
            System.err.println("Error listando habitaciones: " + e.getMessage());
        }
        return habitaciones;
    }
}
