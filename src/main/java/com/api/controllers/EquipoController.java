
package com.api.controllers;

import com.api.models.Equipo;
import com.api.serviceinterface.IEquipoService;
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
public class EquipoController {
    @Autowired
    private IEquipoService iEquipoService;
    
    @PostMapping("/listarEquipo")
    public List<Equipo> listar(){
    	return iEquipoService.ListarTodo();
    }
    
    @PostMapping("/verEquipo/{id}")
    public Equipo listarPorId(@PathVariable Long id){
    	return iEquipoService.BuscarPorId(id);
    }
    
    @PostMapping("/crearEquipo")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo nuevo(@RequestBody Equipo equipo){
    	return iEquipoService.GuardarActualizar(equipo);
    }
    
    @PostMapping("/editarEquipo")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo editar(@RequestBody Equipo equipo){
        return iEquipoService.GuardarActualizar(equipo);
    }
    
    @PostMapping("/eliminarEquipo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iEquipoService.EliminarPorId(id);
    }
}
