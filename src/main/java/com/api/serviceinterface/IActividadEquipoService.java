
package com.api.serviceinterface;

import com.api.clasesRequestModels.ActividadEquipoIntegranteReqModel;
import com.api.clasesRequestModels.ActividadEquipoReqModel;
import com.api.clasesRequestModels.ActualizaActividadEquipoReqModel;
import com.api.clasesRequestModels.ListarActividadesCumplimientoReqModel;
import com.api.models.ActividadEquipo;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.util.List;
/**
 *
 * @author Sebastian Carvajal
 */
public interface IActividadEquipoService {
    //Principales
    public List<ActividadEquipo> ListarTodo();
    
    public ActividadEquipo BuscarPorId(Long id);
	
    public ActividadEquipo GuardarActualizar(ActividadEquipo actividadEquipo);
	
    public JsonObject EliminarPorId(Long id);  
    
    //Secundarios
    public JsonObject GuardarActividadEquipoActividad(ActividadEquipoReqModel actividadEquipoReqModel);
    
    public JsonObject ActualizaActividadEquipoActividad(ActualizaActividadEquipoReqModel actualizaActividadEquipoReqModel);
    
    public JsonObject DetalleActividadEquipo(Long idActividadEquipo);
    
    public JsonObject ListarActividadesEquipo(Long idEquipo);
    
    //Cumplimiento
    public JsonObject ListarActividadesEquipoCumplimiento(ListarActividadesCumplimientoReqModel lacReqModel);
    
    public JsonObject DetalleActividadEquipoCumplimiento(ActividadEquipoIntegranteReqModel aeiReqModel);
    //public JsonObject DetalleActividadEquipo(Long idActividadEquipo);
    
}
