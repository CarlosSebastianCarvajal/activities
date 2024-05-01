
package com.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Sebastian Carvajal
 */

@Entity
@Table(name="actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idactividad;
    
    private Long idciudad;
    
    private String nombre, descripcion, pathdocguia;
    
    @Temporal(TemporalType.DATE)
    private LocalDate fechacreacion;
    
    @Temporal(TemporalType.DATE)
    private LocalDate fechaculminacion;
    
    
    public Long getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(Long idactividad) {
        this.idactividad = idactividad;
    }

    public Long getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Long idciudad) {
        this.idciudad = idciudad;
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

    public String getPathdocguia() {
        return pathdocguia;
    }

    public void setPathdocguia(String pathdocguia) {
        this.pathdocguia = pathdocguia;
    }

    public LocalDate getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDate fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public LocalDate getFechaculminacion() {
        return fechaculminacion;
    }

    public void setFechaculminacion(LocalDate fechaculminacion) {
        this.fechaculminacion = fechaculminacion;
    }

    
}
