
package com.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author Sebastian Carvajal
 */
@Entity
@Table(name="cumplimiento")
public class Cumplimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcumplimiento;
    
    private Long idintegrante, idactividadequipo;
    
    private LocalDate fechacumplida;
    
    private String observacion, pathdocevidencia;

    public Cumplimiento() {
    }

    public Cumplimiento(Long idcumplimiento, Long idintegrante, Long idactividadequipo, LocalDate fechacumplida, String observacion, String pathdocevidencia) {
        this.idcumplimiento = idcumplimiento;
        this.idintegrante = idintegrante;
        this.idactividadequipo = idactividadequipo;
        this.fechacumplida = fechacumplida;
        this.observacion = observacion;
        this.pathdocevidencia = pathdocevidencia;
    }
    
    
    
    public Cumplimiento(Long idintegrante, Long idactividadequipo) {
        this.idintegrante = idintegrante;
        this.idactividadequipo = idactividadequipo;
    }
    
    public Long getIdcumplimiento() {
        return idcumplimiento;
    }

    public void setIdcumplimiento(Long idcumplimiento) {
        this.idcumplimiento = idcumplimiento;
    }

    public Long getIdintegrante() {
        return idintegrante;
    }

    public void setIdintegrante(Long idintegrante) {
        this.idintegrante = idintegrante;
    }

    public Long getIdactividadequipo() {
        return idactividadequipo;
    }

    public void setIdactividadequipo(Long idactividadequipo) {
        this.idactividadequipo = idactividadequipo;
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
