/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.controllers;

import com.api.models.Persona;
import com.api.serviceinterface.IPersonaService;
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
public class PersonaController {
    
    @Autowired
    private IPersonaService iPersonaService;
    
    @PostMapping("/listarPersona")
    public List<Persona> listar(){
    	return iPersonaService.ListarTodo();
    }
    
    @PostMapping("/verPersona/{id}")
    public Persona listarPorId(@PathVariable Long id){
    	return iPersonaService.BuscarPorId(id);
    }
    
    @PostMapping("/crearPersona")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona nuevo(@RequestBody Persona persona){
    	return iPersonaService.GuardarActualizar(persona);
    }
    
    @PostMapping("/editarPersona")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona editar(@RequestBody Persona persona){
        return iPersonaService.GuardarActualizar(persona);
    }
    
    @PostMapping("/eliminarPersona/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iPersonaService.EliminarPorId(id);
    }
}
