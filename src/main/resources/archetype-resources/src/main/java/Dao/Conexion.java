
package main.java.Dao;
import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost:3306/company_db";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS); // Devuelve el estado de la conexion de la base de datos
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }

}

    public static void desconectar() {
        if  (conn!= null ){
            conn.close();

        }

    }
}
