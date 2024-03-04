
package com.api.serviceinterface;

import com.api.models.Integrante;
import java.util.List;
/**
 *
 * @author Sebastian Carvajal
 */
public interface IIntegranteService {
    //Principales
    public List<Integrante> ListarTodo();
    
    public Integrante BuscarPorId(Long id);
	
    public Integrante GuardarActualizar(Integrante integrante);
	
    public void EliminarPorId(Long id);  
    
    //Secundarios
    
}
