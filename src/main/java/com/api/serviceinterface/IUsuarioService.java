
package com.api.serviceinterface;

import com.api.clasesCompuestas.UsuarioPersona;
import com.api.clasesRequestModels.IniciarSesionReqModel;
import com.api.models.Usuario;
import com.github.cliftonlabs.json_simple.JsonObject;
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
    public JsonObject IniciarSesion(IniciarSesionReqModel iniciarSesion);
    
    public JsonObject Registrarse(UsuarioPersona usuarioPersona);
}
