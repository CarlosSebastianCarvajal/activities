
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

/**
 *
 * @author Sebastian Carvajal
 */
@Entity
@Table(name="actividadpersonal")
public class ActividadPersonal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idactividadpersonal;
    
    private Long idusuario, idactividad;
    
    @Temporal(TemporalType.DATE)
    private LocalDate fechacumplida;
    
    private String observacion, pathdocevidencia;

    
    
    public Long getIdactividadpersonal() {
        return idactividadpersonal;
    }

    public void setIdactividadpersonal(Long idactividadpersonal) {
        this.idactividadpersonal = idactividadpersonal;
    }

    public Long getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(Long idactividad) {
        this.idactividad = idactividad;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public LocalDate getFechacumplida() {
        return fechacumplida;
    }

    public void setFechacumplida(LocalDate fechacumplida) {
        this.fechacumplida = fechacumplida;
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
    
    
}
