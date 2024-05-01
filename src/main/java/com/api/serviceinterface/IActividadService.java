
package com.api.serviceinterface;

import com.api.models.Actividad;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.util.List;
/**
 *
 * @author Sebastian Carvajal
 */
public interface IActividadService {
    //Principales
    public List<Actividad> ListarTodo();
    
    public JsonObject BuscarPorId(Long id);
	
    public Actividad GuardarActualizar(Actividad actividad);
	
    public void EliminarPorId(Long id);  
    
    //Secundarios
}
