
package com.api.controllers;

import com.api.models.ActividadEquipo;
import com.api.serviceinterface.IActividadEquipoService;
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
public class ActividadEquipoController {
    @Autowired
    private IActividadEquipoService iActividadEquipoService;
    
    @PostMapping("/listarActividadEquipo")
    public List<ActividadEquipo> listar(){
    	return iActividadEquipoService.ListarTodo();
    }
    
    @PostMapping("/verActividadEquipo/{id}")
    public ActividadEquipo listarPorId(@PathVariable Long id){
    	return iActividadEquipoService.BuscarPorId(id);
    }
    
    @PostMapping("/crearActividadEquipo")
    @ResponseStatus(HttpStatus.CREATED)
    public ActividadEquipo nuevo(@RequestBody ActividadEquipo actividadEquipo){
    	return iActividadEquipoService.GuardarActualizar(actividadEquipo);
    }
    
    @PostMapping("/editarActividadEquipo")
    @ResponseStatus(HttpStatus.CREATED)
    public ActividadEquipo editar(@RequestBody ActividadEquipo actividadEquipo){
        return iActividadEquipoService.GuardarActualizar(actividadEquipo);
    }
    
    @PostMapping("/eliminarActividadEquipo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iActividadEquipoService.EliminarPorId(id);
    }
}
