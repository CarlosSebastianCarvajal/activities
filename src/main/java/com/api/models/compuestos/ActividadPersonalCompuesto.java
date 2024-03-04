
package com.api.models.compuestos;

import com.api.models.Actividad;
import com.api.models.ActividadPersonal;

/**
 *
 * @author Sebastian Carvajal
 */
public class ActividadPersonalCompuesto {
    private ActividadPersonal actividadpersonal;
    private Actividad actividad;

    public ActividadPersonal getActividadPersonal() {
        return actividadpersonal;
    }

    public void setActividadPersonal(ActividadPersonal actividadPersonal) {
        this.actividadpersonal = actividadPersonal;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
    
}
