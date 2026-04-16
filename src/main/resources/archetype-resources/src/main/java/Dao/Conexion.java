
package main.java.Dao;
import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost:3306/company_db"; // Direccion del servidor
    private static final String USER = "root"; // Usuario con la que se accede a la BBDD
    private static final String PASSWORD = "123456";// Contraseña del usuario
    private static Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    // Método por el que se conecta a la BBDD
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS); // Devuelve el estado de la conexion de la base de datos
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }

}
// Cerrar la conexion a la base de datos
    public static void desconectar() {
        if  (conn!= null ){
            conn.close();

        }

    }
}
