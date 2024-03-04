
package com.api.service;

import com.api.serviceinterface.IActividadEquipoService;
import com.api.dao.ActividadEquipoDao;
import com.api.models.ActividadEquipo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class ActividadEquipoServiceImpl implements IActividadEquipoService{

    @Autowired
    private ActividadEquipoDao actividadEquipoDao;

    @Override
    public List<ActividadEquipo> ListarTodo() {
        return (List<ActividadEquipo>) actividadEquipoDao.findAll();
    }

    @Override
    public ActividadEquipo BuscarPorId(Long id) {
        return actividadEquipoDao.findById(id).orElse(null);
    }

    @Override
    public ActividadEquipo GuardarActualizar(ActividadEquipo actividadEquipo) {
        return actividadEquipoDao.save(actividadEquipo);
    }

    @Override
    public void EliminarPorId(Long id) {
        actividadEquipoDao.deleteById(id);
    }
    
    
    
    
}
