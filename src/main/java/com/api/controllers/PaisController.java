
package com.api.controllers;

import com.api.models.Pais;
import com.api.serviceinterface.IPaisService;
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
public class PaisController {
    
    @Autowired
    private IPaisService iPaisService;
    
    @PostMapping("/listarPais")
    public List<Pais> listar(){
    	return iPaisService.ListarTodo();
    }
    
    @PostMapping("/verPais/{id}")
    public Pais listarPorId(@PathVariable Long id){
    	return iPaisService.BuscarPorId(id);
    }
    
    @PostMapping("/crearPais")
    @ResponseStatus(HttpStatus.CREATED)
    public Pais nuevo(@RequestBody Pais pais){
    	return iPaisService.GuardarActualizar(pais);
    }
    
    @PostMapping("/editarPais")
    @ResponseStatus(HttpStatus.CREATED)
    public Pais editar(@RequestBody Pais pais){
        return iPaisService.GuardarActualizar(pais);
    }
    
    @PostMapping("/eliminarPais/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iPaisService.EliminarPorId(id);
    }
}
