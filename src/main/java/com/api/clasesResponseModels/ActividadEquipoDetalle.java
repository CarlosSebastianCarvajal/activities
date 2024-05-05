
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
    String actividadfechacreacion, actividadfechalimite, paisciudad, cumplimiento;

    public ActividadEquipoDetalle() {
    }

    public ActividadEquipoDetalle(ActividadEquipo actividadEquipo, Actividad actividad, List<CumplimientoConDatos> listaCumplimiento, String actividadfechacreacion, String actividadfechalimite, String paisciudad, String cumplimiento) {
        this.actividadEquipo = actividadEquipo;
        this.actividad = actividad;
        this.listaCumplimiento = listaCumplimiento;
        this.actividadfechacreacion = actividadfechacreacion;
        this.actividadfechalimite = actividadfechalimite;
        this.paisciudad = paisciudad;
        this.cumplimiento = cumplimiento;
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

    public String getActividadfechacreacion() {
        return actividadfechacreacion;
    }

    public void setActividadfechacreacion(String actividadfechacreacion) {
        this.actividadfechacreacion = actividadfechacreacion;
    }

    public String getActividadfechalimite() {
        return actividadfechalimite;
    }

    public void setActividadfechalimite(String actividadfechalimite) {
        this.actividadfechalimite = actividadfechalimite;
    }

    public String getPaisciudad() {
        return paisciudad;
    }

    public void setPaisciudad(String paisciudad) {
        this.paisciudad = paisciudad;
    }

    public String getCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(String cumplimiento) {
        this.cumplimiento = cumplimiento;
    }
    
    
    
}
