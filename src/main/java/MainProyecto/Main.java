package MainProyecto;

import DAO.HabitacionDAO;
import Inicial.Menu;
import Servicio.GestionUsuarioServicio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Inicial.Menu.*;
/**
 * Clase principal del sistema de gestión hotelera.
 * Punto de entrada de la aplicación que inicializa el mapa de estados
 * de habitaciones y ejecuta el bucle principal del menú.
 *
 * @author Lucía, Adrián, Alberto y Antonio
 * @version 1.0
 */
public class Main {
    /** DAO para operaciones con habitaciones en la base de datos */
    private static final HabitacionDAO habitacionDAO = new HabitacionDAO();
    /** Servicio para gestión de operaciones de usuarios */
    private static final GestionUsuarioServicio usuarioServicio = new GestionUsuarioServicio();
    /** Scanner para entrada de datos por consola */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que inicia la aplicación.
     * Crea el mapa de estados de habitaciones, lo inicializa con datos
     * de ejemplo y ejecuta el bucle interactivo del menú hasta que
     * el usuario selecciona salir (opción 0).
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Creación del mapa para almacenar estado de habitaciones
        Map<Integer, Boolean> estadoHabitaciones = new HashMap<>();
        // Inicialización del mapa con datos
        insertarDatosEnMapa(estadoHabitaciones);

        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(estadoHabitaciones, opcion);
        } while (opcion != 0);
        scanner.close();
    }
}
