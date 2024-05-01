package com.api.clasesRequestModels;

public class IniciarSesionReqModel {
	private String usuario, clave;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String username) {
		this.usuario = username;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String contrasenia) {
		this.clave = contrasenia;
	}	
}
