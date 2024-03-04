package com.api.service;

import com.api.serviceinterface.IActividadService;
import com.api.dao.ActividadDao;
import com.api.models.Actividad;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class ActividadServiceImpl implements IActividadService {

    @Autowired
    private ActividadDao actividadDao;

    @Override
    public List<Actividad> ListarTodo() {
        return (List<Actividad>) actividadDao.findAll();
    }

    @Override
    public Actividad BuscarPorId(Long id) {
        return actividadDao.findById(id).orElse(null);
    }

    @Override
    public Actividad GuardarActualizar(Actividad actividad) {
        actividad.setFechacreacion(new Date());
        return actividadDao.save(actividad);
    }

    @Override
    public void EliminarPorId(Long id) {
        actividadDao.deleteById(id);
    }

}
