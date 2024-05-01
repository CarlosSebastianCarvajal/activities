
package com.api.clasesResponseModels;

import com.api.models.Equipo;

/**
 *
 * @author Sebastian Carvajal
 */
public class EquipoCumplimiento {
    Equipo equipo;
    Long idintegrante;

    public EquipoCumplimiento() {
    }

    public EquipoCumplimiento(Equipo equipo, Long idintegrante) {
        this.equipo = equipo;
        this.idintegrante = idintegrante;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Long getIdintegrante() {
        return idintegrante;
    }

    public void setIdintegrante(Long idintegrante) {
        this.idintegrante = idintegrante;
    }  
}
