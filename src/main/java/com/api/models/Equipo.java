
package com.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Sebastian Carvajal
 */
@Entity
@Table(name="equipo")
public class Equipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idequipo;
    
    private Long idusuario;
    
    private String nombre, descripcion, color, patharchivo;

    public Long getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Long idequipo) {
        this.idequipo = idequipo;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPatharchivo() {
        return patharchivo;
    }

    public void setPatharchivo(String patharchivo) {
        this.patharchivo = patharchivo;
    }
}
