
package com.api.dao;

import com.api.models.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian Carvajal
 */
public interface UsuarioDao extends CrudRepository<Usuario, Object>{
    
}
