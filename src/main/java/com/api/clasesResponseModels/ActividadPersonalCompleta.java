
package com.api.clasesResponseModels;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;

/**
 *
 * @author Sebastian Carvajal
 */
public class ActividadPersonalCompleta {
    public Long id;
    public String  ciudad, nombre, descripcion, pathdocguia, estado;
    
    @Temporal(TemporalType.DATE)
    public LocalDate fechaculminacion;
    
    public String observacion, pathdocevidencia;
    
    @Temporal(TemporalType.DATE)
    public LocalDate fechacumplida;

    public ActividadPersonalCompleta(){};
    
    public ActividadPersonalCompleta(Long id, String ciudad, String nombre, String descripcion, String pathdocguia, String estado, LocalDate fechaculminacion, String observacion, String pathdocevidencia, LocalDate fechacumplida) {
        this.id = id;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pathdocguia = pathdocguia;
        this.estado = estado;
        this.fechaculminacion = fechaculminacion;
        this.observacion = observacion;
        this.pathdocevidencia = pathdocevidencia;
        this.fechacumplida = fechacumplida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaculminacion() {
        return fechaculminacion;
    }

    public void setFechaculminacion(LocalDate fechaculminacion) {
        this.fechaculminacion = fechaculminacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getPathdocevidencia() {
        return pathdocevidencia;
    }

    public void setPathdocevidencia(String pathdocevidencia) {
        this.pathdocevidencia = pathdocevidencia;
    }

    public LocalDate getFechacumplida() {
        return fechacumplida;
    }

    public void setFechacumplida(LocalDate fechacumplida) {
        this.fechacumplida = fechacumplida;
    }

    
}
