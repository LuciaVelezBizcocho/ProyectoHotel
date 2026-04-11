
package main.java.Dao;

public class HabitacionDAO {

    public List<Habitacion> listarHabitaciones() {
        List<Habitacion> habitaciones = new ArrayList<>();// Creacion de la lista habitaciones

        //Sentencia sql
        String sql = """
            SELECT h.id, h.id_hotel, h.tiempo_alquiler, h.capacidad, h.precio
            FROM habitacion h
            JOIN hotel ho ON h.id_hotel = ho.id
            """;

        // Uso de la sentencia sql en la base de datos
        try (Connection conn = ConexionBD.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Se añade los campos de la base de datos y se añade al objeto hab
                Habitacion hab = new Habitacion(
                        rs.getInt("id"),
                        rs.getInt("id_hotel"),
                        rs.getInt("tiempo_alquiler"),
                        rs.getInt("capacidad"),
                        rs.getDouble("precio")
                );

                // Se añade la clase habitacion a la lista
                habitaciones.add(hab);
            }
        } catch (SQLException e) {
            System.err.println("Error listando habitaciones: " + e.getMessage());
        }
        //Devuelve la lista
        return habitaciones;
    }

    }

}
