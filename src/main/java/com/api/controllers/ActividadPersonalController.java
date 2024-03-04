
package com.api.controllers;

import com.api.models.ActividadPersonal;
import com.api.serviceinterface.IActividadPersonalService;
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
public class ActividadPersonalController {
    @Autowired
    private IActividadPersonalService iActividadService;
    
    @PostMapping("/listarActividadPersonal")
    public List<ActividadPersonal> listar(){
    	return iActividadService.ListarTodo();
    }
    
    @PostMapping("/verActividadPersonal/{id}")
    public ActividadPersonal listarPorId(@PathVariable Long id){
    	return iActividadService.BuscarPorId(id);
    }
    
    @PostMapping("/crearActividadPersonal")
    @ResponseStatus(HttpStatus.CREATED)
    public ActividadPersonal nuevo(@RequestBody ActividadPersonal actividadPersonal){
    	return iActividadService.Guardar(actividadPersonal);
    }
    
    @PostMapping("/editarActividadPersonal")
    @ResponseStatus(HttpStatus.CREATED)
    public ActividadPersonal editar(@RequestBody ActividadPersonal actividadPersonal){
        return iActividadService.Actualizar(actividadPersonal);
    }
    
    @PostMapping("/eliminarActividadPersonal/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iActividadService.EliminarPorId(id);
    }
}
