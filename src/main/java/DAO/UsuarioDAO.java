package DAO;

import Modelo.Usuario;
import java.sql.*;
/**
 * Data Access Object para la gestión de operaciones relacionadas
 * con los usuarios en la base de datos.
 *
 * @author Lucía, Adrián, Alberto y Antonio
 * @version 1.0
 */
public class UsuarioDAO {
    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param usuario Objeto Usuario con los datos a registrar
     * @return true si el usuario fue creado exitosamente, false si ya existe o falla la operación
     * @see Usuario
     */
    public boolean altaUsuario(Usuario usuario) {
        if (existeUsuario(usuario.getNombre())) return false;

        String sql = "INSERT INTO usuario (nombre, clave, fecha_nacimiento) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getClave());

            pstmt.setDate(3, java.sql.Date.valueOf(usuario.getFechaNacimiento()));
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error alta usuario: " + e.getMessage());
            return false;
        }
    }
    /**
     * Verifica si un usuario ya existe en la base de datos por su nombre.
     *
     * @param nombre Nombre del usuario a verificar
     * @return true si el usuario existe, false en caso contrario
     */
    public boolean existeUsuario(String nombre) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE nombre = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error verificando usuario: " + e.getMessage());
            return false;
        }
    }
    /**
     * Elimina un usuario de la base de datos.
     * Requiere que el nombre y la clave coincidan para realizar la eliminación.
     *
     * @param nombre Nombre del usuario a eliminar
     * @param clave Clave de acceso del usuario
     * @return true si el usuario fue eliminado exitosamente, false si no se encuentra o la clave es incorrecta
     */
    public boolean bajaUsuario(String nombre, String clave) {
        String sql = "DELETE FROM usuario WHERE nombre = ? AND clave = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, clave);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error baja usuario: " + e.getMessage());
            return false;
        }
    }
    /**
     * Actualiza la clave de acceso de un usuario existente.
     *
     * @param nombre Nombre del usuario al que se le cambiará la clave
     * @param nuevaClave Nueva contraseña a establecer
     * @return true si la clave fue actualizada exitosamente, false en caso contrario
     */
    public boolean cambiarClave(String nombre, String nuevaClave) {
        String sql = "UPDATE usuario SET clave = ? WHERE nombre = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevaClave);
            pstmt.setString(2, nombre);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error cambiar clave: " + e.getMessage());
            return false;
        }
    }
}