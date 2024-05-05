
package com.api.dao;
import com.api.models.Actividad;
import com.api.models.ActividadEquipo;
import com.api.models.Cumplimiento;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Sebastian Carvajal
 */
public interface ActividadEquipoDao extends CrudRepository<ActividadEquipo, Object>{
    @Query("select a from ActividadEquipo a where a.idequipo = ?1 order by idactividadequipo desc")
    List<ActividadEquipo> ListarActividadesEquipoPorIdEquipo(Long idequipo);
    
    @Query("select a from Actividad a inner join ActividadEquipo ae on a.idactividad = ae.idactividad where ae.idactividadequipo = ?1 ")
    Actividad ActividadPorIdActividadEquipo(Long idactividadequipo);
    
    @Query("select c from Cumplimiento c where c.idactividadequipo = ?1 ")
    List<Cumplimiento> CumplimientoPorIdActividadEquipo(Long idactividadequipo);
    
}
