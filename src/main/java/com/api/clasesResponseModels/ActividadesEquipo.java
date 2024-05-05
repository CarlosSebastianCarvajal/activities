package com.api.clasesResponseModels;

import com.api.models.Actividad;
import com.api.models.ActividadEquipo;

/**
 *
 * @author Sebastian Carvajal
 */
public class ActividadesEquipo {

    ActividadEquipo actividadEquipo;
    Actividad actividad;
    String Cumplimiento;
    String FechaCulminacionTexto;

    public ActividadesEquipo() {
    }

    public ActividadesEquipo(ActividadEquipo actividadEquipo, Actividad actividad, String Cumplimiento, String FechaTexto) {
        this.actividadEquipo = actividadEquipo;
        this.actividad = actividad;
        this.Cumplimiento = Cumplimiento;
        this.FechaCulminacionTexto = FechaTexto;
    }

    public ActividadEquipo getActividadEquipo() {
        return actividadEquipo;
    }

    public void setActividadEquipo(ActividadEquipo actividadEquipo) {
        this.actividadEquipo = actividadEquipo;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public String getCumplimiento() {
        return Cumplimiento;
    }

    public void setCumplimiento(String Cumplimiento) {
        this.Cumplimiento = Cumplimiento;
    }

    public String getFechaCulminacionTexto() {
        return FechaCulminacionTexto;
    }

    public void setFechaCulminacionTexto(String FechaCulminacionTexto) {
        this.FechaCulminacionTexto = FechaCulminacionTexto;
    }

}
