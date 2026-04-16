import java.util.List;

/**
 * Clase que representa una habitacion del hotel.
 *
 * SECCION ASIGNADA: [NOMBRE DEL ALUMNO 1]
 * - Puedes anadir nuevos atributos como descripcion, foto, planta, etc.
 * - Puedes anadir metodos como estaDisponible(), getPrecioTotal(int noches), etc.
 */
public class Habitacion {

    // ---------------------------------------------------------------
    // ENUM de estados posibles de una habitacion
    // ---------------------------------------------------------------
    public enum Estado {
        DISPONIBLE,
        RESERVADA
    }

    // ---------------------------------------------------------------
    // ATRIBUTOS
    // Puedes anadir mas atributos aqui si lo necesitas
    // ---------------------------------------------------------------
    private int id;
    private String nombre;
    private String tipo;
    private double precioPorNoche;
    private int capacidad;
    private Estado estado;
    private List<String> caracteristicas;

    // ---------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------
    public Habitacion(int id, String nombre, String tipo, double precioPorNoche,
                      int capacidad, List<String> caracteristicas) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.capacidad = capacidad;
        this.estado = Estado.DISPONIBLE; // por defecto todas empiezan disponibles
        this.caracteristicas = caracteristicas;
    }

    // ---------------------------------------------------------------
    // GETTERS Y SETTERS
    // ---------------------------------------------------------------
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getPrecioPorNoche() { return precioPorNoche; }
    public int getCapacidad() { return capacidad; }
    public Estado getEstado() { return estado; }
    public List<String> getCaracteristicas() { return caracteristicas; }

    public void setEstado(Estado estado) { this.estado = estado; }

    // ---------------------------------------------------------------
    // METODOS UTILES
    // ---------------------------------------------------------------

    /**
     * Devuelve true si la habitacion esta disponible para reservar.
     */
    public boolean estaDisponible() {
        return this.estado == Estado.DISPONIBLE;
    }

    /**
     * Calcula el precio total segun el numero de noches.
     */
    public double getPrecioTotal(int noches) {
        return this.precioPorNoche * noches;
    }

    // ---------------------------------------------------------------
    // toString: como se muestra la habitacion en consola
    // ---------------------------------------------------------------
    @Override
    public String toString() {
        return String.format(
            "#%03d | %-28s | %-20s | %6.0f euros/noche | %d personas | %s",
            id, nombre, tipo, precioPorNoche, capacidad, estado
        );
    }
}
