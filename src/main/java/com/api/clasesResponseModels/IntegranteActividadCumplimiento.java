package com.api.clasesResponseModels;

import com.api.models.Actividad;



/**
 *
 * @author Sebastian Carvajal
 */
public class IntegranteActividadCumplimiento {
    Actividad actividad;
    String estado;
    String fechaculminacion;
    String paisciudad;
    Long idactividadequipo;
    Long idcumplimiento;

    public IntegranteActividadCumplimiento() {
    }

    public IntegranteActividadCumplimiento(Actividad actividad, String estado, Long idactividadequipo, Long idcumplimiento, String fechaculminacion, String paisciudad) {
        this.actividad = actividad;
        this.estado = estado;
        this.idactividadequipo = idactividadequipo;
        this.idcumplimiento = idcumplimiento;
        this.fechaculminacion = fechaculminacion;
        this.paisciudad = paisciudad;
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

    public String getPaisciudad() {
        return paisciudad;
    }

    public void setPaisciudad(String paisciudad) {
        this.paisciudad = paisciudad;
    }
    
}
