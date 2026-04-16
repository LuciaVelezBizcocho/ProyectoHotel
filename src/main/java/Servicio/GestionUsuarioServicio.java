package Servicio;

import DAO.UsuarioDAO;
import Modelo.Usuario;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GestionUsuarioServicio {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final Scanner scanner = new Scanner(System.in);

    public void altaUsuario() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Clave: ");
        String clave = scanner.nextLine();
        System.out.print("Fecha nacimiento (YYYY-MM-DD): ");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);

            Date fechaNac = sdf.parse(scanner.nextLine());
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

        } catch (Exception e) {
            System.out.println("Formato de fecha incorrecto. Usa YYYY-MM-DD");
        }
    }

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