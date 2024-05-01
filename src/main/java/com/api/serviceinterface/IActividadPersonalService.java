package com.api.serviceinterface;

import com.api.models.ActividadPersonal;
import com.api.clasesCompuestas.ActividadPersonalActividad;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.util.List;

/**
 *
 * @author Sebastian Carvajal
 */
public interface IActividadPersonalService {

    //Principales
    public List<ActividadPersonal> ListarTodo();

    public ActividadPersonal BuscarPorId(Long id);

    public ActividadPersonal Guardar(ActividadPersonal actividadPersonal);

    public ActividadPersonal Actualizar(ActividadPersonal actividadPersonal);

    public void EliminarPorId(Long id);

    //Secundarios
    public JsonObject GuardarActividadPersonalActividad(ActividadPersonalActividad actividadPersonalActividad);

    public JsonObject ListarActividadPersonalActividad(Long idusuario);
    
    public JsonObject VerActividadPersonalActividad(Long idActividadPersonal);
    
    public JsonObject CumplirActividadPersonal(ActividadPersonal actividadPersonal);
}
