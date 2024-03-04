
package com.api.serviceinterface;

import com.api.models.Equipo;
import java.util.List;
/**
 *
 * @author Sebastian Carvajal
 */
public interface IEquipoService{
    //Principales
    public List<Equipo> ListarTodo();
    
    public Equipo BuscarPorId(Long id);
	
    public Equipo GuardarActualizar(Equipo equipo);
	
    public void EliminarPorId(Long id);  
    
    //Secundarios
}
