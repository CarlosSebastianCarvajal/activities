
package com.api.clasesRequestModels;

import com.api.models.Actividad;

/**
 *
 * @author Sebastian Carvajal
 */
public class ActualizaActividadEquipoReqModel {
    private Long idactividadequipo;
    private Actividad actividad;

    public ActualizaActividadEquipoReqModel() {
    }

    public ActualizaActividadEquipoReqModel(Long idequipo, Actividad actividad) {
        this.idactividadequipo = idequipo;
        this.actividad = actividad;
    }

    public Long getIdactividadequipo() {
        return idactividadequipo;
    }

    public void setIdactividadequipo(Long idactividadequipo) {
        this.idactividadequipo = idactividadequipo;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
    
            
}
