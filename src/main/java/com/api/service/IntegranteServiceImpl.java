
package com.api.service;

import com.api.serviceinterface.IIntegranteService;
import com.api.dao.IntegranteDao;
import com.api.models.Integrante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class IntegranteServiceImpl implements IIntegranteService{

    @Autowired
    private IntegranteDao integranteDao ;
    
    
    @Override
    public List<Integrante> ListarTodo() {
        return (List<Integrante>) integranteDao.findAll();
    }

    @Override
    public Integrante BuscarPorId(Long id) {
        return integranteDao.findById(id).orElse(null);
    }

    @Override
    public Integrante GuardarActualizar(Integrante integrante) {
        return integranteDao.save(integrante);
    }

    @Override
    public void EliminarPorId(Long id) {
        integranteDao.deleteById(id);
    }
    
    
    
}
