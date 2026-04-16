
package main.java.Modelo;
import java.time.LocalDate;
import java.time.Period;


public class Alquiler {
    private int id, id_hotel, id_habitacion;
    private String nombreUsuario;
    private localDate fechaEntrada, fechaSalida;

    public void setId(int id) {

        this.id = id;

    }

    public void setId_hotel(int id_hotel) {

        this.id_hotel = id_hotel;

    }

    public void setId_habitacion(int id_habitacion) {

        this.id_habitacion = id_habitacion;

    }

    public void setNombreUsuario(String nombreUsuario) {

        this.nombreUsuario = nombreUsuario;

    }

    public void setFechaEntrada(localDate fechaEntrada)
    {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(localDate fechaSalida)
    {
        this.fechaSalida = fechaSalida;
    }

    public int getId() {
        return id;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public localDate getFechaEntrada() {
        return fechaEntrada;
    }

    public localDate getFechaSalida() {
        return fechaSalida;
    }

    public Alquiler(int id, int id_hotel, int id_habitacion, String nombreUsuario, localDate fechaEntrada, localDate fechaSalida) {
        this.id = id;
        this.id_hotel = id_hotel;
        this.id_habitacion = id_habitacion;
        this.nombreUsuario = nombreUsuario;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public Alquiler() {
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "id=" + id +
                ", id_hotel=" + id_hotel +
                ", id_habitacion=" + id_habitacion +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                '}';
    }
}
