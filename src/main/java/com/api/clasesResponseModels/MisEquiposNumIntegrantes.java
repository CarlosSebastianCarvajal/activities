
package com.api.clasesResponseModels;

import com.api.models.Equipo;

/**
 *
 * @author Sebastian Carvajal
 */
public class MisEquiposNumIntegrantes {
    private Equipo equipo;
    private Long NumeroIntegrantes;

    public MisEquiposNumIntegrantes() {
    }

    public MisEquiposNumIntegrantes(Equipo equipo, Long NumeroIntegrantes) {
        this.equipo = equipo;
        this.NumeroIntegrantes = NumeroIntegrantes;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Long getNumeroIntegrantes() {
        return NumeroIntegrantes;
    }

    public void setNumeroIntegrantes(Long NumeroIntegrantes) {
        this.NumeroIntegrantes = NumeroIntegrantes;
    }
    
    
}
