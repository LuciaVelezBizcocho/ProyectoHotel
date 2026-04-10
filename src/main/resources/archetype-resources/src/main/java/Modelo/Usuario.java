package main.java.Modelo;
import java.time.LocalDate;
import java.time.Period;

public class Usuario {
    private String nombre, clave;
    private LocalDate fechaNacimiento;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Usuario(String nombre, String clave, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario() {
    }

    public boolean esMayorEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
