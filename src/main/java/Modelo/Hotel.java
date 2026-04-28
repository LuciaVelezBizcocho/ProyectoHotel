
package Modelo;
/**
 * Clase que representa un hotel con toda su información básica.
 * Contiene los atributos identificativos del hotel como el ID,
 * número de habitaciones, dirección y nombre.
 *
 * @author Lucía, Adrián, Alberto y Antonio
 * @version 1.0
 */
public class Hotel {
    /** Identificador único del hotel y número total de habitaciones que posee el hotel */
    private int id, num_habitacion;
    /** Dirección física del hotel y nombre comercial del hotel */
    private String direccion, nombre;
    /**
     * @param id Nuevo identificador del hotel
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @param num_habitacion Nuevo número de habitaciones
     */
    public void setNum_habitacion(int num_habitacion) {
        this.num_habitacion = num_habitacion;
    }
    /**
     * @param direccion Nueva dirección del hotel
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * @param nombre Nuevo nombre del hotel
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return El identificador del hotel
     */
    public int getId() {
        return id;
    }
    /**
     * @return Número de habitaciones del hotel
     */
    public int getNum_habitacion() {
        return num_habitacion;
    }
    /**
     * @return Dirección del hotel
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * @return Nombre del hotel
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Constructor con todos los parámetros.
     *
     * @param id Identificador único del hotel
     * @param num_habitacion Número total de habitaciones
     * @param direccion Dirección del hotel
     * @param nombre Nombre del hotel
     */
    public Hotel(int id, int num_habitacion, String direccion, String nombre) {
        this.id = id;
        this.num_habitacion = num_habitacion;
        this.direccion = direccion;
        this.nombre = nombre;
    }
    /**
     * Constructor vacío para crear objetos Hotel sin inicializar.
     */
    public Hotel() {
    }
    /**
     * Devuelve una representación textual del objeto Hotel.
     *
     * @return Cadena con el formato "Hotel{id=x, num_habitacion=x, direccion='x', nombre='x'}"
     */
    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", num_habitacion=" + num_habitacion +
                ", direccion='" + direccion + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
