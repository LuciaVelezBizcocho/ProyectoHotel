
package main.java.Modelo;

public class Habitacion {
    private int id, id_hotel, capacidad;
    private String tiempoAlquiler;

    public void setId(int id) {
        this.id = id;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setTiempoAlquiler(String tiempoAlquiler) {
        this.tiempoAlquiler = tiempoAlquiler;
    }

    public int getId() {
        return id;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getTiempoAlquiler() {
        return tiempoAlquiler;
    }

    public Habitacion(int id, int id_hotel, int capacidad, String tiempoAlquiler) {
        this.id = id;
        this.id_hotel = id_hotel;
        this.capacidad = capacidad;
        this.tiempoAlquiler = tiempoAlquiler;
    }

    public Habitacion() {
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", id_hotel=" + id_hotel +
                ", capacidad=" + capacidad +
                ", tiempoAlquiler='" + tiempoAlquiler + '\'' +
                '}';
    }
}
