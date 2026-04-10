
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

}

    public static void desconectar() {
        

    }
}
