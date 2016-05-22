package capanegocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import taller.servlet.TallerServlet;

/**
 * 
 * @author C�sar Barriga I.
 * 
 * Clase relacionada a la l�gica de negocio de la aplicaci�n referente a Empresas
 * Se encarga de enviar transacciones a la Base de Datos
 * 
 */
public class Empresa {
	//agregar arraylist de contactos
	public Empresa() {
	}
	
private static final int ROW_COUNT = 100;
	
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
	

	/**
	 * 
	 * @return int idEmpresa de la empresa
	 */
	public int getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * 
	 * @param int idEmpresa de la empresa
	 */
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * 
	 * @return String rut de la empresa
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * 
	 * @param String rut de la empresa
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}

	/**
	 * 
	 * @return String razonSocial de la empresa
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * 
	 * @param String razonSocial de la empresa
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * 
	 * @return String nombreEmpresa de la empresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * 
	 * @param String nombreEmpresa de la empresa
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	/**
	 * 
	 * @return String representante de la empresa
	 */
	public String getRepresentante() {
		return representante;
	}

	/**
	 * 
	 * @param String representante de la empresa
	 */
	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	/**
	 * 
	 * @return String mailEmpresa
	 */
	public String getMailEmpresa() {
		return mailEmpresa;
	}

	/**
	 * 
	 * @param String mailEmpresa de la empresa
	 */
	public void setMailEmpresa(String mailEmpresa) {
		this.mailEmpresa = mailEmpresa;
	}

	/**
	 * 
	 * @return String telefonoEmpresa de la empresa
	 */
	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}

	/**
	 * 
	 * @param String telefonoEmpresa de la empresa
	 */
	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}

	/**
	 * 
	 * @return String paisEmpresa de la empresa
	 */
	public String getPaisEmpresa() {
		return paisEmpresa;
	}

	/**
	 * 
	 * @param StringpaisEmpresa de la empresa
	 */
	public void setPaisEmpresa(String paisEmpresa) {
		this.paisEmpresa = paisEmpresa;
	}

	/**
	 * 
	 * @return String regionEmpresa de la empresa
	 */
	public String getRegionEmpresa() {
		return regionEmpresa;
	}

	/**
	 * 
	 * @param String regionEmpresa de la empresa
	 */
	public void setRegionEmpresa(String regionEmpresa) {
		this.regionEmpresa = regionEmpresa;
	}

	/**
	 * 
	 * @return String ciudadEmpresa de la empresa
	 */
	public String getCiudadEmpresa() {
		return ciudadEmpresa;
	}

	/**
	 * 
	 * @param String ciudadEmpresa de la empresa
	 */
	public void setCiudadEmpresa(String ciudadEmpresa) {
		this.ciudadEmpresa = ciudadEmpresa;
	}

	/**
	 * 
	 * @return String domicilio de la empresa
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * 
	 * @param String domicilio de la emrpesa
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * M�todo que permite ingresar una empresa a la Base de Datos
	 * @param Empresa empresa, objeto que contiene los datos a ingresar
	 * @return String msg, mensaje que informa el estado de la transacci�n
	 * @throws PersistentException
	 */
	public static String ingresar(Empresa empresa) throws PersistentException{
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "Ingreso fallido de empresa";
		//try{
			try {
				orm.Empresa lormEmpresa = orm.EmpresaDAO.createEmpresa();
				// Initialize the properties of the persistent object here
				try{
					lormEmpresa.setRut(empresa.getRut());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setRazonSocial(empresa.getRazonSocial());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setNombreEmpresa(empresa.getNombreEmpresa());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setRepresentante(empresa.getRepresentante());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setMailEmpresa(empresa.getMailEmpresa());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setTelefonoEmpresa(empresa.getTelefonoEmpresa());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setPaisEmpresa(empresa.getPaisEmpresa());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setRegionEmpresa(empresa.getRegionEmpresa());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setCiudadEmpresa(empresa.getCiudadEmpresa());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setDomicilio(empresa.getDomicilio());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				
				orm.EmpresaDAO.save(lormEmpresa);
				t.commit();
				msg = "Ingreso exitoso de empresa";
			}
			catch (Exception e) {
				t.rollback();
			}
		//} catch (NullPointerException e){
		//	e.printStackTrace();
		//}
		return msg;
	}
	
	/**
	 * M�todo que permite actualizar una empresa en la BD
	 * @param Empresa empresa, objeto que contiene los datos a actualizar
	 * @return String msg, mensaje que informa el estado de la transacci�n
	 * @throws PersistentException
	 */
	public static String actualizar(Empresa empresa) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "Error de conexion";
		//try{
			try {
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(empresa.getIdEmpresa());  //orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='victor'", null);
				// Update the properties of the persistent object
				try{
					lormEmpresa.setRut(empresa.getRut());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setRazonSocial(empresa.getRazonSocial());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setNombreEmpresa(empresa.getNombreEmpresa());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setRepresentante(empresa.getRepresentante());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setMailEmpresa(empresa.getMailEmpresa());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setTelefonoEmpresa(empresa.getTelefonoEmpresa());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setPaisEmpresa(empresa.getPaisEmpresa());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setRegionEmpresa(empresa.getRegionEmpresa());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setCiudadEmpresa(empresa.getCiudadEmpresa());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormEmpresa.setDomicilio(empresa.getDomicilio());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				msg = "Ingreso Exitoso";
				orm.EmpresaDAO.save(lormEmpresa);
				t.commit();
			}
			catch (Exception e) {
				t.rollback();
			}
		//} catch (NullPointerException e){
		//	e.printStackTrace();
		//}
		return msg;
		
	}
	
	/**
	 * M�todo que permite eliminar un contacto de la Base de Datos
	 * @param Empresa empresa, objeto que contiene los datos a eliminar
	 * @return String msg, mensaje que informa el estado de la transacci�n
	 * @throws PersistentException
	 */
	public static String borrar(Empresa empresa) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		try{
			try {
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(empresa.getIdEmpresa());
				// Delete the persistent object<
				msg="Dato eliminado...";
				orm.EmpresaDAO.delete(lormEmpresa);
				t.commit();
			}
			catch (Exception e) {
				t.rollback();
			}
		} catch (NullPointerException e){
			e.printStackTrace();
		}
		return msg;
	}
	
	/**
	 * M�todo que permite listar las empresas almacenadas en la Base de Datos
	 * @return List <Empresa> listaEmpresa, lista con los datos de empresa almacenados
	 * @throws PersistentException
	 */
	public static List <Empresa> listar() throws PersistentException {
		
		List <orm.Empresa> listaEmpresaOrm = orm.EmpresaDAO.queryEmpresa(null, null);
		List <Empresa> listaEmpresa= new ArrayList<>();
		
		for (orm.Empresa empresaOrm:listaEmpresaOrm) {
			Empresa empresa= new Empresa();
			empresa.setRut(empresaOrm.getRut());
			empresa.setRazonSocial(empresaOrm.getRazonSocial());
			empresa.setNombreEmpresa(empresaOrm.getNombreEmpresa());
			empresa.setRepresentante(empresaOrm.getRepresentante());
			empresa.setMailEmpresa(empresaOrm.getMailEmpresa());
			empresa.setTelefonoEmpresa(empresaOrm.getTelefonoEmpresa());
			empresa.setPaisEmpresa(empresaOrm.getPaisEmpresa());
			empresa.setRegionEmpresa(empresaOrm.getRegionEmpresa());
			empresa.setCiudadEmpresa(empresaOrm.getCiudadEmpresa());
			empresa.setDomicilio(empresaOrm.getDomicilio());
			listaEmpresa.add(empresa);
		}
		
		return listaEmpresa;
	}
	/**
	 * Metodo que permite listar las empresas almacenadas en la Base de Datos
	 * para su posterior muestra en select de ingreso y edición
	 * @return List <Empresa> listaEmpresa, lista con los datos de empresa almacenados
	 * @throws PersistentException
	 */
	
	public static List <Empresa> listarEmpresa() throws PersistentException {
		
		List <orm.Empresa> listaEmpresaOrm = orm.EmpresaDAO.queryEmpresa(null, null);
		List <Empresa> listaEmpresa= new ArrayList<>();
		
		for (orm.Empresa empresaOrm:listaEmpresaOrm) {
			Empresa empresa= new Empresa();
			empresa.setIdEmpresa(empresaOrm.getIdEmpresa());
			empresa.setNombreEmpresa(empresaOrm.getNombreEmpresa());
			listaEmpresa.add(empresa);
		}
		
		return listaEmpresa;
	}
	
}
