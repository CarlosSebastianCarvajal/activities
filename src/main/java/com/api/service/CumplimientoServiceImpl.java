
package com.api.service;

import com.api.serviceinterface.ICumplimientoService;
import com.api.dao.CumplimientoDao;
import com.api.models.Cumplimiento;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class CumplimientoServiceImpl implements ICumplimientoService{

    @Autowired
    private CumplimientoDao cumplimientoDao;
    
    @Override
    public List<Cumplimiento> ListarTodo() {
        return (List<Cumplimiento>) cumplimientoDao.findAll();
    }

    @Override
    public Cumplimiento BuscarPorId(Long id) {
        return cumplimientoDao.findById(id).orElse(null);
    }

    @Override
    public Cumplimiento Guardar(Cumplimiento cumplimiento) {
        return cumplimientoDao.save(cumplimiento);
    }

    @Override
    public Cumplimiento Actualizar(Cumplimiento cumplimiento) {
        Cumplimiento c = BuscarPorId(cumplimiento.getIdcumplimiento());
        
        cumplimiento.setIdintegrante(c.getIdintegrante());
        cumplimiento.setIdactividadequipo(c.getIdactividadequipo());
        cumplimiento.setFechacumplida(new Date());
        return cumplimientoDao.save(cumplimiento);
    }

    @Override
    public void EliminarPorId(Long id) {
        cumplimientoDao.deleteById(id);
    }

    @Override
    public JsonObject CumplirActividad(Cumplimiento cumplimientoReq) {
        JsonObject json = new JsonObject();
        Cumplimiento c = cumplimientoDao.findById(cumplimientoReq.getIdcumplimiento()).orElse(null);
        if(c != null){
            c.setFechacumplida(cumplimientoReq.getFechacumplida());
            c.setObservacion(cumplimientoReq.getObservacion());
            c.setPathdocevidencia(cumplimientoReq.getPathdocevidencia());
            cumplimientoDao.save(c);
            
            json.put("access", 1);
            json.put("message", "Se ha registrado el cumplimiento");
            json.put("info", c);
        }else{
            json.put("access", 0);
            json.put("message", "Error, no se pudo encontrar el registro de cumplimiento");
            json.put("info", "void");
        }
        return json;
    }
    
    
    
}
