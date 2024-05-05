
package com.api.serviceinterface;

import com.api.clasesRequestModels.EquipoCorreoIntegrantesReqModel;
import com.api.clasesRequestModels.EquipoIntegrantesReqModel;
import com.api.models.Equipo;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.util.List;
/**
 *
 * @author Sebastian Carvajal
 */
public interface IEquipoService{
    //Principales
    public List<Equipo> ListarTodo();
    
    public Equipo BuscarPorId(Long id);
	
    public JsonObject Guardar(Equipo equipo);
    
    public JsonObject Actualizar(Equipo equipo);
	
    public void EliminarPorId(Long id);  
    
    //Secundarios
    public JsonObject GuardarEquipoIntegrantes(EquipoIntegrantesReqModel eirq);
    
    public JsonObject GuardarEquipoIntegrantesListaCorreo(EquipoCorreoIntegrantesReqModel ecirq);
   
    public JsonObject ListarMisEquipos(Long idUsuario);
    
    //Cumplimiento
    public JsonObject ListarEquiposIngresados(Long idUsuario);
}
