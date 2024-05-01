package com.api.clasesCompuestas;

import com.api.models.Actividad;

/**
 *
 * @author Sebastian Carvajal
 */
public class ActividadPersonalActividad {

    private Long idusuario;
    private Actividad actividad;

    public ActividadPersonalActividad() {
    }

    public ActividadPersonalActividad(Long idusuario, Actividad actividad) {
        this.idusuario = idusuario;
        this.actividad = actividad;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    

}
