package capanegocio;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import taller.servlet.TallerServlet;

public class Contacto {
	public Contacto() {
	}
	
	private static final int ROW_COUNT = 100;
	
	private int uid;
	
	private String nombre;
	
	private String apellido;
	
	private String mail;
	
	private String telefono;
	
	private String pais;
	
	private String region;
	
	private String ciudad;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	/**
	 * Método que permite ingresar un contacto a la BD
	 * @param contacto
	 * @return
	 * @throws PersistentException
	 */
	public static String ingresar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.createContacto();
			TallerServlet servlet = new TallerServlet();
			// Initialize the properties of the persistent object here
			lormContacto.setNombre(contacto.nombre);
			lormContacto.setApellido(contacto.apellido);
			lormContacto.setMail(contacto.mail);
			lormContacto.setTelefono(contacto.telefono);
			lormContacto.setPais(contacto.pais);
			lormContacto.setRegion(contacto.region);
			lormContacto.setCiudad(contacto.ciudad);
			msg = "Ingreso Exitoso";
			orm.ContactoDAO.save(lormContacto);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		return msg;
		
	}
	
	/**
	 * Método que permite actualizar un contacto en la BD
	 * @param contacto
	 * @return
	 * @throws PersistentException
	 */
	public static String actualizar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.uid);  //orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='victor'", null);
			// Update the properties of the persistent object
			System.out.println("Id = " + contacto.uid);
			lormContacto.setNombre(contacto.nombre);
			lormContacto.setApellido(contacto.apellido);
			lormContacto.setMail(contacto.mail);
			lormContacto.setTelefono(contacto.telefono);
			lormContacto.setPais(contacto.pais);
			lormContacto.setRegion(contacto.region);
			lormContacto.setCiudad(contacto.ciudad);
			msg = "Ingreso Exitoso";
			orm.ContactoDAO.save(lormContacto);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		return msg;
		
	}
	
	/**
	 * Método que permite eliminar un contacto de la BD
	 * @param contacto
	 * @return
	 * @throws PersistentException
	 */
	public static String borrar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.uid);
			// Delete the persistent object<
			msg="Dato eliminado...";
			orm.ContactoDAO.delete(lormContacto);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		return msg;
	}
	
	/**
	 * Método que permite listar los contactos almacenados en la BD
	 * @return
	 * @throws PersistentException
	 */
	public static List <Contacto> listar() throws PersistentException {
		
		List <orm.Contacto> listaContactoOrm = orm.ContactoDAO.queryContacto(null, null);
		List <Contacto> listaContacto = new ArrayList<>();
		
		for (orm.Contacto contactoOrm:listaContactoOrm) {
			Contacto contacto= new Contacto();
			contacto.setNombre(contactoOrm.getNombre());
			contacto.setApellido(contactoOrm.getApellido());
			contacto.setMail(contactoOrm.getMail());
			contacto.setTelefono(contactoOrm.getTelefono());
			contacto.setPais(contactoOrm.getPais());
			contacto.setRegion(contactoOrm.getRegion());
			contacto.setCiudad(contactoOrm.getCiudad());
			listaContacto.add(contacto);
		}
		
		return listaContacto;
	}
}
