package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase encargada de gestionar la conexión con la base de datos MariaDB.
 * Proporciona un método estático para obtener una conexión a la base de datos
 * de gestión de hoteles.
 *
 * @author Lucía, Adrián, Alberto y Antonio
 * @version 1.0
 */

public class ConexionBD {
    /** URL de conexión a la base de datos MariaDB */
    private static final String URL = "jdbc:mariadb://localhost:3306/gestion_hoteles";
    /** Usuario de la base de datos */
    private static final String USER = "root";
    /** Contraseña de la base de datos */
    private static final String PASS = "123456"; // Cambiar por tu contraseña

    /**
     * Obtiene una conexión activa a la base de datos.
     *
     * @return Objeto Connection conectado a la base de datos, o null si ocurre un error
     * @see java.sql.Connection
     */
    public static Connection getConexion() {

        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            return null;
        }

    }


}
