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
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_CONTACTO_BITACORA) {
			return ORM_bitacora;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_CONTACTO_IDEMPRESA) {
			this.idEmpresa = (orm.Empresa) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idContacto;
	
	private String run;
	
	private String nombreContacto;
	
	private String apellidoContacto;
	
	private String mailContacto;
	
	private String telefonoContacto;
	
	private String paisContacto;
	
	private String regionContacto;
	
	private String ciudadContacto;
	
	private String direccion;
	
	private String imagen;
	
	private orm.Empresa idEmpresa;
	
	private java.util.Set ORM_bitacora = new java.util.HashSet();
	
	/**
	 * Clave Primara
	 */
	private void setIdContacto(int value) {
		this.idContacto = value;
	}
	
	/**
	 * Clave Primara
	 */
	public int getIdContacto() {
		return idContacto;
	}
	
	public int getORMID() {
		return getIdContacto();
	}
	
	/**
	 * Nombre
	 */
	public void setNombreContacto(String value) {
		this.nombreContacto = value;
	}
	
	/**
	 * Nombre
	 */
	public String getNombreContacto() {
		return nombreContacto;
	}
	
	/**
	 * Apellido
	 */
	public void setApellidoContacto(String value) {
		this.apellidoContacto = value;
	}
	
	/**
	 * Apellido
	 */
	public String getApellidoContacto() {
		return apellidoContacto;
	}
	
	/**
	 * Mail
	 */
	public void setMailContacto(String value) {
		this.mailContacto = value;
	}
	
	/**
	 * Mail
	 */
	public String getMailContacto() {
		return mailContacto;
	}
	
	/**
	 * Telefono
	 */
	public void setTelefonoContacto(String value) {
		this.telefonoContacto = value;
	}
	
	/**
	 * Telefono
	 */
	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	
	public void setPaisContacto(String value) {
		this.paisContacto = value;
	}
	
	public String getPaisContacto() {
		return paisContacto;
	}
	
	public void setRegionContacto(String value) {
		this.regionContacto = value;
	}
	
	public String getRegionContacto() {
		return regionContacto;
	}
	
	public void setCiudadContacto(String value) {
		this.ciudadContacto = value;
	}
	
	public String getCiudadContacto() {
		return ciudadContacto;
	}
	
	public void setRun(String value) {
		this.run = value;
	}
	
	public String getRun() {
		return run;
	}
	
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setImagen(String value) {
		this.imagen = value;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void setIdEmpresa(orm.Empresa value) {
		if (idEmpresa != null) {
			idEmpresa.contacto.remove(this);
		}
		if (value != null) {
			value.contacto.add(this);
		}
	}
	
	public orm.Empresa getIdEmpresa() {
		return idEmpresa;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdEmpresa(orm.Empresa value) {
		this.idEmpresa = value;
	}
	
	private orm.Empresa getORM_IdEmpresa() {
		return idEmpresa;
	}
	
	private void setORM_Bitacora(java.util.Set value) {
		this.ORM_bitacora = value;
	}
	
	private java.util.Set getORM_Bitacora() {
		return ORM_bitacora;
	}
	
	public final orm.BitacoraSetCollection bitacora = new orm.BitacoraSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_CONTACTO_BITACORA, orm.ORMConstants.KEY_BITACORA_IDCONTACTO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdContacto());
	}
	
}
