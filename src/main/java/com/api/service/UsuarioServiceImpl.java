
package com.api.service;

import com.api.dao.UsuarioDao;
import com.api.models.Usuario;
import com.api.serviceinterface.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioDao usuarioDao ;
    
    @Override
    public List<Usuario> ListarTodo() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public Usuario BuscarPorId(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public Usuario GuardarActualizar(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public void EliminarPorId(Long id) {
        usuarioDao.deleteById(id);
    }

    
}
