package Inicial;


import DAO.HabitacionDAO;
import Modelo.Habitacion;
import Servicio.GestionUsuarioServicio;


import java.util.*;

/**
 * Clase que gestiona la interfaz de menú y las operaciones relacionadas
 * con el mapa de estados de las habitaciones.
 * Proporciona métodos para mostrar opciones, capturar entrada del usuario
 * y ejecutar las acciones correspondientes.
 *
 * @author Lucía, Adrián, Alberto y Antonio
 * @version 1.0
 */
public class Menu {
    /** Scanner para lectura de entrada del usuario */
    private static final Scanner scanner = new Scanner(System.in);
    /** DAO para operaciones con habitaciones */
    private static final HabitacionDAO habitacionDAO = new HabitacionDAO();
    /** Servicio para gestión de usuarios */
    private static final GestionUsuarioServicio gestionUsuario = new GestionUsuarioServicio();
/**
 * Inicializa el mapa de estados de habitaciones con datos de ejemplo.
 * Cada habitación se identifica por su número (clave) y su estado
 * de ocupación (valor: true = ocupada, false = libre).
 *
 * @param estadoHabitaciones Mapa a rellenar con los datos iniciales
 */
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

/**
 * Muestra el menú principal de opciones del sistema.
 * Incluye opciones para gestión de mapa de habitaciones y usuarios BD.
 */
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

    /**
     * Lee la opción ingresada por el usuario por consola.
     *
     * @return Número entero correspondiente a la opción seleccionada
     */
    public static int leerOpcion() {
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    /**
     * Ejecuta la acción correspondiente a la opción seleccionada.
     *
     * @param estadoHabitaciones Mapa con el estado actual de las habitaciones
     * @param opcion Opción numérica seleccionada por el usuario
     */
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

    /**
     * Muestra el estado de ocupación de todas las habitaciones en el mapa.
     *
     * @param estadoHabitaciones Mapa con los estados de las habitaciones
     */
    public static void estadoOcupacion(Map<Integer, Boolean> estadoHabitaciones) {
        System.out.println("\nEstado de ocupación (MAPA):");

        estadoHabitaciones.forEach((num, ocupada) ->
                System.out.println("Habitación " + num + ": " +
                        (ocupada ? "ocupada" : "libre")));
    }

    /**
     * Marca una habitación como ocupada en el mapa.
     * Valida que la habitación exista y no esté ya ocupada.
     *
     * @param estadoHabitaciones Mapa con los estados de las habitaciones
     */
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

    /**
     * Marca una habitación como libre en el mapa.
     * Valida que la habitación exista y no esté ya libre.
     *
     * @param estadoHabitaciones Mapa con los estados de las habitaciones
     */
    public static void liberarHabitacion(Map<Integer, Boolean> estadoHabitaciones) {
        int habitacion = leerHabitacion();

        if (!estadoHabitaciones.containsKey(habitacion)) {
            System.out.println("\n La habitación indicada no existe.");
        } else if (!(Boolean) estadoHabitaciones.get(habitacion)) {
            System.out.println("\n La habitación ya estaba libre.");
        } else {
            estadoHabitaciones.put(habitacion, false);
            System.out.println("\n Habitación liberada correctamente");
        }
    }

    /**
     * Solicita al usuario el número de habitación.
     *
     * @return Número de habitación ingresado
     */
    public static int leerHabitacion() {
        System.out.print("\nNúmero de habitación: ");
        return scanner.nextInt();
    }
}
