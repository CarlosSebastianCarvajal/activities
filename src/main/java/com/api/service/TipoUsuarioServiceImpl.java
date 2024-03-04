
package com.api.service;

import com.api.serviceinterface.ITipoUsuarioService;
import com.api.dao.TipoUsuarioDao;
import com.api.models.TipoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class TipoUsuarioServiceImpl implements ITipoUsuarioService {
    
    @Autowired
    private TipoUsuarioDao tipoUsuarioDao ;

    @Override
    public List<TipoUsuario> ListarTodo() {
        return (List<TipoUsuario>) tipoUsuarioDao.findAll();
    }

    @Override
    public TipoUsuario BuscarPorId(Long id) {
        return tipoUsuarioDao.findById(id).orElse(null);
    }

    @Override
    public TipoUsuario GuardarActualizar(TipoUsuario tipoUsuario) {
        return tipoUsuarioDao.save(tipoUsuario);
    }

    @Override
    public void EliminarPorId(Long id) {
        tipoUsuarioDao.deleteById(id);
    }
	
	
}
