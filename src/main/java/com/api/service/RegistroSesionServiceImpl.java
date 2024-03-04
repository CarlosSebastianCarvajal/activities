
package com.api.service;

import com.api.dao.RegistroSesionDao;
import com.api.models.RegistroSesion;
import com.api.serviceinterface.IRegistroSesionService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class RegistroSesionServiceImpl implements IRegistroSesionService{
    
    @Autowired
    private RegistroSesionDao registroSesionDao ;

    @Override
    public List<RegistroSesion> ListarTodo() {
        return (List<RegistroSesion>) registroSesionDao.findAll();
    }

    @Override
    public RegistroSesion BuscarPorId(Long id) {
        return registroSesionDao.findById(id).orElse(null);
    }

    @Override
    public RegistroSesion GuardarActualizar(RegistroSesion registroSesion) {
     
        LocalDateTime now = LocalDateTime.now();
        registroSesion.setFechahorainicio(Timestamp.valueOf(now));
        
        return registroSesionDao.save(registroSesion);
    }

    @Override
    public void EliminarPorId(Long id) {
        registroSesionDao.deleteById(id);
    }
    
    
}
