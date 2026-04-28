package Modelo;
/**
 * Clase que representa una habitación dentro del sistema de gestión hotelera.
 * Contiene información detallada sobre las características de una habitación
 * incluyendo su precio, capacidad y condiciones de alquiler.
 *
 * @author Lucía, Adrián, Alberto y Antonio
 * @version 1.0
 */
public class Habitacion {
    /** Identificador único de la habitación */
    private int id;
    /** Identificador del hotel al que pertenece la habitación */
    private int idHotel;
    /** Tiempo mínimo de alquiler en días */
    private int tiempoAlquiler;
    /** Capacidad máxima de personas que puede alojar */
    private int capacidad;
    /** Precio por día de la habitación */
    private double precio;
    /**
     * Constructor completo para crear una instancia de Habitacion.
     *
     * @param id Identificador único de la habitación
     * @param idHotel Identificador del hotel padre
     * @param tiempoAlquiler Días mínimos requeridos de alquiler
     * @param capacidad Número máximo de personas
     * @param precio Costo por día en euros
     */
    public Habitacion(int id, int idHotel, int tiempoAlquiler, int capacidad, double precio) {
        this.id = id;
        this.idHotel = idHotel;
        this.tiempoAlquiler = tiempoAlquiler;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    /**
     * @return Identificador único de la habitación
     */
    public int getId() { return id; }
    /**
     * @return Identificador del hotel asociado
     */
    public int getIdHotel() { return idHotel; }
    /**
     * @return Tiempo mínimo de alquiler en días
     */
    public int getTiempoAlquiler() { return tiempoAlquiler; }
    /**
     * @return Capacidad máxima de personas
     */
    public int getCapacidad() { return capacidad; }
    /**
     * @return Precio por día en euros
     */
    public double getPrecio() { return precio; }
    /**
     * Devuelve una representación formateada de la habitación.
     *
     * @return Cadena con formato "Habitación X [Hotel=Y, Capacidad=Z, Precio=W€, Mín.Días=D]"
     */
    @Override
    public String toString() {
        return String.format("Habitación %d [Hotel=%d, Capacidad=%d, Precio=%.2f€, Mín.Días=%d]",
                id, idHotel, capacidad, precio, tiempoAlquiler);
    }
}


