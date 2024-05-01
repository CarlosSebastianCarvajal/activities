
package com.api.clasesResponseModels;

import com.api.models.Actividad;
import com.api.models.ActividadEquipo;
import java.util.List;

/**
 *
 * @author Sebastian Carvajal
 */
public class ActividadEquipoDetalle {
    ActividadEquipo actividadEquipo;
    Actividad actividad;
    List<CumplimientoConDatos> listaCumplimiento;

    public ActividadEquipoDetalle() {
    }

    public ActividadEquipoDetalle(ActividadEquipo actividadEquipo, Actividad actividad, List<CumplimientoConDatos> listaCumplimiento) {
        this.actividadEquipo = actividadEquipo;
        this.actividad = actividad;
        this.listaCumplimiento = listaCumplimiento;
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

    public List<CumplimientoConDatos> getListaCumplimiento() {
        return listaCumplimiento;
    }

    public void setListaCumplimiento(List<CumplimientoConDatos> listaCumplimiento) {
        this.listaCumplimiento = listaCumplimiento;
    }
    
    
}
