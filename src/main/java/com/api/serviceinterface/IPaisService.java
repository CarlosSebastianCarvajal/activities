
package com.api.serviceinterface;

import com.api.models.Pais;
import java.util.List;

/**
 *
 * @author Sebastian Carvajal
 */
public interface IPaisService {
    //Principales
    public List<Pais> ListarTodo();
    
    public Pais BuscarPorId(Long id);
	
    public Pais GuardarActualizar(Pais pais);
	
    public void EliminarPorId(Long id);  
    
    //Secundarios
}
