
package com.api.dao;
import com.api.models.Cumplimiento;
import com.api.models.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Sebastian Carvajal
 */
public interface CumplimientoDao extends CrudRepository<Cumplimiento, Object>{
    @Query("select count(c) from Cumplimiento c where c.idactividadequipo = ?1 AND c.fechacumplida IS NOT NULL")
    Long ContarCumplimientoActividad(Long idactividadequipo);
    
    @Query("delete from Cumplimiento c where c.idactividadequipo = ?1")
    void EliminarPorIdActividadEquipo(Long idactividadequipo);
    
    @Query("select p from Persona p "
            + "inner join Usuario u on p.idpersona = u.idpersona "
            + "inner join Integrante i on u.idusuario = i.idusuario "
            + "inner join Cumplimiento c on i.idintegrante = c.idintegrante "
            + "where c.idcumplimiento = ?1 ")
    Persona PersonaPorCumplimiento(Long idcumplimiento);
    
    @Query("select c from Cumplimiento c where c.idactividadequipo = ?1 AND c.idintegrante = ?2")
    Cumplimiento CumplimientoActividad(Long idactividadequipo, Long idintegrante);
}
