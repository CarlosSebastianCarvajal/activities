
package com.api.controllers;

import com.api.clasesRequestModels.ActividadEquipoReqModel;
import com.api.clasesRequestModels.ActualizaActividadEquipoReqModel;
import com.api.clasesRequestModels.ListarActividadesCumplimientoReqModel;
import com.api.models.ActividadEquipo;
import com.api.serviceinterface.IActividadEquipoService;
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
    public JsonObject eliminar(@PathVariable Long id) {
        return iActividadEquipoService.EliminarPorId(id);
    }
    
    @PostMapping("/guardarActividadEquipoActividad")
    @ResponseStatus(HttpStatus.CREATED)
    public JsonObject GuardarActividadEquipoActividad(@RequestBody ActividadEquipoReqModel actividadEquipoReqModel){
    	return iActividadEquipoService.GuardarActividadEquipoActividad(actividadEquipoReqModel);
    }
    
    @PostMapping("/actualizaActividadEquipoActividad")
    @ResponseStatus(HttpStatus.CREATED)
    public JsonObject ActualizaActividadEquipoActividad(@RequestBody ActualizaActividadEquipoReqModel aaeReqModel){
    	return iActividadEquipoService.ActualizaActividadEquipoActividad(aaeReqModel);
    }
    
    @PostMapping("/detalleActividadEquipo/{idActividadEquipo}")
    public JsonObject DetalleActividadEquipo(@PathVariable Long idActividadEquipo){
    	return iActividadEquipoService.DetalleActividadEquipo(idActividadEquipo);
    }
    
    //    public JsonObject ListarActividadesEquipo(Long idEquipo) {
    @PostMapping("/listarActividadesEquipo/{idEquipo}")
    public JsonObject ListarActividadesEquipo(@PathVariable Long idEquipo){
    	return iActividadEquipoService.ListarActividadesEquipo(idEquipo);
    }
    

    //Cumplimiento
    @PostMapping("/listarActividadesEquipoCumplimiento")
    public JsonObject ListarActividadesEquipoCumplimiento(@RequestBody ListarActividadesCumplimientoReqModel lacReqModel){
    	return iActividadEquipoService.ListarActividadesEquipoCumplimiento(lacReqModel);
    }
    
    
    
}
