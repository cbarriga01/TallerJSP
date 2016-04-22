package capanegocio;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import taller.servlet.TallerServlet;

public class Empresa {

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
	

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getMailEmpresa() {
		return mailEmpresa;
	}

	public void setMailEmpresa(String mailEmpresa) {
		this.mailEmpresa = mailEmpresa;
	}

	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}

	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}

	public String getPaisEmpresa() {
		return paisEmpresa;
	}

	public void setPaisEmpresa(String paisEmpresa) {
		this.paisEmpresa = paisEmpresa;
	}

	public String getRegionEmpresa() {
		return regionEmpresa;
	}

	public void setRegionEmpresa(String regionEmpresa) {
		this.regionEmpresa = regionEmpresa;
	}

	public String getCiudadEmpresa() {
		return ciudadEmpresa;
	}

	public void setCiudadEmpresa(String ciudadEmpresa) {
		this.ciudadEmpresa = ciudadEmpresa;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * Método que permite ingresar una empresa a la BD
	 * @param empresa
	 * @return msg retorna mensaje de que se ha ingresado la empresa
	 * @throws PersistentException
	 */
	public static String ingresar(Empresa empresa) throws PersistentException{
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		try{
			try {
				orm.Empresa lormEmpresa = orm.EmpresaDAO.createEmpresa();
				TallerServlet Empresa = new TallerServlet();
				// Initialize the properties of the persistent object here
				lormEmpresa.setRut(empresa.rut);
				lormEmpresa.setRazonSocial(empresa.razonSocial);
				lormEmpresa.setNombreEmpresa(empresa.nombreEmpresa);
				lormEmpresa.setRepresentante(empresa.representante);
				lormEmpresa.setMailEmpresa(empresa.mailEmpresa);
				lormEmpresa.setTelefonoEmpresa(empresa.telefonoEmpresa);
				lormEmpresa.setPaisEmpresa(empresa.paisEmpresa);
				lormEmpresa.setRegionEmpresa(empresa.regionEmpresa);
				lormEmpresa.setCiudadEmpresa(empresa.ciudadEmpresa);
				lormEmpresa.setDomicilio(empresa.domicilio);
				msg = "Ingreso Exitoso";
				orm.EmpresaDAO.save(lormEmpresa);
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
	 * Método que permite actualizar una empresa en la BD
	 * @param empresa
	 * @return msg retorna mensaje de que se ha actualizado la empresa
	 * @throws PersistentException
	 */
	public static String actualizar(Empresa empresa) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "Error de conexion";
		try{
			try {
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(empresa.idEmpresa);  //orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='victor'", null);
				// Update the properties of the persistent object
				System.out.println("Id = " + empresa.idEmpresa);
				lormEmpresa.setRut(empresa.rut);
				lormEmpresa.setRazonSocial(empresa.razonSocial);
				lormEmpresa.setNombreEmpresa(empresa.nombreEmpresa);
				lormEmpresa.setRepresentante(empresa.representante);
				lormEmpresa.setMailEmpresa(empresa.mailEmpresa);
				lormEmpresa.setTelefonoEmpresa(empresa.telefonoEmpresa);
				lormEmpresa.setPaisEmpresa(empresa.paisEmpresa);
				lormEmpresa.setRegionEmpresa(empresa.regionEmpresa);
				lormEmpresa.setCiudadEmpresa(empresa.ciudadEmpresa);
				lormEmpresa.setDomicilio(empresa.domicilio);
				msg = "Ingreso Exitoso";
				orm.EmpresaDAO.save(lormEmpresa);
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
	 * Método que permite eliminar un contacto de la BD
	 * @param empresa
	 * @return msg retorna mensaje indicando que el dato ha sido eliminado
	 * @throws PersistentException
	 */
	public static String borrar(Empresa empresa) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		try{
			try {
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(empresa.idEmpresa);
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
	 * Método que permite listar las empresas almacenadas en la BD
	 * @return listaEmpresa retorna lista con los datos de empresa almacenados
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
	
}
