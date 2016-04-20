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

public class Contacto {
	public Contacto() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_CONTACTO_EMPRESA) {
			this.empresa = (orm.Empresa) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int uid;
	
	private String nombre;
	
	private String apellido;
	
	private String mail;
	
	private String telefono;
	
	private String pais;
	
	private String region;
	
	private String ciudad;
	
	private orm.Empresa empresa;
	
	/**
	 * Clave Primara
	 */
	private void setUid(int value) {
		this.uid = value;
	}
	
	/**
	 * Clave Primara
	 */
	public int getUid() {
		return uid;
	}
	
	public int getORMID() {
		return getUid();
	}
	
	/**
	 * Nombre
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	/**
	 * Nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Apellido
	 */
	public void setApellido(String value) {
		this.apellido = value;
	}
	
	/**
	 * Apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Mail
	 */
	public void setMail(String value) {
		this.mail = value;
	}
	
	/**
	 * Mail
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * Telefono
	 */
	public void setTelefono(String value) {
		this.telefono = value;
	}
	
	/**
	 * Telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	
	public void setPais(String value) {
		this.pais = value;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setRegion(String value) {
		this.region = value;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setCiudad(String value) {
		this.ciudad = value;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setEmpresa(orm.Empresa value) {
		if (empresa != null) {
			empresa.contacto.remove(this);
		}
		if (value != null) {
			value.contacto.add(this);
		}
	}
	
	public orm.Empresa getEmpresa() {
		return empresa;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Empresa(orm.Empresa value) {
		this.empresa = value;
	}
	
	private orm.Empresa getORM_Empresa() {
		return empresa;
	}
	
	public String toString() {
		return String.valueOf(getUid());
	}
	
}
