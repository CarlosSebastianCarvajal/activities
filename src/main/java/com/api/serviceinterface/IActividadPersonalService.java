
package com.api.serviceinterface;

import com.api.models.ActividadPersonal;
import com.api.models.compuestos.ActividadPersonalCompuesto;
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
    public ActividadPersonalCompuesto GuardarActividad_ActividadPersonal(ActividadPersonalCompuesto actividadPersonalCompuesto);
}
