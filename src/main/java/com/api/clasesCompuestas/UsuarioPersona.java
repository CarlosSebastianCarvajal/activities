
package com.api.clasesCompuestas;
import com.api.models.Usuario;
import com.api.models.Persona;
/**
 *
 * @author Sebastian Carvajal
 */
public class UsuarioPersona {
    private Usuario usuario;
    private Persona persona;

    public UsuarioPersona() {
    }

    public UsuarioPersona(Usuario usuario, Persona persona) {
        this.usuario = usuario;
        this.persona = persona;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
