
package com.api.serviceinterface;

import com.api.models.ActividadEquipo;
import java.util.List;
/**
 *
 * @author Sebastian Carvajal
 */
public interface IActividadEquipoService {
    //Principales
    public List<ActividadEquipo> ListarTodo();
    
    public ActividadEquipo BuscarPorId(Long id);
	
    public ActividadEquipo GuardarActualizar(ActividadEquipo actividadEquipo);
	
    public void EliminarPorId(Long id);  
    
    //Secundarios
}
