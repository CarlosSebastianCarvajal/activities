
package com.api.controllers;

import com.api.models.Actividad;
import com.api.serviceinterface.IActividadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Sebastian Carvajal
 */
@CrossOrigin(origins = "*")
@RestController
public class ActividadController {
    @Autowired
    private IActividadService iActividadService;
    
    @PostMapping("/listarActividad")
    public List<Actividad> listar(){
    	return iActividadService.ListarTodo();
    }
    
    @PostMapping("/verActividad/{id}")
    public Actividad listarPorId(@PathVariable Long id){
    	return iActividadService.BuscarPorId(id);
    }
    
    @PostMapping("/crearActividad")
    @ResponseStatus(HttpStatus.CREATED)
    public Actividad nuevo(@RequestBody Actividad actividad){
    	return iActividadService.GuardarActualizar(actividad);
    }
    
    @PostMapping("/editarActividad")
    @ResponseStatus(HttpStatus.CREATED)
    public Actividad editar(@RequestBody Actividad actividad){
        return iActividadService.GuardarActualizar(actividad);
    }
    
    @PostMapping("/eliminarActividad/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iActividadService.EliminarPorId(id);
    }
}
