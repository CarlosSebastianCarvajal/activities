
package com.api.service;

import com.api.serviceinterface.IEquipoService;
import com.api.dao.EquipoDao;
import com.api.models.Equipo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class EquipoServiceImpl implements IEquipoService{
    
    @Autowired
    private EquipoDao equipoDao;

    @Override
    public List<Equipo> ListarTodo() {
        return (List<Equipo>) equipoDao.findAll();
    }

    @Override
    public Equipo BuscarPorId(Long id) {
        return equipoDao.findById(id).orElse(null);
    }

    @Override
    public Equipo GuardarActualizar(Equipo equipo) {
        return equipoDao.save(equipo);
    }

    @Override
    public void EliminarPorId(Long id) {
        equipoDao.deleteById(id);
    }
    
    
}
