package Modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * Clase que representa un usuario del sistema de gestión hotelera.
 * Contiene información personal del usuario como nombre, clave de acceso
 * y fecha de nacimiento, además de lógica para validar mayoría de edad.
 *
 * @author Lucía, Adrián, Alberto y Antonio
 * @version 1.0
 */
public class Usuario {
    /** Nombre de usuario (identificador único) */
    private String nombre;
    /** Contraseña de acceso al sistema */
    private String clave;
    /** Fecha de nacimiento del usuario */
    private LocalDate fechaNacimiento;
    /**
     * Constructor con todos los parámetros.
     *
     * @param nombre Nombre de usuario
     * @param clave Contraseña de acceso
     * @param fechaNacimiento Fecha de nacimiento del usuario
     */
    public Usuario(String nombre, String clave, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
    }
    /**
     * @return Nombre del usuario
     */
    public String getNombre() { return nombre; }
    /**
     * @param nombre Nuevo nombre del usuario
     */
    public void setNombre(String nombre) { this.nombre = nombre; }
    /**
     * @return Contraseña del usuario
     */
    public String getClave() { return clave; }
    /**
     * @param clave Nueva contraseña del usuario
     */
    public void setClave(String clave) { this.clave = clave; }
    /**
     * @return Fecha de nacimiento del usuario
     */
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    /**
     * @param fechaNacimiento Nueva fecha de nacimiento
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    /**
     * Verifica si el usuario es mayor de edad (18 años o más).
     *
     * @return true si la edad es mayor o igual a 18, false en caso contrario
     */
    public boolean esMayorEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }
    /**
     * Devuelve una representación textual del usuario sin incluir la clave por seguridad.
     *
     * @return Cadena con formato "Usuario{nombre='x', fechaNacimiento=x}"
     */
    @Override
    public String toString() {
        return String.format("Usuario{nombre='%s', fechaNacimiento=%s}", nombre, fechaNacimiento);
    }
}