
package main.java.Dao;
import main.java.modelo.Usuario;
import java.sql.*;
import java.time.LocalDate;
public class UsuarioDAO {
    public boolean existeUsuario(String nombre) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE nombre = ?";//Sentencia sql incompleta

        // Se hace un preparedStatement con la sentencia sql incompleta
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);// Se añade un String como nombre a la sentecia sql como comparador del campo nombre
            ResultSet rs = pstmt.executeQuery();// Se ejecuta la sentencia sql al completo
            rs.next();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.err.println("Error verificando usuario: " + e.getMessage());
            return false;
        }

    }

    public boolean altaUsuario(Usuario usuario) {

        // Comprobacion que el usuario existe en la base de datos y es mayor de edad
        if (existeUsuario(usuario.getNombre()) || !usuario.esMayorEdad()) {
            return false;
        }

        String sql = "INSERT INTO usuario (nombre, clave, fecha_nacimiento) VALUES (?, ?, ?)";//Sentencia sql incompleta

        // Se prepara la sentencia sql para un preparedStatement
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            //INSERCION DE DATOS A LA SENTENCIA SQL
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getClave());
            pstmt.setDate(3, Date.valueOf(usuario.getFechaNacimiento()));

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error alta usuario: " + e.getMessage());
            return false;
        }

    }

    public boolean bajaUsuario(String nombre, String clave) {
        String sql = "DELETE FROM usuario WHERE nombre = ? AND clave = ?";//Sentencia sql incompleta

        // Se prepara la sentencia sql para un preparedStatement
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            //INSERCION DE DATOS A LA SENTENCIA SQL
            pstmt.setString(1, nombre);
            pstmt.setString(2, clave);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error baja usuario: " + e.getMessage());
            return false;
        }

    }

    public boolean cambiarClave(String nombre, String nuevaClave) {
        String sql = "UPDATE usuario SET clave = ? WHERE nombre = ?";//Sentencia sql incompleta

        // Se prepara la sentencia sql para un preparedStatement
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            //INSERCION DE DATOS A LA SENTENCIA SQL
            pstmt.setString(1, nuevaClave);
            pstmt.setString(2, nombre);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error cambiar clave: " + e.getMessage());
            return false;
        }
    }

}

}
