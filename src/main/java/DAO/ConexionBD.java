package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
    private static final String URL = "jdbc:mariadb://localhost:3306/gestion_hoteles";
    private static final String USER = "root";
    private static final String PASS = "123456"; // Cambiar por tu contraseña

    public static Connection getConexion() {

        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            return null;
        }

    }


}
