package com.api.service;

import com.api.clasesRequestModels.EquipoCorreoIntegrantesReqModel;
import com.api.clasesRequestModels.EquipoIntegrantesReqModel;
import com.api.clasesResponseModels.EquipoCumplimiento;
import com.api.clasesResponseModels.MisEquiposNumIntegrantes;
import com.api.serviceinterface.IEquipoService;
import com.api.dao.EquipoDao;
import com.api.dao.UsuarioDao;
import com.api.dao.IntegranteDao;
import com.api.dao.UsuarioDao;
import com.api.models.Equipo;
import com.api.models.Integrante;
import com.api.models.Usuario;
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
public class EquipoServiceImpl implements IEquipoService {

    public EquipoServiceImpl() {
    }

    @Autowired
    private EquipoDao equipoDao;
    @Autowired
    private IntegranteDao integranteDao;

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    public List<Equipo> ListarTodo() {
        return (List<Equipo>) equipoDao.findAll();
    }

    @Override
    public Equipo BuscarPorId(Long id) {
        return equipoDao.findById(id).orElse(null);
    }

    @Override
    public JsonObject Guardar(Equipo equipo) {
        JsonObject json = new JsonObject();
        Equipo e = equipoDao.save(equipo);
        if (e != null) {
            json.put("access", 1);
            json.put("message", "Equipo guardado con éxito");
            json.put("info", e);
        } else {
            json.put("access", 0);
            json.put("message", "Error al guardar el equipo");
            json.put("info", "void");
        }
        return json;
    }

    @Override
    public JsonObject Actualizar(Equipo equipo) {
        JsonObject json = new JsonObject();
        Equipo e = equipoDao.save(equipo);
        if (e != null) {
            json.put("access", 1);
            json.put("message", "Equipo guardado con éxito");
            json.put("info", e);
        } else {
            json.put("access", 0);
            json.put("message", "Error al editar el equipo");
            json.put("info", "void");
        }
        return json;
    }

    @Override
    public void EliminarPorId(Long id) {
        equipoDao.deleteById(id);
    }

    @Override
    public JsonObject GuardarEquipoIntegrantes(EquipoIntegrantesReqModel eirq) {
        JsonObject json = new JsonObject();
        try {
            List<Integrante> integrantesNoRegistrados = new ArrayList<Integrante>();
            Equipo eq = equipoDao.save(eirq.getEquipo());
            if (eq != null) {
                for (Integrante integrante : eirq.getIntegrantes()) {
                    integrante.setIdequipo(eq.getIdequipo());
                    integrante.setAceptacion(false);
                    integrante.setActivo(true);
                    integranteDao.save(integrante);
                    if (integrante.getIdusuario() == null) {
                        integrantesNoRegistrados.add(integrante);
                    }
                }
                //EnviarCorreoInvitacionRegistro(integrantesNoRegistrados);
                EnviarCorreoInvitacionEquipo(eirq.getIntegrantes());
                json.put("access", 1);
                json.put("message", "Equipo guardado con éxito");
                json.put("info", eq);
            } else {
                json.put("access", 0);
                json.put("message", "Error al guardar el equipo");
                json.put("info", "void");
            }
        } catch (Exception ex) {
            json.put("access", 0);
            json.put("message", "Ocurrió una exepción al guardar: " + ex.getMessage());
            json.put("info", "void");
        }
        return json;
    }
    
    @Override
    public JsonObject GuardarEquipoIntegrantesListaCorreo(EquipoCorreoIntegrantesReqModel ecirq){
        JsonObject json = new JsonObject();
        try {
            List<String> correosNoRegistrados = new ArrayList<String>();
            List<Integrante> integrantesIngresados = new ArrayList<Integrante>();
            Equipo eq = equipoDao.save(ecirq.getEquipo());
            if(eq != null){
                for(String correoIntegrante : ecirq.getCorreosintegrantes()){
                    Usuario u = usuarioDao.UsuarioPorCorreo(correoIntegrante);
                    if(u != null){
                        Integrante integrante = new Integrante(
                                eq.getIdequipo(), 
                                u.getIdusuario(),
                                correoIntegrante,
                                true,
                                true
                        );
                        integranteDao.save(integrante);
                        integrantesIngresados.add(integrante);
                    }else{
                        correosNoRegistrados.add(correoIntegrante);
                    }
                }
                json.put("access", 1);
                json.put("message", "Equipo guardado con éxito");
                json.put("info", new EquipoCorreoIntegrantesReqModel(eq, correosNoRegistrados));

                EnviarCorreoInvitacionRegistro(correosNoRegistrados);
                EnviarCorreoInvitacionEquipo(integrantesIngresados);
                
            } else {
                json.put("access", 0);
                json.put("message", "Error al guardar el equipo");
                json.put("info", "void");
            }
        } catch (Exception ex) {
            json.put("access", 0);
            json.put("message", "Ocurrió una exepción al guardar: " + ex.getMessage());
            json.put("info", "void");
        }
        return json;
    }

    @Override
    public JsonObject ListarMisEquipos(Long idUsuario) {
        JsonObject json = new JsonObject();
        List<Equipo> listaEquipos = equipoDao.ListarMisEquipos(idUsuario);
        if (listaEquipos != null) {
            List<MisEquiposNumIntegrantes> misEquipos = new ArrayList<>();
            for (Equipo e : listaEquipos) {
                Long numeroIntegrantes = integranteDao.ContarIntegrantesPorIdEquipo(e.getIdequipo());
                misEquipos.add(new MisEquiposNumIntegrantes(e, numeroIntegrantes));
            }
            json.put("access", 1);
            json.put("message", "Equipos extraídos correctamente");
            json.put("info", misEquipos);
        } else {
            json.put("access", 0);
            json.put("message", "No se pudieron obtener los datos");
            json.put("info", "void");
        }
        return json;
    }

    // Cumplimiento
    @Override
    public JsonObject ListarEquiposIngresados(Long idUsuario) {
        JsonObject json = new JsonObject();
        List<EquipoCumplimiento> listaEquipoCumplimiento = new ArrayList<>();
        List<Equipo> listaEquipos = equipoDao.ListarEquiposIngresados(idUsuario);
        if (listaEquipos != null) {
            for (Equipo e : listaEquipos) {
                Integrante i = integranteDao.IntegrantePorUsuarioEquipo(e.getIdequipo(), idUsuario);
                listaEquipoCumplimiento.add(new EquipoCumplimiento(e, i.getIdintegrante()));
            }
            if (!listaEquipoCumplimiento.isEmpty()) {
                json.put("access", 1);
                json.put("message", "Lista obtenida correctamente");
                json.put("info", listaEquipoCumplimiento);
            } else {
                json.put("access", 0);
                json.put("message", "No se encuentra ingresado en ningún equipo");
                json.put("info", "void");
            }
        } else {
            json.put("access", 0);
            json.put("message", "No se encuentra ingresado en ningún equipo");
            json.put("info", "void");
        }
        return json;
    }

    // Metodos extras 
    public void EnviarCorreoInvitacionRegistro(List<String> listaCorroesIntegrantes) {
    }

    public void EnviarCorreoInvitacionEquipo(List<Integrante> listaIntegrantes) {
    }

}
