package com.api.service;

import com.api.serviceinterface.IActividadService;
import com.api.dao.ActividadDao;
import com.api.models.Actividad;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.time.LocalDate;
import java.util.Calendar;
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
    public JsonObject BuscarPorId(Long id) {
        JsonObject json = new JsonObject();
        Actividad a = actividadDao.findById(id).orElse(null);
        if(a != null){
            json.put("access", 1);
            json.put("message", "Datos Obtenidos correctamente");
            json.put("info", a);
        }else{
            json.put("access", 0);
            json.put("message", "Error al obtener la actividad");
            json.put("info", "void");
        }
        return json;
    }

    @Override
    public Actividad GuardarActualizar(Actividad actividad) {
        actividad.setFechacreacion(LocalDate.now());
        return actividadDao.save(actividad);
    }

    @Override
    public void EliminarPorId(Long id) {
        actividadDao.deleteById(id);
    }

}
