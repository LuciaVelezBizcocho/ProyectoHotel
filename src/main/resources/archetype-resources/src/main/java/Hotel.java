import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase principal del sistema. Gestiona todas las habitaciones y reservas.
 *
 * SECCION ASIGNADA: [NOMBRE DEL ALUMNO 3]
 * - Puedes anadir metodos como buscarPorNombre(), ordenarPorPrecio(), etc.
 * - Puedes mejorar las busquedas o anadir filtros adicionales.
 */
public class Hotel {

    // ---------------------------------------------------------------
    // ATRIBUTOS
    // ---------------------------------------------------------------
    private String nombre;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;
    private int contadorReservas;

    // ---------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------
    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.contadorReservas = 1;
    }

    // ---------------------------------------------------------------
    // GESTION DE HABITACIONES
    // ---------------------------------------------------------------

    /**
     * Agrega una habitacion al hotel.
     */
    public void agregarHabitacion(Habitacion h) {
        habitaciones.add(h);
    }

    /**
     * Muestra todas las habitaciones sin filtro.
     */
    public void mostrarTodas() {
        System.out.println("\n-- TODAS LAS HABITACIONES ------------------------------------------");
        for (Habitacion h : habitaciones) {
            System.out.println(h);
        }
    }

    /**
     * Muestra las habitaciones segun su estado (DISPONIBLE o RESERVADA).
     */
    public void mostrarPorEstado(Habitacion.Estado estado) {
        String titulo = (estado == Habitacion.Estado.DISPONIBLE) ? "DISPONIBLES" : "RESERVADAS";
        System.out.println("\n-- HABITACIONES " + titulo + " ------------------------------------");
        boolean hayResultados = false;
        for (Habitacion h : habitaciones) {
            if (h.getEstado() == estado) {
                System.out.println(h);
                hayResultados = true;
            }
        }
        if (!hayResultados) {
            System.out.println("  No hay habitaciones en ese estado actualmente.");
        }
    }

    /**
     * Muestra el detalle completo de una habitacion por su id.
     */
    public void verDetalle(int id) {
        Habitacion h = buscarHabitacionPorId(id);
        if (h == null) {
            System.out.println("  ERROR: No existe ninguna habitacion con el numero #" + id + ".");
            return;
        }
        System.out.println("\n-- Detalle Habitacion #" + String.format("%03d", h.getId()) + " -------------------------");
        System.out.println("  Nombre    : " + h.getNombre());
        System.out.println("  Tipo      : " + h.getTipo());
        System.out.println("  Precio    : " + h.getPrecioPorNoche() + " euros / noche");
        System.out.println("  Capacidad : " + h.getCapacidad() + " persona(s)");
        System.out.println("  Estado    : " + h.getEstado());
        System.out.println("  Servicios : " + String.join(", ", h.getCaracteristicas()));
    }

    /**
     * Busca habitaciones disponibles que soporten un minimo de personas.
     */
    public void buscarPorCapacidad(int personas) {
        System.out.println("\n-- HABITACIONES DISPONIBLES PARA " + personas + " O MAS PERSONAS --------");
        boolean hayResultados = false;
        for (Habitacion h : habitaciones) {
            if (h.getCapacidad() >= personas && h.estaDisponible()) {
                System.out.println(h);
                hayResultados = true;
            }
        }
        if (!hayResultados) {
            System.out.println("  No hay habitaciones disponibles para " + personas + " personas.");
        }
    }

    /**
     * Busca habitaciones disponibles por debajo de un precio maximo.
     */
    public void buscarPorPrecioMax(double precioMax) {
        System.out.println("\n-- HABITACIONES DISPONIBLES HASTA " + (int) precioMax + " EUROS/NOCHE -------");
        boolean hayResultados = false;
        for (Habitacion h : habitaciones) {
            if (h.getPrecioPorNoche() <= precioMax && h.estaDisponible()) {
                System.out.println(h);
                hayResultados = true;
            }
        }
        if (!hayResultados) {
            System.out.println("  No hay habitaciones disponibles en ese rango de precio.");
        }
    }

    // ---------------------------------------------------------------
    // GESTION DE RESERVAS
    // ---------------------------------------------------------------

    /**
     * Crea una nueva reserva si la habitacion existe y esta disponible.
     */
    public boolean reservar(int idHabitacion, String huesped, int noches) {
        Habitacion h = buscarHabitacionPorId(idHabitacion);

        // Verificar que la habitacion existe
        if (h == null) {
            System.out.println("  ERROR: No existe ninguna habitacion con el numero #" + idHabitacion + ".");
            return false;
        }

        // Verificar que la habitacion no esta ya reservada
        if (!h.estaDisponible()) {
            System.out.println("  ERROR: La habitacion \"" + h.getNombre() + "\" ya esta reservada.");
            return false;
        }

        // Crear la reserva y marcar la habitacion
        h.setEstado(Habitacion.Estado.RESERVADA);
        Reserva r = new Reserva(contadorReservas++, huesped, h, noches);
        reservas.add(r);
        System.out.println("  RESERVA CONFIRMADA: " + r);
        return true;
    }

    /**
     * Cancela una reserva existente y libera la habitacion.
     */
    public boolean cancelarReserva(int idReserva) {
        // Buscar la reserva por id
        Optional<Reserva> resultado = reservas.stream()
            .filter(r -> r.getIdReserva() == idReserva)
            .findFirst();

        if (resultado.isEmpty()) {
            System.out.println("  ERROR: No existe ninguna reserva con el numero #" + idReserva + ".");
            return false;
        }

        // Liberar la habitacion y eliminar la reserva
        Reserva r = resultado.get();
        r.getHabitacion().setEstado(Habitacion.Estado.DISPONIBLE);
        reservas.remove(r);
        System.out.println("  CANCELADA: Reserva #" + idReserva + " de " + r.getNombreHuesped() + " - Habitacion liberada.");
        return true;
    }

    /**
     * Muestra todas las reservas activas.
     */
    public void mostrarReservas() {
        System.out.println("\n-- RESERVAS ACTIVAS ------------------------------------------------");
        if (reservas.isEmpty()) {
            System.out.println("  No hay reservas activas en este momento.");
            return;
        }
        for (Reserva r : reservas) {
            System.out.println("  " + r);
        }
    }

    // ---------------------------------------------------------------
    // ESTADISTICAS
    // ---------------------------------------------------------------

    /**
     * Muestra un resumen general del estado del hotel.
     */
    public void mostrarEstadisticas() {
        long disponibles = 0, reservadas = 0;
        for (Habitacion h : habitaciones) {
            if (h.estaDisponible()) disponibles++;
            else reservadas++;
        }
        double ingresos = 0;
        for (Reserva r : reservas) {
            ingresos += r.getTotal();
        }

        System.out.println("\n-- ESTADISTICAS - " + nombre + " ----------------------------------");
        System.out.println("  Total habitaciones : " + habitaciones.size());
        System.out.println("  Disponibles        : " + disponibles);
        System.out.println("  Reservadas         : " + reservadas);
        System.out.println("  Reservas activas   : " + reservas.size());
        System.out.printf( "  Ingresos totales   : %.0f euros%n", ingresos);
    }

    // ---------------------------------------------------------------
    // METODOS PRIVADOS DE BUSQUEDA
    // ---------------------------------------------------------------

    /**
     * Busca una habitacion por su id. Devuelve null si no existe.
     */
    private Habitacion buscarHabitacionPorId(int id) {
        for (Habitacion h : habitaciones) {
            if (h.getId() == id) return h;
        }
        return null;
    }
}
