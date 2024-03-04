/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.serviceinterface;

import com.api.models.Ciudad;
import java.util.List;

/**
 *
 * @author Sebastian Carvajal
 */

public interface ICiudadService {
    //Principales
    public List<Ciudad> ListarTodo();
    
    public Ciudad BuscarPorId(Long id);
	
    public Ciudad GuardarActualizar(Ciudad ciudad);
	
    public void EliminarPorId(Long id);  
    
    //Secundarios
}
