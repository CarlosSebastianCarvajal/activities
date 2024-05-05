package com.api.service;

import com.api.models.Actividad;
import com.api.dao.ActividadDao;

import com.api.serviceinterface.IActividadPersonalService;
import com.api.dao.ActividadPersonalDao;
import com.api.models.ActividadPersonal;
import com.api.clasesResponseModels.ActividadPersonalCompleta;
import com.api.dao.CiudadDao;
import com.api.models.Ciudad;
import com.api.clasesCompuestas.ActividadPersonalActividad;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.Comun;
/**
 *
 * @author Sebastian Carvajal
 */
@Service
public class ActividadPersonalServiceImpl implements IActividadPersonalService {

    @Autowired
    private ActividadPersonalDao actividadPersonalDao;

    @Autowired
    private ActividadDao actividadDao;

    @Autowired
    private CiudadDao ciudadDao;

    final private  Comun comun = new Comun();
    
    @Override
    public List<ActividadPersonal> ListarTodo() {
        return (List<ActividadPersonal>) actividadPersonalDao.findAll();
    }

    @Override
    public ActividadPersonal BuscarPorId(Long id) {
        return actividadPersonalDao.findById(id).orElse(null);
    }

    @Override
    public ActividadPersonal Guardar(ActividadPersonal actividadPersonal) {
        return actividadPersonalDao.save(actividadPersonal);
    }

    @Override
    public ActividadPersonal Actualizar(ActividadPersonal actividadPersonal) {
        ActividadPersonal ap = BuscarPorId(actividadPersonal.getIdactividadpersonal());

        actividadPersonal.setIdusuario(ap.getIdusuario());
        actividadPersonal.setIdactividad(ap.getIdactividad());
        actividadPersonal.setFechacumplida(LocalDate.now());
        return actividadPersonalDao.save(actividadPersonal);
    }

    @Override
    public void EliminarPorId(Long id) {
        actividadPersonalDao.deleteById(id);
    }

    @Override
    public JsonObject GuardarActividadPersonalActividad(ActividadPersonalActividad apa) {
        JsonObject json = new JsonObject();

        ActividadPersonalActividad res = new ActividadPersonalActividad();
        apa.getActividad().setFechacreacion(LocalDate.now());
        Actividad actRes = actividadDao.save(apa.getActividad());
        if (actRes != null) {
            ActividadPersonal actPEnvia = new ActividadPersonal();
            actPEnvia.setIdusuario(apa.getIdusuario());
            actPEnvia.setIdactividad(actRes.getIdactividad());
            ActividadPersonal actPRes = actividadPersonalDao.save(actPEnvia);
            if (actPRes != null) {
                res.setActividad(actRes);

                json.put("access", 1);
                json.put("message", "Actividad guardada con éxito");
                json.put("info", res);
            } else {
                actividadDao.deleteById(actRes.getIdactividad());
                json.put("access", 0);
                json.put("message", "Error al guardar el cuerpo de la actividad");
                json.put("info", "void");
            }
        } else {
            json.put("access", 0);
            json.put("message", "Error al guardar el encabezado de la actividad");
            json.put("info", "void");
        }
        return json;
    }

    @Override
    public JsonObject ListarActividadPersonalActividad(Long idusuario) {
        JsonObject json = new JsonObject();

        List<ActividadPersonal> actividadP = actividadPersonalDao.ActividadPorIdusuario(idusuario);

        if (actividadP != null) {
            List<ActividadPersonalCompleta> actividadDatos = new ArrayList<>();
            for (ActividadPersonal act : actividadP) {
                Actividad actividad = actividadDao.findById(act.getIdactividad()).orElse(null);
                Ciudad ciudad = ciudadDao.findById(actividad.getIdciudad()).orElse(null);

                String estado;
                if (act.getFechacumplida() == null) {
                    estado = "Pendiente";
                } else {
                    estado = "Cumplida";
                }

                actividadDatos.add(
                        new ActividadPersonalCompleta(
                                act.getIdactividadpersonal(),
                                ciudad.getNombre(),
                                actividad.getNombre(),
                                actividad.getDescripcion(),
                                actividad.getPathdocguia(),
                                estado,
                                comun.FechaString(actividad.getFechaculminacion()),
                                act.getObservacion(),
                                act.getPathdocevidencia(),
                                act.getFechacumplida()
                        )
                );
            }
            json.put("access", 1);
            json.put("message", (actividadDatos.isEmpty())? "No posee actividades agregadas" : "Datos Obtenidos");
            json.put("info", actividadDatos);
        } else {
            json.put("access", 0);
            json.put("message", "No se encontraron datos");
            json.put("info", "void");
        }

        return json;
    }

    @Override
    public JsonObject VerActividadPersonalActividad(Long idActividadPersonal) {
        JsonObject json = new JsonObject();
        ActividadPersonal ap = actividadPersonalDao.findById(idActividadPersonal).orElse(null);
        if (ap != null) {
            Actividad a = actividadDao.findById(ap.getIdactividad()).orElse(null);
            if (a != null) {
                Ciudad ciudad = ciudadDao.findById(a.getIdciudad()).orElse(null);
                String estado;
                if (ap.getFechacumplida() == null) {
                    estado = "Pendiente";
                } else {
                    estado = "Cumplida";
                }

                ActividadPersonalCompleta apc = new ActividadPersonalCompleta(
                        ap.getIdactividadpersonal(),
                        ciudad.getNombre(),
                        a.getNombre(),
                        a.getDescripcion(),
                        a.getPathdocguia(),
                        estado,
                        comun.FechaString(a.getFechaculminacion()),
                        ap.getObservacion(),
                        ap.getPathdocevidencia(),
                        ap.getFechacumplida()
                );
                json.put("access", 1);
                json.put("message", "Datos obtenidos con éxito");
                json.put("info", apc);
            } else {
                json.put("access", 0);
                json.put("message", "Error al obtener la cabezera de la actividad");
                json.put("info", "void");
            }
        } else {
            json.put("access", 0);
            json.put("message", "Error al obtener la actividad");
            json.put("info", "void");
        }
        return json;
    }

    @Override
    public JsonObject CumplirActividadPersonal(ActividadPersonal actividadPersonal) {
        JsonObject json = new JsonObject();
        ActividadPersonal ap = actividadPersonalDao.findById(actividadPersonal.getIdactividadpersonal()).orElse(null);
        if (ap != null) {
            ap.setFechacumplida(LocalDate.now());
            ap.setObservacion(actividadPersonal.getObservacion());
            ap.setPathdocevidencia(actividadPersonal.getPathdocevidencia());
            ActividadPersonal res = actividadPersonalDao.save(ap);
            if (res != null) {
                json.put("access", 1);
                json.put("message", "Se registró el cumplimiento con éxito");
                json.put("info", res);
            } else {
                json.put("access", 0);
                json.put("message", "Error al registrar el cumplimiento");
                json.put("info", "void");
            }
        } else {
            json.put("access", 0); 
            json.put("message", "Error al procesar la información");
            json.put("info", "void");
        }

        return json;
    }
    

}
