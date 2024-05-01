
package com.api.dao;
import com.api.models.Equipo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Sebastian Carvajal
 */
public interface EquipoDao extends CrudRepository<Equipo, Object>{
    @Query("select e from Equipo e where e.idusuario = ?1")
    List<Equipo> ListarMisEquipos(Long idusuario);
    
    @Query("select e from Equipo e "
            + "inner join Integrante i on e.idequipo = i.idequipo "
            + "where i.idusuario = ?1")
    List<Equipo> ListarEquiposIngresados(Long idusuario);
}
