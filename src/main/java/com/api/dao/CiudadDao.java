
package com.api.dao;

import com.api.models.Ciudad;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian Carvajal
 */
public interface CiudadDao extends CrudRepository<Ciudad, Object>{
    
    
    
    @Query("select c from Ciudad c where c.idpais = ?1")
    List<Ciudad> ListarCiudadesPorIdPais(Long idpais);
}
