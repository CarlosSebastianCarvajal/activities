
package com.api.clasesRequestModels;

/**
 *
 * @author Sebastian Carvajal
 */
public class ListarActividadesCumplimientoReqModel {
    Long idequipo, idintegrante;

    public ListarActividadesCumplimientoReqModel() {
    }

    public ListarActividadesCumplimientoReqModel(Long idequipo, Long idusuario) {
        this.idequipo = idequipo;
        this.idintegrante = idusuario;
    }

    public Long getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Long idequipo) {
        this.idequipo = idequipo;
    }

    public Long getIdintegrante() {
        return idintegrante;
    }

    public void setIdintegrante(Long idintegrante) {
        this.idintegrante = idintegrante;
    }
}
