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

public class Empresa {
	public Empresa() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_EMPRESA_CONTACTO) {
			return ORM_contacto;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int idEmpresa;
	
	private String rut;
	
	private String razonSocial;
	
	private String nombreEmpresa;
	
	private String representante;
	
	private String mailEmpresa;
	
	private String telefonoEmpresa;
	
	private String paisEmpresa;
	
	private String regionEmpresa;
	
	private String ciudadEmpresa;
	
	private String domicilio;
	
	private java.util.Set ORM_contacto = new java.util.HashSet();
	
	private void setIdEmpresa(int value) {
		this.idEmpresa = value;
	}
	
	public int getIdEmpresa() {
		return idEmpresa;
	}
	
	public int getORMID() {
		return getIdEmpresa();
	}
	
	public void setNombreEmpresa(String value) {
		this.nombreEmpresa = value;
	}
	
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	
	public void setPaisEmpresa(String value) {
		this.paisEmpresa = value;
	}
	
	public String getPaisEmpresa() {
		return paisEmpresa;
	}
	
	public void setCiudadEmpresa(String value) {
		this.ciudadEmpresa = value;
	}
	
	public String getCiudadEmpresa() {
		return ciudadEmpresa;
	}
	
	public void setDomicilio(String value) {
		this.domicilio = value;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public void setRut(String value) {
		this.rut = value;
	}
	
	public String getRut() {
		return rut;
	}
	
	public void setRazonSocial(String value) {
		this.razonSocial = value;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRepresentante(String value) {
		this.representante = value;
	}
	
	public String getRepresentante() {
		return representante;
	}
	
	public void setMailEmpresa(String value) {
		this.mailEmpresa = value;
	}
	
	public String getMailEmpresa() {
		return mailEmpresa;
	}
	
	public void setTelefonoEmpresa(String value) {
		this.telefonoEmpresa = value;
	}
	
	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}
	
	public void setRegionEmpresa(String value) {
		this.regionEmpresa = value;
	}
	
	public String getRegionEmpresa() {
		return regionEmpresa;
	}
	
	private void setORM_Contacto(java.util.Set value) {
		this.ORM_contacto = value;
	}
	
	private java.util.Set getORM_Contacto() {
		return ORM_contacto;
	}
	
	public final orm.ContactoSetCollection contacto = new orm.ContactoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_EMPRESA_CONTACTO, orm.ORMConstants.KEY_CONTACTO_IDEMPRESA, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdEmpresa());
	}
	
}
