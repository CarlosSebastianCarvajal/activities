
package com.api.service;

import com.api.serviceinterface.ICiudadService;
import com.api.dao.CiudadDao;
import com.api.models.Ciudad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class CiudadServiceImpl implements ICiudadService{

    @Autowired
    private CiudadDao ciudadDao;
    
    @Override
    public List<Ciudad> ListarTodo() {
        return (List<Ciudad>) ciudadDao.findAll();
    }

    @Override
    public Ciudad BuscarPorId(Long id) {
        return ciudadDao.findById(id).orElse(null);
    }

    @Override
    public Ciudad GuardarActualizar(Ciudad ciudad) {
        return ciudadDao.save(ciudad);
    }

    @Override
    public void EliminarPorId(Long id) {
        ciudadDao.deleteById(id);
    }
    
}
