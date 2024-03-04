
package com.api.controllers;

import com.api.models.RegistroSesion;
import com.api.serviceinterface.IRegistroSesionService;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class RegistroSesionController {
    
    @Autowired
    private IRegistroSesionService iRegistroSesionService;
    
    @PostMapping("/listarRegistroSesion")
    public List<RegistroSesion> listar(){
    	return iRegistroSesionService.ListarTodo();
    }
    
    @PostMapping("/verRegistroSesion/{id}")
    public RegistroSesion listarPorId(@PathVariable Long id){
    	return iRegistroSesionService.BuscarPorId(id);
    }
    
    @PostMapping("/crearRegistroSesion")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroSesion nuevo(@RequestBody RegistroSesion registroSesion){

    	return iRegistroSesionService.GuardarActualizar(registroSesion);
    }
    
    @PostMapping("/editarRegistroSesion")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroSesion editar(@RequestBody RegistroSesion registroSesion){
        return iRegistroSesionService.GuardarActualizar(registroSesion);
    }
    /*
    @PostMapping("/eliminarRegistroSesion/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iRegistroSesionService.EliminarPorId(id);
    } 
    */
}
