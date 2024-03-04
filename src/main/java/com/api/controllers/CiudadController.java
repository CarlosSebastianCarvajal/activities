
package com.api.controllers;

import com.api.models.Ciudad;
import com.api.serviceinterface.ICiudadService;
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
public class CiudadController {
    @Autowired
    private ICiudadService iCiudadService;
    
    @PostMapping("/listarCiudad")
    public List<Ciudad> listar(){
    	return iCiudadService.ListarTodo();
    }
    
    @PostMapping("/verCiudad/{id}")
    public Ciudad listarPorId(@PathVariable Long id){
    	return iCiudadService.BuscarPorId(id);
    }
    
    @PostMapping("/crearCiudad")
    @ResponseStatus(HttpStatus.CREATED)
    public Ciudad nuevo(@RequestBody Ciudad ciudad){
    	return iCiudadService.GuardarActualizar(ciudad);
    }
    
    @PostMapping("/editarCiudad")
    @ResponseStatus(HttpStatus.CREATED)
    public Ciudad editar(@RequestBody Ciudad ciudad){
        return iCiudadService.GuardarActualizar(ciudad);
    }
    
    @PostMapping("/eliminarCiudad/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iCiudadService.EliminarPorId(id);
    }
}
