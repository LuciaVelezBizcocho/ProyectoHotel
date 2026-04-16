package Modelo;

public class Habitacion {
    private int id;
    private int idHotel;
    private int tiempoAlquiler;
    private int capacidad;
    private double precio;

    public Habitacion(int id, int idHotel, int tiempoAlquiler, int capacidad, double precio) {
        this.id = id;
        this.idHotel = idHotel;
        this.tiempoAlquiler = tiempoAlquiler;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    // Getters y Setters
    public int getId() { return id; }
    public int getIdHotel() { return idHotel; }
    public int getTiempoAlquiler() { return tiempoAlquiler; }
    public int getCapacidad() { return capacidad; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return String.format("Habitación %d [Hotel=%d, Capacidad=%d, Precio=%.2f€, Mín.Días=%d]",
                id, idHotel, capacidad, precio, tiempoAlquiler);
    }
}


