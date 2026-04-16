package Servicio;
import DAO.UsuarioDAO;
import Modelo.Usuario;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;


public class GestionHabitacionServicio {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final Scanner scanner = new Scanner(System.in);

    public void altaUsuario() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        if (usuarioDAO.existeUsuario(nombre)) {
            System.out.println(" Usuario ya existe");
            return;
        }

        System.out.print("Clave: ");
        String clave = scanner.nextLine();

        System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
        String input = scanner.nextLine();

        Date fechaNacimiento;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("HOLA");
            LocalDate fechaLocal = LocalDate.parse(input, formatter);

            fechaNacimiento = Date.from(
                    fechaLocal.atStartOfDay(ZoneId.systemDefault()).toInstant()
            );

        } catch (DateTimeParseException e) {
            System.out.println(" Formato de fecha incorrecto. Usa YYYY-MM-DD");
            return;
        }
        Usuario usuario = new Usuario(nombre, clave, fechaNacimiento);

        if (usuario.esMayorEdad() && usuarioDAO.altaUsuario(usuario)) {
            System.out.println(" Usuario creado correctamente");
        } else {
            System.out.println(" Error: menor de edad o fallo en BD");
        }
    }

    public void bajaUsuario() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Confirme clave: ");
        String clave = scanner.nextLine();

        if (usuarioDAO.bajaUsuario(nombre, clave)) {
            System.out.println(" Usuario eliminado");
        } else {
            System.out.println(" Usuario no encontrado o clave incorrecta");
        }
    }

    public void cambiarClave() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nueva clave: ");
        String nuevaClave = scanner.nextLine();

        if (usuarioDAO.cambiarClave(nombre, nuevaClave)) {
            System.out.println(" Clave actualizada");
        } else {
            System.out.println(" Error actualizando clave");
        }
    }
}

