
package com.api.serviceinterface;

import com.api.models.Integrante;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.util.List;
/**
 *
 * @author Sebastian Carvajal
 */
public interface IIntegranteService {
    //Principales
    public List<Integrante> ListarTodo();
    
    public Integrante BuscarPorId(Long id);
	
    public Integrante GuardarActualizar(Integrante integrante);
	
    public void EliminarPorId(Long id);  
    
    //Secundarios
    public JsonObject VerIntegrantesPorIdEquipo(Long idequipo);
    
    public JsonObject AgregarIntegrantes(List<Integrante> listaIntegrantes);
    
    public JsonObject QuitarIntegrante(Long idIntegrante);
}
