
package com.api.serviceinterface;

import com.api.models.Usuario;
import java.util.List;

/**
 *
 * @author Sebastian Carvajal
 */
public interface IUsuarioService {
    //Principales
    public List<Usuario> ListarTodo();
    
    public Usuario BuscarPorId(Long id);
	
    public Usuario GuardarActualizar(Usuario usuario);
	
    public void EliminarPorId(Long id);  
    
    //Secundarios
}
