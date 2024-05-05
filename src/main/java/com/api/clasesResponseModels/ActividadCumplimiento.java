package com.api.clasesResponseModels;

import com.api.models.Actividad;



/**
 *
 * @author Sebastian Carvajal
 */
public class ActividadCumplimiento {
    Actividad actividad;
    String estado;
    String fechaculminacion;
    Long idactividadequipo;
    Long idcumplimiento;

    public ActividadCumplimiento() {
    }

    public ActividadCumplimiento(Actividad actividad, String estado, Long idactividadequipo, Long idcumplimiento, String fechaculminacion) {
        this.actividad = actividad;
        this.estado = estado;
        this.idactividadequipo = idactividadequipo;
        this.idcumplimiento = idcumplimiento;
        this.fechaculminacion = fechaculminacion;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Long getIdactividadequipo() {
        return idactividadequipo;
    }

    public void setIdactividadequipo(Long idactividadequipo) {
        this.idactividadequipo = idactividadequipo;
    }
    
    public Long getIdcumplimiento() {
        return idcumplimiento;
    }

    public void setIdcumplimiento(Long idcumplimiento) {
        this.idcumplimiento = idcumplimiento;
    }

    public String getFechaculminacion() {
        return fechaculminacion;
    }

    public void setFechaculminacion(String fechaculminacion) {
        this.fechaculminacion = fechaculminacion;
    }
    
    
}
