
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
    
    @Query("select u from Usuario u "
            + "inner join Persona p on u.idpersona = p.idpersona "
            + "where p.correo = ?1")
    Usuario UsuarioPorCorreo(String correo);
}
