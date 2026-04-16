import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase principal del proyecto ProyectoHotel.
 * Contiene el menu interactivo y el control de errores de entrada.
 *
 * SECCION ASIGNADA: [NOMBRE DEL ALUMNO 4]
 * - Puedes mejorar el menu, anadir submenus, cambiar los mensajes, etc.
 * - Puedes anadir opciones nuevas como "buscar por nombre" o "modificar reserva".
 *
 * REPARTO DE CLASES DEL PROYECTO:
 * - Habitacion.java  -->  [ALUMNO 1]
 * - Reserva.java     -->  [ALUMNO 2]
 * - Hotel.java       -->  [ALUMNO 3]
 * - App.java         -->  [ALUMNO 4]
 */
public class App {

    // ---------------------------------------------------------------
    // OBJETOS GLOBALES
    // El hotel y el scanner se usan en todo el programa
    // ---------------------------------------------------------------
    static Hotel hotel = new Hotel("Hotel Villa del Sol");
    static Scanner scanner = new Scanner(System.in);

    // ---------------------------------------------------------------
    // METODO PRINCIPAL
    // ---------------------------------------------------------------
    public static void main(String[] args) {

        // -----------------------------------------------------------
        // CARGA DE HABITACIONES
        // Puedes anadir, quitar o modificar habitaciones aqui
        // -----------------------------------------------------------
        hotel.agregarHabitacion(new Habitacion(1,  "Suite Alhambra",       "Suite",              280, 2, Arrays.asList("Terraza privada", "Hidromasaje", "King-size", "Vista ciudad")));
        hotel.agregarHabitacion(new Habitacion(2,  "Hab. Jardin Doble",    "Doble",              120, 2, Arrays.asList("Vista jardin", "Desayuno incluido", "AC", "Wifi")));
        hotel.agregarHabitacion(new Habitacion(3,  "Suite Familiar Plus",  "Suite Familiar",     350, 4, Arrays.asList("2 banos", "Cocina", "Sala de estar", "Camas extras")));
        hotel.agregarHabitacion(new Habitacion(4,  "Hab. Individual",      "Individual",          75, 1, Arrays.asList("Escritorio", "Wifi rapido", "AC", "Caja fuerte")));
        hotel.agregarHabitacion(new Habitacion(5,  "Suite Presidencial",   "Suite Presidencial", 650, 4, Arrays.asList("Mayordomo 24h", "Jacuzzi exterior", "Salon privado")));
        hotel.agregarHabitacion(new Habitacion(6,  "Hab. Doble Estandar",  "Doble",              110, 2, Arrays.asList("Cama doble", "Bano completo", "AC", "Wifi", "TV")));
        hotel.agregarHabitacion(new Habitacion(7,  "Suite Junior Patio",   "Suite Junior",       210, 2, Arrays.asList("Patio privado", "Ducha lluvia", "Minibar")));
        hotel.agregarHabitacion(new Habitacion(8,  "Hab. Triple Familiar", "Triple",             175, 3, Arrays.asList("3 camas", "Bano amplio", "AC", "Wifi")));
        hotel.agregarHabitacion(new Habitacion(9,  "Hab. Doble Superior",  "Doble Superior",     145, 2, Arrays.asList("Vista panoramica", "Menaje premium", "Colchon ortopedico")));
        hotel.agregarHabitacion(new Habitacion(10, "Suite Nupcial",        "Suite Nupcial",      480, 2, Arrays.asList("Decoracion floral", "Champagne", "Banera XL", "Desayuno en cama")));
        hotel.agregarHabitacion(new Habitacion(11, "Hab. Accesible",       "Adaptada",           100, 2, Arrays.asList("Bano adaptado", "Cama regulable", "Entradas amplias")));
        hotel.agregarHabitacion(new Habitacion(12, "Hab. Atico Vista",     "Atico",              320, 3, Arrays.asList("Vistas 360", "Ventanales dobles", "Terraza compartida")));

        // -----------------------------------------------------------
        // BUCLE PRINCIPAL DEL MENU
        // El programa se mantiene activo hasta que el usuario elige 0
        // -----------------------------------------------------------
        int opcion = -1;
        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEntero("Elige una opcion (0-10): ", 0, 10);

            switch (opcion) {

                case 1: // Ver todas las habitaciones
                    hotel.mostrarTodas();
                    break;

                case 2: // Ver solo las disponibles
                    hotel.mostrarPorEstado(Habitacion.Estado.DISPONIBLE);
                    break;

                case 3: // Ver solo las reservadas
                    hotel.mostrarPorEstado(Habitacion.Estado.RESERVADA);
                    break;

                case 4: // Ver detalle de una habitacion concreta
                    hotel.mostrarTodas();
                    int idDetalle = leerEntero("  Numero de habitacion a ver (1-12): ", 1, 12);
                    hotel.verDetalle(idDetalle);
                    break;

                case 5: // Hacer una nueva reserva
                    hotel.mostrarPorEstado(Habitacion.Estado.DISPONIBLE);
                    int idReservar = leerEntero("  Numero de habitacion a reservar (1-12): ", 1, 12);
                    String nombreHuesped = leerTexto("  Nombre del huesped: ");
                    int noches = leerEntero("  Numero de noches (minimo 1): ", 1, 365);
                    hotel.reservar(idReservar, nombreHuesped, noches);
                    break;

                case 6: // Cancelar una reserva existente
                    hotel.mostrarReservas();
                    int idCancelar = leerEntero("  Numero de reserva a cancelar: ", 1, Integer.MAX_VALUE);
                    hotel.cancelarReserva(idCancelar);
                    break;

                case 7: // Buscar habitacion por capacidad minima
                    int personas = leerEntero("  Cuantas personas? (1-10): ", 1, 10);
                    hotel.buscarPorCapacidad(personas);
                    break;

                case 8: // Buscar habitacion por precio maximo
                    int precioMax = leerEntero("  Precio maximo por noche en euros: ", 1, 10000);
                    hotel.buscarPorPrecioMax(precioMax);
                    break;

                case 9: // Ver todas las reservas activas
                    hotel.mostrarReservas();
                    break;

                case 10: // Ver estadisticas generales del hotel
                    hotel.mostrarEstadisticas();
                    break;

                case 0: // Salir del programa
                    System.out.println("\n  Hasta pronto! Cerrando el sistema Hotel Villa del Sol...\n");
                    break;

                default:
                    System.out.println("\n  Opcion no valida. Por favor elige entre 0 y 10.\n");
                    break;
            }
        }

        scanner.close();
    }

    // ---------------------------------------------------------------
    // MENU PRINCIPAL
    // Puedes cambiar el texto o anadir nuevas opciones aqui
    // ---------------------------------------------------------------
    static void mostrarMenu() {
        System.out.println("\n+------------------------------------------+");
        System.out.println("|      HOTEL VILLA DEL SOL - MENU         |");
        System.out.println("+------------------------------------------+");
        System.out.println("|  1. Ver todas las habitaciones           |");
        System.out.println("|  2. Ver habitaciones disponibles         |");
        System.out.println("|  3. Ver habitaciones reservadas          |");
        System.out.println("|  4. Ver detalle de una habitacion        |");
        System.out.println("|  5. Hacer una reserva                    |");
        System.out.println("|  6. Cancelar una reserva                 |");
        System.out.println("|  7. Buscar por numero de personas        |");
        System.out.println("|  8. Buscar por precio maximo             |");
        System.out.println("|  9. Ver reservas activas                 |");
        System.out.println("| 10. Ver estadisticas del hotel           |");
        System.out.println("|  0. Salir                                |");
        System.out.println("+------------------------------------------+");
    }

    // ---------------------------------------------------------------
    // METODO: leerEntero
    // Lee un numero entero dentro de un rango.
    // Si el usuario escribe letras, decimales, vacio o fuera de rango,
    // muestra un error y vuelve a preguntar sin cerrar el programa.
    // ---------------------------------------------------------------
    static int leerEntero(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            try {
                String linea = scanner.nextLine().trim();

                // Control: campo vacio
                if (linea.isEmpty()) {
                    System.out.println("  ERROR: No puedes dejar el campo vacio. Escribe un numero.");
                    continue;
                }

                // Control: contiene letras u otros caracteres no numericos
                int valor = Integer.parseInt(linea);

                // Control: numero fuera del rango permitido
                if (valor < min || valor > max) {
                    System.out.println("  ERROR: El numero debe estar entre " + min + " y " + max + ".");
                } else {
                    return valor; // entrada valida, salir del bucle
                }

            } catch (NumberFormatException e) {
                // Se lanza cuando parseInt recibe letras o decimales
                System.out.println("  ERROR: Entrada no valida. Escribe solo numeros enteros (sin letras ni comas).");
            } catch (Exception e) {
                // Cualquier otro error inesperado
                System.out.println("  ERROR inesperado: " + e.getMessage() + ". Intentalo de nuevo.");
            }
        }
    }

    // ---------------------------------------------------------------
    // METODO: leerTexto
    // Lee una cadena de texto no vacia.
    // Si el usuario pulsa Enter sin escribir nada, vuelve a preguntar.
    // ---------------------------------------------------------------
    static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                String linea = scanner.nextLine().trim();

                // Control: campo vacio
                if (linea.isEmpty()) {
                    System.out.println("  ERROR: Este campo no puede estar vacio. Escribe un nombre.");
                } else {
                    return linea; // entrada valida, salir del bucle
                }

            } catch (Exception e) {
                System.out.println("  ERROR inesperado al leer el texto: " + e.getMessage() + ". Intentalo de nuevo.");
            }
        }
    }
}
