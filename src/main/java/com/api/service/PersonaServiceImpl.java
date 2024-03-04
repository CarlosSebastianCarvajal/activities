/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.service;
import com.api.dao.PersonaDao;
import com.api.models.Persona;
import com.api.serviceinterface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class PersonaServiceImpl implements IPersonaService{

    @Autowired
    private PersonaDao personaDao;
    
    @Override
    public List<Persona> ListarTodo() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    public Persona BuscarPorId(Long id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public Persona GuardarActualizar(Persona persona) {
        return personaDao.save(persona);
    }

    @Override
    public void EliminarPorId(Long id) {
        personaDao.deleteById(id);
    }
    
}
