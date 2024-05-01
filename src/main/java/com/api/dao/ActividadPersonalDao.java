
package com.api.dao;
import com.api.models.ActividadPersonal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Sebastian Carvajal
 */
public interface ActividadPersonalDao extends CrudRepository<ActividadPersonal, Long>{
    
    @Query("select v from ActividadPersonal v inner join Actividad a on v.idactividad = a.idactividad where v.idusuario = ?1 order by a.fechaculminacion desc")
    List<ActividadPersonal> ActividadPorIdusuario(Long idusuario);
}
