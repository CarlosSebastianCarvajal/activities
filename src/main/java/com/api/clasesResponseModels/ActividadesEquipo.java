
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
    Long Cumplimiento;

    public ActividadesEquipo() {
    }

    public ActividadesEquipo(ActividadEquipo actividadEquipo, Actividad actividad, Long Cumplimiento) {
        this.actividadEquipo = actividadEquipo;
        this.actividad = actividad;
        this.Cumplimiento = Cumplimiento;
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

    public Long getCumplimiento() {
        return Cumplimiento;
    }

    public void setCumplimiento(Long Cumplimiento) {
        this.Cumplimiento = Cumplimiento;
    }
}
