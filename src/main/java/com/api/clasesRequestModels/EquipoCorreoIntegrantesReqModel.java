
package com.api.clasesRequestModels;

import com.api.models.Equipo;
import java.util.List;

/**
 *
 * @author Sebastian Carvajal
 */
public class EquipoCorreoIntegrantesReqModel {
    Equipo equipo;
    List<String> correosintegrantes;

    public EquipoCorreoIntegrantesReqModel() {
    }

    public EquipoCorreoIntegrantesReqModel(Equipo equipo, List<String> integrantes) {
        this.equipo = equipo;
        this.correosintegrantes = integrantes; 
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<String> getCorreosintegrantes() {
        return correosintegrantes;
    }

    public void setCorreosintegrantes(List<String> correosintegrantes) {
        this.correosintegrantes = correosintegrantes;
    }
    
    
}
