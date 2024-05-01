package com.api.service;

import com.api.serviceinterface.IIntegranteService;
import com.api.dao.IntegranteDao;
import com.api.models.Integrante;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class IntegranteServiceImpl implements IIntegranteService {

    @Autowired
    private IntegranteDao integranteDao;

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

    @Override
    public JsonObject VerIntegrantesPorIdEquipo(Long idequipo) {
        JsonObject json = new JsonObject();
        List<Integrante> integrantes = integranteDao.IntegrantesPorIdEquipo(idequipo);
        if (integrantes != null) {
            json.put("access", 1);
            json.put("message", "Integrantes cargados con éxito");
            json.put("info", integrantes);
        } else {
            json.put("access", 0);
            json.put("message", "Error al obtener los integrantes");
            json.put("info", "void");
        }
        return json;
    }

    @Override
    public JsonObject AgregarIntegrantes(List<Integrante> listaIntegrantes) {
        JsonObject json = new JsonObject();
        try {
            EquipoServiceImpl esImpl = new EquipoServiceImpl();
            List<Integrante> integrantesNoRegistrados = new ArrayList<Integrante>();
            for (Integrante integrante : listaIntegrantes) {
                integrante.setAceptacion(false);
                integrante.setActivo(true);
                integranteDao.save(integrante);
                if (integrante.getIdusuario() == null) {
                    integrantesNoRegistrados.add(integrante);
                }
            }
            esImpl.EnviarCorreoInvitacionRegistro(integrantesNoRegistrados);
            esImpl.EnviarCorreoInvitacionEquipo(listaIntegrantes);
            json.put("access", 1);
            json.put("message", "Equipo guardado con éxito");
            json.put("info", "completo");
        } catch (Exception ex) {
            json.put("access", 0);
            json.put("message", "Error: " + ex);
            json.put("info", "void");
        }
        return json;
    }

    @Override
    public JsonObject QuitarIntegrante(Long idIntegrante) {
        JsonObject json = new JsonObject();
        Integrante integrante = integranteDao.findById(idIntegrante).orElse(null);
        if (integrante != null) {
            integrante.setActivo(false);
            Integrante intgranteRes = integranteDao.save(integrante);
            json.put("access", 1);
            json.put("message", "Equipo guardado con éxito");
            json.put("info", intgranteRes);
        } else {
            json.put("access", 0);
            json.put("message", "No se pudo quitar el integrante");
            json.put("info", "void");
        }
        return json;
    }

}
