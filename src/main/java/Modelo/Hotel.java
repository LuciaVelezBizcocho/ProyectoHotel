
package Modelo;

public class Hotel {
    private int id, num_habitacion;
    private String direccion, nombre;

    public void setId(int id) {
        this.id = id;
    }

    public void setNum_habitacion(int num_habitacion) {
        this.num_habitacion = num_habitacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public int getNum_habitacion() {
        return num_habitacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public Hotel(int id, int num_habitacion, String direccion, String nombre) {
        this.id = id;
        this.num_habitacion = num_habitacion;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public Hotel() {
    }

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
