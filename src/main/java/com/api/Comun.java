
package com.api;

import com.api.dao.CiudadDao;
import com.api.dao.PaisDao;
import com.api.models.Ciudad;
import com.api.models.Pais;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian Carvajal
 */

public class Comun {

    private CiudadDao ciudadDao;
    private PaisDao paisDao;
    
    public Comun() {
    }

    public Comun(CiudadDao ciudadDao, PaisDao paisDao) {
        this.ciudadDao = ciudadDao;
        this.paisDao = paisDao;
    }
    public String FechaString(LocalDate fecha){
        String meses[] = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Agosto", "Noviembre", "Diciembre"};
        String dia = (fecha.getDayOfMonth() < 10) ? "0" + fecha.getDayOfMonth() : String.valueOf(fecha.getDayOfMonth());
        return dia + "/" + meses[fecha.getMonthValue()] + "/" + fecha.getYear();
    }
    
    public String PaisCiudadString(Long idciudad){
        String retorno = "";
        Ciudad ciudad = ciudadDao.findById(idciudad).orElse(null);
        if(ciudad != null){
            Pais pais = paisDao.findById(ciudad.getIdpais()).orElse(null);
            if(pais != null){
                retorno = ciudad.getNombre() + "/" + pais.getNombre();
            }
        }
        return retorno;
    }
}
