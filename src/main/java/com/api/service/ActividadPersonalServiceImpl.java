
package com.api.service;

import com.api.models.Actividad;
import com.api.dao.ActividadDao;

import com.api.serviceinterface.IActividadPersonalService;
import com.api.dao.ActividadPersonalDao;
import com.api.models.ActividadPersonal;
import com.api.models.compuestos.ActividadPersonalCompuesto;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class ActividadPersonalServiceImpl implements IActividadPersonalService{

    @Autowired
    private ActividadPersonalDao actividadPersonalDao;
    
    @Autowired
    private ActividadDao actividadDao;
    
    @Override
    public List<ActividadPersonal> ListarTodo() {
        return (List<ActividadPersonal>) actividadPersonalDao.findAll();
    }

    @Override
    public ActividadPersonal BuscarPorId(Long id) {
        return actividadPersonalDao.findById(id).orElse(null);
    }

    @Override
    public ActividadPersonal Guardar(ActividadPersonal actividadPersonal) {
        return actividadPersonalDao.save(actividadPersonal);
    }

    @Override
    public ActividadPersonal Actualizar(ActividadPersonal actividadPersonal) {
        ActividadPersonal ap = BuscarPorId(actividadPersonal.getIdactividadpersonal());
        
        actividadPersonal.setIdusuario(ap.getIdusuario());
        actividadPersonal.setIdactividad(ap.getIdactividad());
        actividadPersonal.setFechacumplida(new Date());
        return actividadPersonalDao.save(actividadPersonal);
    }
    
    @Override
    public void EliminarPorId(Long id) {
        actividadPersonalDao.deleteById(id);
    }

    @Override
    public ActividadPersonalCompuesto GuardarActividad_ActividadPersonal(ActividadPersonalCompuesto apc) {
        ActividadPersonalCompuesto res = null;
        Actividad actRes = actividadDao.save(apc.getActividad());
        
        ActividadPersonal actPEnvia = apc.getActividadPersonal();
        actPEnvia.setIdactividad(actRes.getIdactividad());
        ActividadPersonal actPRes = actividadPersonalDao.save(actPEnvia);
        
        res.setActividad(actRes);
        res.setActividadPersonal(actPRes);
        return res;
    }
    
    
    
}
