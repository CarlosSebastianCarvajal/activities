
package com.api.service;

import com.api.serviceinterface.IPaisService;
import com.api.dao.PaisDao;
import com.api.models.Pais;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class PaisServiceImpl implements IPaisService {

    @Autowired
    private PaisDao paisDao ;
    
    @Override
    public List<Pais> ListarTodo() {
        return (List<Pais>) paisDao.findAll();
    }

    @Override
    public Pais BuscarPorId(Long id) {
        return paisDao.findById(id).orElse(null);
    }

    @Override
    public Pais GuardarActualizar(Pais pais) {
        return paisDao.save(pais);
    }

    @Override
    public void EliminarPorId(Long id) {
        paisDao.deleteById(id);
    }
    
}
