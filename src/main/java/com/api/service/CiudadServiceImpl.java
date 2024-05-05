
package com.api.service;

import com.api.serviceinterface.ICiudadService;
import com.api.dao.CiudadDao;
import com.api.models.Ciudad;
import com.github.cliftonlabs.json_simple.JsonObject;
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

    @Override
    public JsonObject ListarCiudadesPorIdPais(Long idpais) {
        JsonObject json = new JsonObject();
        List<Ciudad> listaCiudad = ciudadDao.ListarCiudadesPorIdPais(idpais);
        if (listaCiudad != null) {
            json.put("access", 1);
            json.put("message", "Ciudades extraidas correctamente");
            json.put("info", listaCiudad);
        }else{
            json.put("access", 0);
            json.put("message", "Error al obtener ciudades del pais selecionado");
            json.put("info", "void");
        }
        return json;
    }
    
}
