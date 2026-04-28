package DAO;

import DAO.ConexionBD;
import Modelo.Habitacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object para la gestión de las operaciones relacionadas
 * con las habitaciones en la base de datos.
 *
 * @author Lucía, Adrián, Alberto y Antonio
 * @version 1.0
 */
public class HabitacionDAO {
    /**
     * Lista todas las habitaciones disponibles en el sistema,
     * incluyendo información del hotel asociado mediante JOIN.
     *
     * @return Lista de objetos Habitacion con los datos de cada habitación.
     *         Si no hay conexión o ocurre un error, retorna una lista vacía.
     * @see Habitacion
     */
    public List<Habitacion> listarHabitaciones() {
        List<Habitacion> habitaciones = new ArrayList<>();
        String sql = "SELECT h.id, h.id_hotel, h.tiempo_alquiler, h.capacidad, h.precio " +
                "FROM habitacion h " +
                "JOIN hotel ho ON h.id_hotel = ho.id";

        try{
            Connection conn = ConexionBD.getConexion();
            if (conn == null) {
                System.err.println("No se pudo obtener conexión.");
                return habitaciones;
            }
                     Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sql);
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
