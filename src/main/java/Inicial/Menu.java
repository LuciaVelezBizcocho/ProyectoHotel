package Inicial;


import DAO.HabitacionDAO;
import Modelo.Habitacion;
import Servicio.GestionUsuarioServicio;


import java.util.*;


public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final HabitacionDAO habitacionDAO = new HabitacionDAO();
    private static final GestionUsuarioServicio gestionUsuario = new GestionUsuarioServicio();
        //Inserción de datos en el map
    public static void insertarDatosEnMapa(Map<Integer, Boolean> estadoHabitaciones) {
        estadoHabitaciones.put(101, false);
        estadoHabitaciones.put(102, true);
        estadoHabitaciones.put(103, true);
        estadoHabitaciones.put(104, false);
        estadoHabitaciones.put(105, true);
        estadoHabitaciones.put(201, true);
        estadoHabitaciones.put(202, false);
        estadoHabitaciones.put(203, false);
        estadoHabitaciones.put(204, true);
        estadoHabitaciones.put(205, false);
    }
        // Muestra del menu
    public static void mostrarMenu() {
        System.out.println("\n=== GESTIÓN HOTELES (BD + MAPA) ===");
        System.out.println("0 - Salir");
        System.out.println("1 - Estado ocupación MAPA");
        System.out.println("2 - Ocupar habitación (MAPA)");
        System.out.println("3 - Liberar habitación (MAPA)");
        System.out.println("4 - Alta Usuario (BD)");
        System.out.println("5 - Baja Usuario (BD)");
        System.out.println("6 - Cambiar Clave (BD)");
    }
        // Lectura de la opcion del usuario
    public static int leerOpcion() {
        System.out.print("Opción: ");
        return scanner.nextInt();
    }
        // Ejecucion del código
    public static void ejecutarOpcion(Map<Integer, Boolean> estadoHabitaciones, int opcion) {
        scanner.nextLine(); // Limpiar buffer
        switch (opcion) {
            case 0: return;
            case 1: estadoOcupacion(estadoHabitaciones);
                break;
            case 2: ocuparHabitacion(estadoHabitaciones);
                break;
            case 3: liberarHabitacion(estadoHabitaciones);
                break;
            case 4: gestionUsuario.altaUsuario();
                break;
            case 5: gestionUsuario.bajaUsuario();
                break;
            case 6: gestionUsuario.cambiarClave();
                break;
            default: System.out.println("Opción inválida");
        }
    }

    // MÉTODOS DEL MAPA ORIGINAL (sin cambios)
    public static void estadoOcupacion(Map<Integer, Boolean> estadoHabitaciones) {
        System.out.println("\nEstado de ocupación (MAPA):");
        // Comprueba en todas las habitaciones si esta ocupada o no, y lo  imprime en consola
        estadoHabitaciones.forEach((num, ocupada) ->
                System.out.println("Habitación " + num + ": " +
                        (ocupada ? "ocupada" : "libre")));
    }

    public static void ocuparHabitacion(Map<Integer, Boolean> estadoHabitaciones) {
        int habitacion = leerHabitacion();
        // Comprueba si la habitacion existe en el map
        if (!estadoHabitaciones.containsKey(habitacion)) {
            System.out.println("\n La habitación indicada no existe.");
            // En el caso que exista devuelve true o false
        } else if ((Boolean) estadoHabitaciones.get(habitacion)) {
            System.out.println("\n La habitación ya está ocupada.");
        } else {
            estadoHabitaciones.put(habitacion, true);
            System.out.println("\n Habitación ocupada correctamente");
        }
    }

    public static void liberarHabitacion(Map<Integer, Boolean> estadoHabitaciones) {
        int habitacion = leerHabitacion();
        // Comprueba si la habitacion existe en el map
        if (!estadoHabitaciones.containsKey(habitacion)) {
            System.out.println("\n La habitación indicada no existe.");
            // En el caso que exista devuelve true o false
        } else if (!(Boolean) estadoHabitaciones.get(habitacion)) {
            System.out.println("\n La habitación ya estaba libre.");
        } else {
            estadoHabitaciones.put(habitacion, false);
            System.out.println("\n Habitación liberada correctamente");
        }
    }

    public static int leerHabitacion() {
        System.out.print("\nNúmero de habitación: ");
        return scanner.nextInt();
    }
}
