
package com.api.dao;

import com.api.models.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian Carvajal
 */
public interface PersonaDao extends CrudRepository<Persona, Object>{
    
}
