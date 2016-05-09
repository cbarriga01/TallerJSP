/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

public class Usuario {
	public Usuario() {
	}
	
	private int idusuario;
	
	private String usuario;
	
	private String password;
	
	private void setIdusuario(int value) {
		this.idusuario = value;
	}
	
	public int getIdusuario() {
		return idusuario;
	}
	
	public int getORMID() {
		return getIdusuario();
	}
	
	public void setUsuario(String value) {
		this.usuario = value;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String toString() {
		return String.valueOf(getIdusuario());
	}
	
}
