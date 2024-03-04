
package com.api.controllers;

import com.api.models.Usuario;
import com.api.serviceinterface.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sebastian Carvajal
 */
@RestController
public class UsuarioController {
    @Autowired
    private IUsuarioService iUsuarioService;
    
    @PostMapping("/listarUsuario")
    public List<Usuario> listar(){
    	return iUsuarioService.ListarTodo();
    }
    
    @PostMapping("/verUsuario/{id}")
    public Usuario listarPorId(@PathVariable Long id){
    	return iUsuarioService.BuscarPorId(id);
    }
    
    @PostMapping("/crearUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario nuevo(@RequestBody Usuario usuario){
    	return iUsuarioService.GuardarActualizar(usuario);
    }
    
    @PostMapping("/editarUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario editar(@RequestBody Usuario usuario){
        return iUsuarioService.GuardarActualizar(usuario);
    }
    
    @PostMapping("/eliminarUsuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iUsuarioService.EliminarPorId(id);
    }  
    
}
