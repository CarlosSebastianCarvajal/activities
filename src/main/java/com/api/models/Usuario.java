
package com.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Sebastian Carvajal
 */
@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;
    
    private Long idtipousuario, idpersona;
    private String usuario, clave;
    private boolean tienebloqueo;
    private String codigorec, codigoverificar;

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Long getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(Long idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public Long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Long idpersona) {
        this.idpersona = idpersona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isTienebloqueo() {
        return tienebloqueo;
    }

    public void setTienebloqueo(boolean tienebloqueo) {
        this.tienebloqueo = tienebloqueo;
    }

    public String getCodigorec() {
        return codigorec;
    }

    public void setCodigorec(String codigorec) {
        this.codigorec = codigorec;
    }

    public String getCodigoverificar() {
        return codigoverificar;
    }

    public void setCodigoverificar(String codigoverificar) {
        this.codigoverificar = codigoverificar;
    }
    
    
}
