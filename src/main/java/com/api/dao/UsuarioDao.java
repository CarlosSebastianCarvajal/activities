
package com.api.dao;

import com.api.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian Carvajal
 */
public interface UsuarioDao extends CrudRepository<Usuario, Long>{
    @Query("select v from Usuario v where  v.usuario = ?1")
    Usuario iniciarSesion(String usuario);
}
