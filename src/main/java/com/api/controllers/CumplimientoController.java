
package com.api.controllers;

import com.api.models.Cumplimiento;
import com.api.serviceinterface.ICumplimientoService;
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
public class CumplimientoController {
    @Autowired
    private ICumplimientoService iCumplimientoService;
    
    @PostMapping("/listarCumplimiento")
    public List<Cumplimiento> listar(){
    	return iCumplimientoService.ListarTodo();
    }
    
    @PostMapping("/verCumplimiento/{id}")
    public Cumplimiento listarPorId(@PathVariable Long id){
    	return iCumplimientoService.BuscarPorId(id);
    }
    
    @PostMapping("/crearCumplimiento")
    @ResponseStatus(HttpStatus.CREATED)
    public Cumplimiento nuevo(@RequestBody Cumplimiento cumplimiento){
    	return iCumplimientoService.Guardar(cumplimiento);
    }
    
    @PostMapping("/editarCumplimiento")
    @ResponseStatus(HttpStatus.CREATED)
    public Cumplimiento editar(@RequestBody Cumplimiento cumplimiento){
        return iCumplimientoService.Actualizar(cumplimiento);
    }
    
    @PostMapping("/eliminarCumplimiento/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iCumplimientoService.EliminarPorId(id);
    }
}
