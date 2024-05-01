
package com.api.clasesResponseModels;

import java.util.Date;

/**
 *
 * @author Sebastian Carvajal
 */
public class CumplimientoConDatos {
    Long idcumplimiento;
    String nombreintegrante, estado, observacion, pathdocevidencia;
    String fechacumplido;

    public CumplimientoConDatos() {
    }

    public CumplimientoConDatos(Long idcumplimiento, String nombreintegrante, String estado, String observacion, String pathdocevidencia, String fechacumplido) {
        this.idcumplimiento = idcumplimiento;
        this.nombreintegrante = nombreintegrante;
        this.estado = estado;
        this.observacion = observacion;
        this.pathdocevidencia = pathdocevidencia;
        this.fechacumplido = fechacumplido;
    }

    public Long getIdcumplimiento() {
        return idcumplimiento;
    }

    public void setIdcumplimiento(Long idcumplimiento) {
        this.idcumplimiento = idcumplimiento;
    }

    public String getNombreintegrante() {
        return nombreintegrante;
    }

    public void setNombreintegrante(String nombreintegrante) {
        this.nombreintegrante = nombreintegrante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getFechacumplido() {
        return fechacumplido;
    }

    public void setFechacumplido(String fechacumplido) {
        this.fechacumplido = fechacumplido;
    }
    
    
    
    
}
