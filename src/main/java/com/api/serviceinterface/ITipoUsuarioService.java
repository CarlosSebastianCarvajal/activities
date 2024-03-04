
package com.api.serviceinterface;

import com.api.models.TipoUsuario;
import java.util.List;

/**
 *
 * @author Sebastian Carvajal
 */
public interface ITipoUsuarioService {
    
    //Principales
    public List<TipoUsuario> ListarTodo();
    
    public TipoUsuario BuscarPorId(Long id);
	
    public TipoUsuario GuardarActualizar(TipoUsuario tipoUsuario);
	
    public void EliminarPorId(Long id);  
    
    //Secundarios
}
