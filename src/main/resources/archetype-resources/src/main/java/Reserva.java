/**
 * Clase que representa una reserva realizada por un huesped.
 *
 * SECCION ASIGNADA: [NOMBRE DEL ALUMNO 2]
 * - Puedes anadir atributos como fechaEntrada, fechaSalida, email, telefono, etc.
 * - Puedes anadir metodos como getDuracion(), getResumenPago(), etc.
 */
public class Reserva {

    // ---------------------------------------------------------------
    // ATRIBUTOS
    // Puedes anadir mas atributos aqui si lo necesitas
    // ---------------------------------------------------------------
    private int idReserva;
    private String nombreHuesped;
    private Habitacion habitacion;
    private int noches;
    private double total;

    // ---------------------------------------------------------------
    // CONSTRUCTOR
    // El total se calcula automaticamente al crear la reserva
    // ---------------------------------------------------------------
    public Reserva(int idReserva, String nombreHuesped, Habitacion habitacion, int noches) {
        this.idReserva = idReserva;
        this.nombreHuesped = nombreHuesped;
        this.habitacion = habitacion;
        this.noches = noches;
        this.total = habitacion.getPrecioTotal(noches); // calculo automatico
    }

    // ---------------------------------------------------------------
    // GETTERS
    // ---------------------------------------------------------------
    public int getIdReserva() { return idReserva; }
    public String getNombreHuesped() { return nombreHuesped; }
    public Habitacion getHabitacion() { return habitacion; }
    public int getNoches() { return noches; }
    public double getTotal() { return total; }

    // ---------------------------------------------------------------
    // toString: como se muestra la reserva en consola
    // ---------------------------------------------------------------
    @Override
    public String toString() {
        return String.format(
            "Reserva #%04d | Huesped: %-20s | Hab: %-25s | %d noches | Total: %.0f euros",
            idReserva, nombreHuesped, habitacion.getNombre(), noches, total
        );
    }
}
