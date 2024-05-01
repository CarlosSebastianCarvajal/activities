
package com.api.clasesRequestModels;

import com.api.models.Equipo;
import com.api.models.Integrante;
import java.util.List;

/**
 *
 * @author Sebastian Carvajal
 */
public class EquipoIntegrantesReqModel {
    Equipo equipo;
    List<Integrante> integrantes;

    public EquipoIntegrantesReqModel() {
    }

    public EquipoIntegrantesReqModel(Equipo equipo, List<Integrante> integrantes) {
        this.equipo = equipo;
        this.integrantes = integrantes; 
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }
    
    
}
