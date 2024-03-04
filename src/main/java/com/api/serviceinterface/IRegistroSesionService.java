
package com.api.serviceinterface;

import com.api.models.RegistroSesion;
import java.util.List;

/**
 *
 * @author Sebastian Carvajal
 */
public interface IRegistroSesionService {
    //Principales
    public List<RegistroSesion> ListarTodo();
    
    public RegistroSesion BuscarPorId(Long id);
	
    public RegistroSesion GuardarActualizar(RegistroSesion registroSesion);
	
    
    public void EliminarPorId(Long id);  
    
    //Secundarios
}
