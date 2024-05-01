package com.api.service;

import com.api.clasesRequestModels.ActividadEquipoReqModel;
import com.api.clasesRequestModels.ActualizaActividadEquipoReqModel;
import com.api.clasesRequestModels.ListarActividadesCumplimientoReqModel;
import com.api.clasesResponseModels.ActividadCumplimiento;
import com.api.clasesResponseModels.ActividadEquipoDetalle;
import com.api.clasesResponseModels.ActividadesEquipo;
import com.api.clasesResponseModels.CumplimientoConDatos;
import com.api.dao.ActividadDao;
import com.api.serviceinterface.IActividadEquipoService;
import com.api.dao.ActividadEquipoDao;
import com.api.dao.CumplimientoDao;
import com.api.dao.IntegranteDao;
import com.api.models.Actividad;
import com.api.models.ActividadEquipo;
import com.api.models.Cumplimiento;
import com.api.models.Integrante;
import com.api.models.Persona;
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
public class ActividadEquipoServiceImpl implements IActividadEquipoService {

    @Autowired
    private ActividadEquipoDao actividadEquipoDao;

    @Autowired
    private ActividadDao actividadDao;

    @Autowired
    private IntegranteDao integranteDao;

    @Autowired
    private CumplimientoDao cumplimientoDao;

    @Override
    public List<ActividadEquipo> ListarTodo() {
        return (List<ActividadEquipo>) actividadEquipoDao.findAll();
    }

    @Override
    public ActividadEquipo BuscarPorId(Long id) {
        return actividadEquipoDao.findById(id).orElse(null);
    }

    @Override
    public ActividadEquipo GuardarActualizar(ActividadEquipo actividadEquipo) {
        return actividadEquipoDao.save(actividadEquipo);
    }

    @Override
    public JsonObject EliminarPorId(Long id) {
        JsonObject json = new JsonObject();
        ActividadEquipo ae = actividadEquipoDao.findById(id).orElse(null);
        if( ae != null){
            cumplimientoDao.EliminarPorIdActividadEquipo(id);
            actividadEquipoDao.deleteById(id);
            actividadDao.deleteById(ae.getIdactividad());
            json.put("access", 1);
            json.put("message", "Se quitó la actividad correctamente");
            json.put("info", "void");
        }else{
            json.put("access", 0);
            json.put("message", "Error, no se encontró el objeto a eliminar");
            json.put("info", "void");
        }
        
        
        return json;
    }

    @Override
    public JsonObject GuardarActividadEquipoActividad(ActividadEquipoReqModel actividadEquipoReqModel) {
        JsonObject json = new JsonObject();
        Actividad actividad = actividadDao.save(actividadEquipoReqModel.getActividad());
        if (actividad != null) {
            ActividadEquipo actividadEquipoIn = new ActividadEquipo(
                    actividadEquipoReqModel.getIdequipo(),
                    actividad.getIdactividad()
            );
            ActividadEquipo actividadEquipoOut = actividadEquipoDao.save(actividadEquipoIn);
            if (actividadEquipoOut != null) {
                List<Integrante> listaIntegrantes = integranteDao.IntegrantesPorIdEquipo(actividadEquipoReqModel.getIdequipo());
                for (Integrante i : listaIntegrantes) {
                    cumplimientoDao.save(new Cumplimiento(
                            i.getIdintegrante(),
                            actividadEquipoOut.getIdactividadequipo()
                    )
                    );
                }
                json.put("access", 1);
                json.put("message", "Datos guardados correctamente");
                json.put("info", actividadEquipoOut);

            } else {
                json.put("access", 0);
                json.put("message", "Error al guardar la actividad de equipo");
                json.put("info", "void");
            }
        } else {
            json.put("access", 0);
            json.put("message", "Error al guardar encabezado de actividad");
            json.put("info", "void");
        }
        return json;
    }

    @Override
    public JsonObject ActualizaActividadEquipoActividad(ActualizaActividadEquipoReqModel aaeReqModel) {
        JsonObject json = new JsonObject();
        Actividad a = actividadEquipoDao.ActividadPorIdActividadEquipo(aaeReqModel.getIdactividadequipo());
        if (a != null) {
            a.setIdciudad(aaeReqModel.getActividad().getIdciudad());
            a.setNombre(aaeReqModel.getActividad().getNombre());
            a.setDescripcion(aaeReqModel.getActividad().getDescripcion());
            a.setFechaculminacion(aaeReqModel.getActividad().getFechaculminacion());
            a.setPathdocguia(aaeReqModel.getActividad().getPathdocguia());
            Actividad aRes = actividadDao.save(a);
            if (aRes != null) {
                json.put("access", 1);
                json.put("message", "Actividad actualizada con éxito");
                json.put("info", aRes);
            } else {
                json.put("access", 0);
                json.put("message", "No se pudo actualizar la actividad");
                json.put("info", "void");
            }
        } else {
            json.put("access", 0);
            json.put("message", "No se pudo encontrar la cabecera de la actividad");
            json.put("info", "void");
        }
        return json;
    }

    @Override
    public JsonObject DetalleActividadEquipo(Long idActividadEquipo) {
        JsonObject json = new JsonObject();
        Actividad a = actividadEquipoDao.ActividadPorIdActividadEquipo(idActividadEquipo);
        ActividadEquipo ae = actividadEquipoDao.findById(idActividadEquipo).orElse(null);
        if (a != null || ae != null) {
            List<Cumplimiento> listaCumplimiento = actividadEquipoDao.CumplimientoPorIdActividadEquipo(idActividadEquipo);
            List<CumplimientoConDatos> listaCumplimientoDatos = CumplimientoDatos(listaCumplimiento);
            ActividadEquipoDetalle aed = new ActividadEquipoDetalle(ae, a, listaCumplimientoDatos);
            json.put("access", 1);
            json.put("message", "Datos extraidos correctamente");
            json.put("info", aed);
        } else {
            json.put("access", 0);
            json.put("message", "No se pudo encontrar la cabecera de la actividad");
            json.put("info", "void");
        }
        return json;
    }
    
    public List<CumplimientoConDatos> CumplimientoDatos(List<Cumplimiento> listaCumplimiento){
        List<CumplimientoConDatos> res = new ArrayList<>();
        for(Cumplimiento c : listaCumplimiento){
            String estado =  (c.getFechacumplida() == null) ? "Pendiente" : "Cumplida";
            String fechaC = (c.getFechacumplida() == null) ? "Pendiente" : c.getFechacumplida().toString();
            Persona persona = cumplimientoDao.PersonaPorCumplimiento(c.getIdcumplimiento());
            res.add(new CumplimientoConDatos(
                    c.getIdcumplimiento(), 
                    persona.getNombres() + " " + persona.getApellidos(),
                    estado,
                    c.getObservacion(),
                    c.getPathdocevidencia(),
                    fechaC
                    ));
        }
        return res;
    }

    @Override
    public JsonObject ListarActividadesEquipo(Long idEquipo) {
        JsonObject json = new JsonObject();
        List<ActividadEquipo> listaActividadEquipo = actividadEquipoDao.ListarActividadesEquipoPorIdEquipo(idEquipo);
        if (listaActividadEquipo != null) {
            List<ActividadesEquipo> actividadesEquipo = new ArrayList<ActividadesEquipo>();
            for (ActividadEquipo ae : listaActividadEquipo) {
                Actividad actividad = actividadDao.findById(ae.getIdactividad()).orElse(null);
                Long cumplido = cumplimientoDao.ContarCumplimientoActividad(ae.getIdactividadequipo());
                actividadesEquipo.add(new ActividadesEquipo(ae, actividad, cumplido));
            }
            json.put("access", 1);
            json.put("message", "Datos obtenidos correctamente");
            json.put("info", actividadesEquipo);
        } else {
            json.put("access", 0);
            json.put("message", "Error al obtener los datos");
            json.put("info", "void");
        }
        return json;
    }
    
    //Cumplimiento
    @Override
    public JsonObject ListarActividadesEquipoCumplimiento(ListarActividadesCumplimientoReqModel lacReqModel) {
        JsonObject json = new JsonObject();
        List<ActividadEquipo> listaActividadesEquipo = actividadEquipoDao.ListarActividadesEquipoPorIdEquipo(lacReqModel.getIdequipo());
        if(!listaActividadesEquipo.isEmpty()){
            List<ActividadCumplimiento> listaActividadCumplimiento = new ArrayList<>();
            for(ActividadEquipo ae : listaActividadesEquipo){
                Actividad actividad = actividadEquipoDao.ActividadPorIdActividadEquipo(ae.getIdactividadequipo());
                Cumplimiento cumplimiento = cumplimientoDao.CumplimientoActividad(ae.getIdactividadequipo(), lacReqModel.getIdintegrante());
                String estado = "Pendiente";
                if(cumplimiento != null){
                    estado = "Cumplido";
                }
                Long idCum = (cumplimiento != null) ? cumplimiento.getIdcumplimiento() : 0;
                listaActividadCumplimiento.add(new ActividadCumplimiento(actividad, estado, ae.getIdactividadequipo(), idCum));
                json.put("access", 1);
                json.put("message", "Datos obtenidos correctamente");
                json.put("info", listaActividadCumplimiento);
            }
            json.put("access", 0);
            json.put("message", "No hay actividades asignadas en este equipo");
            json.put("info", "void");
        }
        else{
            json.put("access", 0);
            json.put("message", "No hay actividades asignadas en este equipo");
            json.put("info", "void");
        }
        return json;
    }
    
}
