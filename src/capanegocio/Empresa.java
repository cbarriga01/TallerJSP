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
	
	private int id;
	
	private String nombre;
	
	private String pais;
	
	private String ciudad;
	
	private String direccion;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
				lormEmpresa.setNombre(empresa.nombre);
				lormEmpresa.setPais(empresa.pais);
				lormEmpresa.setCiudad(empresa.ciudad);
				lormEmpresa.setDireccion(empresa.direccion);
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
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(empresa.id);  //orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='victor'", null);
				// Update the properties of the persistent object
				System.out.println("Id = " + empresa.id);
				lormEmpresa.setNombre(empresa.nombre);
				lormEmpresa.setPais(empresa.pais);
				lormEmpresa.setCiudad(empresa.ciudad);
				lormEmpresa.setDireccion(empresa.direccion);
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
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(empresa.id);
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
			empresa.setNombre(empresaOrm.getNombre());
			empresa.setPais(empresaOrm.getPais());
			empresa.setCiudad(empresaOrm.getCiudad());
			empresa.setDireccion(empresaOrm.getDireccion());
			listaEmpresa.add(empresa);
		}
		
		return listaEmpresa;
	}
	
}
