
package com.api.service;

import com.api.serviceinterface.ICumplimientoService;
import com.api.dao.CumplimientoDao;
import com.api.models.Cumplimiento;
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
    
    
    
}
