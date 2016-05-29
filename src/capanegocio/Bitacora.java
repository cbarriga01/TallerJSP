package capanegocio;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 * 
 * @author kal-el
 *
 * Clase relacionada a la lógica de negocio de la aplicación referente a Bitacoras
 * Se encarga de enviar transacciones a la Base de Datos
 */
public class Bitacora {
	
	public Bitacora() {
	}

	private int idBitacora;
	
	private String titulo;
	
	private String texto;
	
	private Contacto contacto;

	/**
	 * 
	 * @return id de la bitacora
	 */
	public int getIdBitacora() {
		return idBitacora;
	}

	/**
	 * 
	 * @param int idBitacora de la bitacora
	 */
	public void setIdBitacora(int idBitacora) {
		this.idBitacora = idBitacora;
	}

	/**
	 * 
	 * @return título de la bitacora
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * 
	 * @param String titulo de la bitacora
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * 
	 * @return texto de la bitacora
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * 
	 * @param String texto de la bitacora
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * 
	 * @return Contacto asociado a la bitacora
	 */
	public Contacto getContacto() {
		return contacto;
	}

	/**
	 * 
	 * @param Contacto contacto de la bitacora
	 */
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	/**
	 * Método que permite ingresar un contacto a la Base de Datos
	 * @param Bitacora bitacora, objeto que contiene los datos a ingresar
	 * @return String msg, mensaje que informa el estado de la transacción
	 * @throws PersistentException
	 */
	public static String ingresarBitacora(Bitacora bitacora) throws PersistentException{
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		
		try {
			orm.Bitacora lormBitacora = orm.BitacoraDAO.createBitacora();
			orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(bitacora.getContacto().getIdContacto());
			try{
				lormBitacora.setTitulo(bitacora.getTitulo());
			}catch (NullPointerException e) {
				e.printStackTrace();
			}
			try{
				lormBitacora.setTexto(bitacora.getTexto());
			}catch (NullPointerException e) {
				e.printStackTrace();
			}
			try{
				lormBitacora.setIdContacto(lormContacto);
			}catch (NullPointerException e) {
				e.printStackTrace();
			}
			
			msg = "Ingreso Exitoso";
			orm.BitacoraDAO.save(lormBitacora);
			t.commit();
			
		}catch (Exception e) {
			t.rollback();
		}
		
		return msg;
	}
	
	/**
	 * Método que permite listar las bitácoras almacenadas en la Base de Datos
	 * @return List <Bitacora> listaBitacora, lista con bitácoras almacenadas en la Base de Datos
	 * @throws PersistentException
	 */
	public static List <Bitacora> listar() throws PersistentException {
		List <orm.Bitacora> listaBitacoraOrm = orm.BitacoraDAO.queryBitacora(null, null);
		List <Bitacora> listaBitacora = new ArrayList<>();
		
		for (orm.Bitacora bitacoraOrm:listaBitacoraOrm) {
			Bitacora bitacora = new Bitacora();
			Contacto contactoNegocio= new Contacto();
			
			orm.Contacto contactoOrm = orm.ContactoDAO.loadContactoByORMID(bitacoraOrm.getIdBitacora());
			bitacora.setIdBitacora(bitacoraOrm.getIdBitacora());
			bitacora.setTitulo(bitacoraOrm.getTitulo());
			bitacora.setTexto(bitacoraOrm.getTexto());
			
			contactoNegocio.setIdContacto(contactoOrm.getIdContacto());
			contactoNegocio.setRun(contactoOrm.getRun());
			contactoNegocio.setNombre(contactoOrm.getNombreContacto());
			contactoNegocio.setApellido(contactoOrm.getApellidoContacto());
			contactoNegocio.setMail(contactoOrm.getMailContacto());
			contactoNegocio.setTelefono(contactoOrm.getTelefonoContacto());
			contactoNegocio.setPais(contactoOrm.getPaisContacto());
			contactoNegocio.setRegion(contactoOrm.getRegionContacto());
			contactoNegocio.setCiudad(contactoOrm.getCiudadContacto());
			contactoNegocio.setDireccion(contactoOrm.getDireccion());
			contactoNegocio.setImagen(contactoOrm.getImagen());
			
			bitacora.setContacto(contactoNegocio);
			listaBitacora.add(bitacora);			
		}
		return listaBitacora;
	}
	
}
