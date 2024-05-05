
package com.api.controllers;

import com.api.clasesRequestModels.EquipoCorreoIntegrantesReqModel;
import com.api.clasesRequestModels.EquipoIntegrantesReqModel;
import com.api.models.Equipo;
import com.api.serviceinterface.IEquipoService;
import com.github.cliftonlabs.json_simple.JsonObject;
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
    public JsonObject nuevo(@RequestBody Equipo equipo){
    	return iEquipoService.Guardar(equipo);
    }
    
    @PostMapping("/editarEquipo")
    @ResponseStatus(HttpStatus.CREATED)
    public JsonObject editar(@RequestBody Equipo equipo){
        return iEquipoService.Actualizar(equipo);
    }
    
    @PostMapping("/eliminarEquipo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iEquipoService.EliminarPorId(id);
    }
    
    @PostMapping("/guardarEquipoIntegrantes")
    @ResponseStatus(HttpStatus.CREATED)
    public JsonObject GuardarEquipoIntegrantes(@RequestBody EquipoIntegrantesReqModel eirq) {
        return iEquipoService.GuardarEquipoIntegrantes(eirq);
    }
    
    @PostMapping("/guardarEquipoIntegrantesListaCorreo")
    @ResponseStatus(HttpStatus.CREATED)
    public JsonObject GuardarEquipoIntegrantesListaCorreo(@RequestBody EquipoCorreoIntegrantesReqModel ecirq){
        return iEquipoService.GuardarEquipoIntegrantesListaCorreo(ecirq);
    }
    
    @PostMapping("/listarMisEquipos/{idUsuario}")
    public JsonObject ListarMisEquipos(@PathVariable Long idUsuario){
    	return iEquipoService.ListarMisEquipos(idUsuario);
    }
    
    //Cumplimiento
    @PostMapping("/listarEquiposIngresados/{idUsuario}")
    public JsonObject ListarEquiposIngresados(@PathVariable Long idUsuario){
    	return iEquipoService.ListarEquiposIngresados(idUsuario);
    }
}
