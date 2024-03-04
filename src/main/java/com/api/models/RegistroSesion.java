
package com.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
/**
 *
 * @author Sebastian Carvajal
 */
@Entity
@Table(name="registrosesion")
public class RegistroSesion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idregistrosesion;
    
    private Long idusuario;
    private Timestamp fechahorainicio, fechahorafin;

    public Long getIdregistrosesion() {
        return idregistrosesion;
    }

    public void setIdregistrosesion(Long idregistrosesion) {
        this.idregistrosesion = idregistrosesion;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Timestamp getFechahorainicio() {
        return fechahorainicio;
    }

    public void setFechahorainicio(Timestamp fechahorainicio) {
        this.fechahorainicio = fechahorainicio;
    }

    public Timestamp getFechahorafin() {
        return fechahorafin;
    }

    public void setFechahorafin(Timestamp fechahorafin) {
        this.fechahorafin = fechahorafin;
    }
    
    
}
