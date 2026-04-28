package Servicio;

import DAO.UsuarioDAO;
import Modelo.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con los usuarios.
 * Proporciona métodos para alta, baja y cambio de clave, interactuando con
 * la capa DAO y manejando la interacción por consola.
 *
 * @author Lucía, Adrián, Alberto y Antonio
 * @version 1.0
 */
public class GestionUsuarioServicio {
    /** DAO para operaciones con usuarios en la base de datos */
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    /** Scanner para lectura de entrada del usuario */
    private final Scanner scanner = new Scanner(System.in);
    /** Formato estándar para fechas (YYYY-MM-DD) */
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Registra un nuevo usuario en el sistema.
     * Solicita nombre, clave y fecha de nacimiento por consola.
     * Valida que el usuario sea mayor de edad antes de registrar.
     */
    public void altaUsuario() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Clave: ");
        String clave = scanner.nextLine();
        System.out.print("Fecha nacimiento (YYYY-MM-DD): ");

        try {
            LocalDate fechaNac = LocalDate.parse(scanner.nextLine(), FORMATO_FECHA);
            Usuario usuario = new Usuario(nombre, clave, fechaNac);

            if (!usuario.esMayorEdad()) {
                System.out.println("Error: el usuario es menor de edad");
                return;
            }

            if (usuarioDAO.altaUsuario(usuario)) {
                System.out.println("Usuario creado correctamente");
            } else {
                System.out.println("Error: el usuario ya existe o fallo en BD");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha incorrecto. Usa YYYY-MM-DD");
        }
    }

    /**
     * Elimina un usuario del sistema.
     * Solicita nombre y clave de acceso (verificación de autenticidad).
     */
    public void bajaUsuario() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Confirme clave: ");
        String clave = scanner.nextLine();

        if (usuarioDAO.bajaUsuario(nombre, clave)) {
            System.out.println("Usuario eliminado");
        } else {
            System.out.println("Usuario no encontrado o clave incorrecta");
        }
    }
    /**
     * Cambia la contraseña de un usuario existente.
     * No requiere verificación de clave anterior.
     */
    public void cambiarClave() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nueva clave: ");
        String nuevaClave = scanner.nextLine();

        if (usuarioDAO.cambiarClave(nombre, nuevaClave)) {
            System.out.println("Clave actualizada");
        } else {
            System.out.println("Error actualizando clave");
        }
    }
}