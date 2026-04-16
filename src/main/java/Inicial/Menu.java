package Inicial;


import DAO.HabitacionDAO;
import Modelo.Habitacion;


import java.util.*;




public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final HabitacionDAO habitacionDAO = new HabitacionDAO();

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

    public static void mostrarMenu() {
        System.out.println("\n=== GESTIÓN HOTELES (BD + MAPA) ===");
        System.out.println("0 - Salir");
        System.out.println("1 - Ver habitaciones BD");
        System.out.println("2 - Estado ocupación MAPA");
        System.out.println("3 - Ocupar habitación (MAPA)");
        System.out.println("4 - Liberar habitación (MAPA)");
        System.out.println("5 - Alta Usuario (BD)");
        System.out.println("6 - Baja Usuario (BD)");
        System.out.println("7 - Cambiar Clave (BD)");
    }

    public static int leerOpcion() {
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public static void ejecutarOpcion(Map<Integer, Boolean> estadoHabitaciones, int opcion) {
        scanner.nextLine(); // Limpiar buffer
        switch (opcion) {
            case 0: return;
            case 1: listarHabitacionesBD();
            case 2: estadoOcupacion(estadoHabitaciones);
            case 3: ocuparHabitacion(estadoHabitaciones);
            case 4: liberarHabitacion(estadoHabitaciones);
            case 5: usuarioServicio.altaUsuario();// Dará error hasta que adrian rellene la clase usuarioServicio
            case 6: usuarioServicio.bajaUsuario();// Dará error hasta que adrian rellene la clase usuarioServicio
            case 7: usuarioServicio.cambiarClave();// Dará error hasta que adrian rellene la clase usuarioServicio
            default: System.out.println("Opción inválida");
        }
    }

    public static void listarHabitacionesBD() {
        System.out.println("\n=== HABITACIONES DESDE BASE DE DATOS ===");
        List<Habitacion> habitaciones = habitacionDAO.listarHabitaciones(); // Saco el listado de habitaciones de la BBDD y la inserto en la lista
        // Si esta vacía, pone el mensaje No hay habitaciones
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones");
            return;
        }
        //Si no esta vacía desvuelve cada elemento de la lista habitaciones
        habitaciones.forEach(System.out::println);
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
        // Modificar metodo ya que carece de sentido aparentemente
    public static int leerHabitacion() {
        System.out.print("\nNúmero de habitación: ");
        return scanner.nextInt();
    }
}
