package Modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Usuario {
    private String nombre;
    private String clave;
    private LocalDate fechaNacimiento;

    public Usuario(String nombre, String clave, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public boolean esMayorEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

    @Override
    public String toString() {
        return String.format("Usuario{nombre='%s', fechaNacimiento=%s}", nombre, fechaNacimiento);
    }
    // Ramiro Antonio Correa Mamani

}