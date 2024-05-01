
package com.api.dao;
import com.api.models.Integrante;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Sebastian Carvajal
 */
public interface IntegranteDao extends CrudRepository<Integrante, Object>{
    @Query("select v from Integrante v where v.idequipo = ?1 and v.activo = true")
    List<Integrante> IntegrantesPorIdEquipo(Long idequipo);
    
    @Query("select count(v) from Integrante v where v.idequipo = ?1 and v.activo = true")
    Long ContarIntegrantesPorIdEquipo(Long idequipo);
    
    //Cumplimiento
    @Query("select i from Integrante i where i.idequipo = ?1 and i.idusuario = ?2")
    Integrante IntegrantePorUsuarioEquipo(Long idequipo, Long idusuario);
}
