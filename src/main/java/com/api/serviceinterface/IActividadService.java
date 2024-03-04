
package com.api.serviceinterface;

import com.api.models.Actividad;
import java.util.List;
/**
 *
 * @author Sebastian Carvajal
 */
public interface IActividadService {
    //Principales
    public List<Actividad> ListarTodo();
    
    public Actividad BuscarPorId(Long id);
	
    public Actividad GuardarActualizar(Actividad actividad);
	
    public void EliminarPorId(Long id);  
    
    //Secundarios
}
