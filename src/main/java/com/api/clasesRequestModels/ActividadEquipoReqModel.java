
package com.api.clasesRequestModels;

import com.api.models.Actividad;

/**
 *
 * @author Sebastian Carvajal
 */
public class ActividadEquipoReqModel {
    private Long idequipo;
    private Actividad actividad;

    public ActividadEquipoReqModel() {
    }

    public ActividadEquipoReqModel(Long idequipo, Actividad actividad) {
        this.idequipo = idequipo;
        this.actividad = actividad;
    }

    public Long getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Long idequipo) {
        this.idequipo = idequipo;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
    
            
}
