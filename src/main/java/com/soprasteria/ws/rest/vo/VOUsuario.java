package com.soprasteria.ws.rest.vo;

public class VOUsuario{
	
	private String usuario;   // las declaramos privadas para que veamos que llegamos a la clase VOUsuario pero no a sus propiedades a no ser que les hagamos un POJOMAPPING
	private String password;
	private boolean usuarioCorrecto;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isUsuarioCorrecto() {
		return usuarioCorrecto;
	}
	public void setUsuarioCorrecto(boolean usuarioCorrecto) {
		this.usuarioCorrecto = usuarioCorrecto;
	}
	
}