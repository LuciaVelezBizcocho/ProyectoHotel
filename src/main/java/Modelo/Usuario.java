package Modelo;

import java.util.Date;

public class Usuario {
    private String nombre;
    private String clave;
    private Date fechaNacimiento;

    public Usuario(String nombre, String clave, Date fechaNacimiento) {
        this.nombre = nombre;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public boolean esMayorEdad() {
        Date hoy = new Date();

        int anioActual = hoy.getYear();
        int anioNacimiento = fechaNacimiento.getYear();

        int edad = anioActual - anioNacimiento;

        return edad >= 18;
    }

    @Override
    public String toString() {
        return String.format("Usuario{nombre='%s', clave='%s', fechaNacimiento=%s}",
                nombre, clave, fechaNacimiento);
    }

}
