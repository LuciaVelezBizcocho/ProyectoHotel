package MainProyecto;

import DAO.HabitacionDAO;
import Inicial.Menu;
import Servicio.GestionUsuarioServicio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Inicial.Menu.*;

public class Main {
    private static final HabitacionDAO habitacionDAO = new HabitacionDAO();
    private static final GestionUsuarioServicio usuarioServicio = new GestionUsuarioServicio();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Integer, Boolean> estadoHabitaciones = new HashMap<>();
        insertarDatosEnMapa(estadoHabitaciones);

        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(estadoHabitaciones, opcion);
        } while (opcion != 0);
        scanner.close();
    }
    // Ramiro Antonio Correa Mamani
}
