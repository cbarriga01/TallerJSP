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

public class Bitacora {
	public Bitacora() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_BITACORA_IDCONTACTO) {
			this.idContacto = (orm.Contacto) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idBitacora;
	
	private String titulo;
	
	private String texto;
	
	private orm.Contacto idContacto;
	
	private void setIdBitacora(int value) {
		this.idBitacora = value;
	}
	
	public int getIdBitacora() {
		return idBitacora;
	}
	
	public int getORMID() {
		return getIdBitacora();
	}
	
	public void setTitulo(String value) {
		this.titulo = value;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTexto(String value) {
		this.texto = value;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setIdContacto(orm.Contacto value) {
		if (idContacto != null) {
			idContacto.bitacora.remove(this);
		}
		if (value != null) {
			value.bitacora.add(this);
		}
	}
	
	public orm.Contacto getIdContacto() {
		return idContacto;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdContacto(orm.Contacto value) {
		this.idContacto = value;
	}
	
	private orm.Contacto getORM_IdContacto() {
		return idContacto;
	}
	
	public String toString() {
		return String.valueOf(getIdBitacora());
	}
	
}
