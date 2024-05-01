
package com.api.service;

import com.api.clasesRequestModels.IniciarSesionReqModel;
import com.api.clasesCompuestas.UsuarioPersona;
import com.api.dao.PersonaDao;
import com.api.dao.UsuarioDao;
import com.api.models.Usuario;
import com.api.models.Persona;
import com.api.serviceinterface.IUsuarioService;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    
    @Autowired
    private PersonaDao personaDao ;
    
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
    
    @Override
    public JsonObject IniciarSesion(IniciarSesionReqModel iniciarSesion) {
        JsonObject json = new JsonObject();
        
        Usuario usuarioDb = usuarioDao.iniciarSesion(iniciarSesion.getUsuario());
        if(usuarioDb != null) {
                if(usuarioDb.getClave().equals(getMD5(iniciarSesion.getClave()))) {
                    //obtenemos los datos de la persona
                    UsuarioPersona up = new UsuarioPersona();
                    up.setUsuario(usuarioDb);
                    Persona persona = personaDao.findById(usuarioDb.getIdpersona()).orElse(null);
                    up.setPersona(persona);
                        usuarioDb.setClave("No Disponible");
                        json.put("access", 1);
                        json.put("message", "Acceso Correcto");
                        json.put("info", up);
                }else {
                        json.put("access", 0);
                        json.put("message", "La contraseña ingresada es incorrecta, intente nuevamente");
                        json.put("info", "void");
                }
        }else {
                json.put("access", 0);
                json.put("message", "El nombre de usuario es incorrecto o no se encuentra registrado en el sistema!!");
                json.put("info", "void");
        }
        return json;
    }

    @Override
    public JsonObject Registrarse(UsuarioPersona usuarioPersona) {
        JsonObject json = new JsonObject();
        
        try{
            Persona persona = personaDao.save(usuarioPersona.getPersona());

            if(persona != null){
                Usuario usuarioIngreso = usuarioPersona.getUsuario();
                usuarioIngreso.setIdpersona(persona.getIdpersona());
                usuarioIngreso.setCodigorec(GenerarCodigoRec(false));
                usuarioIngreso.setCodigoverificar(GenerarCodigoVerificacion());
                usuarioIngreso.setTienebloqueo(false);
                usuarioIngreso.setClave(getMD5(usuarioPersona.getUsuario().getClave()));
                Usuario usuario = usuarioDao.save(usuarioIngreso);
                usuario.setClave("No disponible");
                
                if(usuario!= null){
                    json.put("access", 1);
                    json.put("message", "Se ha  ingresado la información, se ha enviado un correo de confirmación!");
                    json.put("info", new UsuarioPersona(usuario, persona));
                }else{
                    personaDao.deleteById(persona.getIdpersona());
                    json.put("access", 0);
                    json.put("message", "Ha ocurrido un error al intentar guardad el usuario");
                    json.put("info", "void");
                }
            }else{
                json.put("access", 0);
                json.put("message", "Ha ocurrido un error al intentar guardad la persona");
                json.put("info", "void");
            }
        }catch(Exception e){
            json.put("access", 0);
            json.put("message", "Error: " + e.getMessage());
            json.put("info", "void");
        }
        return json;
    }
    
    public String GenerarCodigoVerificacion(){
        // a=modificar... para generar un codigo aleatorio
        return "12345";
    }
    
    public String GenerarCodigoRec(boolean opcion){
        if(opcion){
            return "12345"; // aaqui debe ir en caso de recuperacion de cuenta
        }else{
            return "12345";// aqui primera vez
        }
    }
    
    public  String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    
}
