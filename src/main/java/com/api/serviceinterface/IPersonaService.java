/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.serviceinterface;

import com.api.models.Persona;
import java.util.List;

/**
 *
 * @author Sebastian Carvajal
 */
public interface IPersonaService {
    //Principales
    public List<Persona> ListarTodo();
    
    public Persona BuscarPorId(Long id);
	
    public Persona GuardarActualizar(Persona persona);
	
    public void EliminarPorId(Long id);  
    
    //Secundarios
    
}
