
package com.api.controllers;

import com.api.models.TipoUsuario;
import com.api.serviceinterface.ITipoUsuarioService;
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
public class TipoUsuarioController {
    
    @Autowired
    private ITipoUsuarioService iTipoUsuarioService;
    
    @PostMapping("/listarTipoUsuario")
    public List<TipoUsuario> listar(){
    	return iTipoUsuarioService.ListarTodo();
    }
    
    @PostMapping("/verTipoUsuario/{id}")
    public TipoUsuario listarPorId(@PathVariable Long id){
    	return iTipoUsuarioService.BuscarPorId(id);
    }
    
    @PostMapping("/crearTipoUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public TipoUsuario nuevo(@RequestBody TipoUsuario tipoUsuario){
    	return iTipoUsuarioService.GuardarActualizar(tipoUsuario);
    }
    
    @PostMapping("/editarTipoUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public TipoUsuario editar(@RequestBody TipoUsuario tipoUsuario){
        return iTipoUsuarioService.GuardarActualizar(tipoUsuario);
    }
    
    @PostMapping("/eliminarTipoUsuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iTipoUsuarioService.EliminarPorId(id);
    }       
        
    
}
