
package com.api.clasesRequestModels;

/**
 *
 * @author Sebastian Carvajal
 */
public class ActividadEquipoIntegranteReqModel {
    Long idactividadequipo, idintegrante;

    public ActividadEquipoIntegranteReqModel() {
    }
    
    public ActividadEquipoIntegranteReqModel(Long idactividadequipo, Long idintegrante) {
        this.idactividadequipo = idactividadequipo;
        this.idintegrante = idintegrante;
    }

    public Long getIdactividadequipo() {
        return idactividadequipo;
    }

    public void setIdactividadequipo(Long idactividadequipo) {
        this.idactividadequipo = idactividadequipo;
    }

    public Long getIdintegrante() {
        return idintegrante;
    }

    public void setIdintegrante(Long idintegrante) {
        this.idintegrante = idintegrante;
    }
    
    
}
