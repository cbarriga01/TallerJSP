package capanegocio;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import taller.servlet.TallerServlet;

/*
 * Clase de negocio de contacto
 * @author: César Barriga
 */
public class Contacto {
	public Contacto() {
	}
	
	private static final int ROW_COUNT = 100;
	
	private int idContacto;
	
	private String run;
	
	private String nombre;
	
	private String apellido;
	
	private String mail;
	
	private String telefono;
	
	private String pais;
	
	private String region;
	
	private String ciudad;
	
	private String direccion;
	
	private Empresa empresa; //cambiar nombre

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	 * @param contacto Contacto
	 * @return mensaje de si el ingreso fue exitoso o no
	 * @throws PersistentException
	 */
	public static String ingresar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		//try{
			try {
				Empresa empresaNegocio = new Empresa();
				orm.Contacto lormContacto = orm.ContactoDAO.createContacto();
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(contacto.getEmpresa().getIdEmpresa());
				//Validar datos que no sean nulos...
				
				// Initialize the properties of the persistent object here
				try{
					lormContacto.setIdEmpresa(lormEmpresa);
				}catch (NullPointerException e) {
					e.printStackTrace();
				}
				try{
					lormContacto.setRun(contacto.getRun());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
					lormContacto.setNombreContacto(contacto.getNombre());
				try{
					lormContacto.setApellidoContacto(contacto.getApellido());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setMailContacto(contacto.getMail());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setTelefonoContacto(contacto.getTelefono());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setPaisContacto(contacto.getPais());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setRegionContacto(contacto.getRegion());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setCiudadContacto(contacto.getCiudad());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setDireccion(contacto.getDireccion());
				}catch (NullPointerException e){
					e.printStackTrace();
				}	
				
				try{
					lormContacto.setIdEmpresa(lormEmpresa);
				}catch (NullPointerException e){
					e.printStackTrace();
				}	
				
				msg = "Ingreso Exitoso";
				orm.ContactoDAO.save(lormContacto);
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
	 * Método que permite actualizar un contacto en la BD
	 * @param contacto de tipo Contacto,
	 * @return mensaje de si la actualización fue exitosa o no
	 * @throws PersistentException
	 */
	public static String actualizar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "Ingreso fallido de contacto";
		//try{
			try {
				Empresa empresaNegocio = new Empresa();
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(contacto.getEmpresa().getIdEmpresa());
				orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.getIdContacto());  //orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='victor'", null);
				// Update the properties of the persistent object
				try{
					lormContacto.setRun(contacto.getRun());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setNombreContacto(contacto.getNombre());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setApellidoContacto(contacto.getApellido());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setMailContacto(contacto.getMail());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setTelefonoContacto(contacto.getTelefono());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setPaisContacto(contacto.getPais());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setRegionContacto(contacto.getRegion());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setCiudadContacto(contacto.getCiudad());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormContacto.setDireccion(contacto.getDireccion());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				
				try{
					lormContacto.setIdEmpresa(lormEmpresa);
				}catch (NullPointerException e){
					e.printStackTrace();
				}	
				
				orm.ContactoDAO.save(lormContacto);
				t.commit();
				msg = "Ingreso exitoso de contacto";
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
	 * Método que permite eliminar un contacto de la BD
	 * @param contacto de tipo Contacto
	 * @return mensaje de si la eliminación fué exitosa o no
	 * @throws PersistentException
	 */
	public static String borrar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		try{
			try {
				orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.getIdContacto());
				// Delete the persistent object<
				msg="Dato eliminado...";
				orm.ContactoDAO.delete(lormContacto);
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
	 * Método que permite listar los contactos almacenados en la BD
	 * @return lista con contactos almacenados en BD
	 * @throws PersistentException
	 */
	public static List <Contacto> listar() throws PersistentException {
		
		List <orm.Contacto> listaContactoOrm = orm.ContactoDAO.queryContacto(null, null);
		List <Contacto> listaContacto = new ArrayList<>();
		
		for (orm.Contacto contactoOrm:listaContactoOrm) {
			Contacto contacto= new Contacto();
			contacto.setRun(contactoOrm.getRun());
			contacto.setNombre(contactoOrm.getNombreContacto());
			contacto.setApellido(contactoOrm.getApellidoContacto());
			contacto.setMail(contactoOrm.getMailContacto());
			contacto.setTelefono(contactoOrm.getTelefonoContacto());
			contacto.setPais(contactoOrm.getPaisContacto());
			contacto.setRegion(contactoOrm.getRegionContacto());
			contacto.setCiudad(contactoOrm.getCiudadContacto());
			contacto.setDireccion(contactoOrm.getDireccion());
			listaContacto.add(contacto);
		}
		
		return listaContacto;
	}
	
	public static List <Empresa> llenarSelect() throws PersistentException {
		List <orm.Empresa> listaEmpresaOrm = orm.EmpresaDAO.queryEmpresa(null, null);
		List <Empresa> listaEmpresa = new ArrayList<>();
		for (orm.Empresa empresaOrm:listaEmpresaOrm) {
			Empresa empresa= new Empresa();
			empresa.setIdEmpresa(empresaOrm.getIdEmpresa());
			empresa.setNombreEmpresa(empresaOrm.getNombreEmpresa());
			
			listaEmpresa.add(empresa);
		}
		return listaEmpresa;
	}
	
	/**
	 * Método de busqueda simple de contacto empresarial
	 * @param busqueda de tipo String que es el criterio a buscar
	 * @return listaContacto de tipo List<Contacto>, que es el resultado de la búsqueda
	 * @throws PersistentException
	 */
	public List<Contacto> busquedaSimpleCont(String busqueda) throws PersistentException {
        List<Contacto> listaContacto = new ArrayList<Contacto>();
        List<orm.Contacto> listaContactos = new ArrayList<orm.Contacto>();
        if (busqueda != null || !busqueda.equals("")) {
            
            listaContactos = orm.ContactoDAO.queryContacto("Contacto.run='"+busqueda
            		+"' OR Contacto.nombreContacto='" + busqueda 
            		+"' OR Contacto.apellidoContacto='"+ busqueda
            		+"' OR Contacto.mailContacto='" + busqueda 
            		+"' OR Contacto.telefonoContacto='"+ busqueda
            		+"' OR Contacto.paisContacto='"+busqueda
            		+"' OR Contacto.regionContacto='"+busqueda
            		+"' OR Contacto.ciudadContacto='"+busqueda
            		+"' OR Contacto.direccion='"+busqueda
            		+"'" ,null); 
 
        }
        //if (listaContactos != null) {
        	
        	//Modificar variable recibida de formulario:
        	//a minusculas
        	//a mayusculas
        	//buscar por ñ como n
        	//buscar por n como ñ
        	//buscar sin modificar lo ingresado
            for (orm.Contacto contactoOrm : listaContactos) {
                Contacto contactoNegocio = new Contacto();
                Empresa empresaNegocio = new Empresa();
                orm.Empresa empresaOrm = orm.EmpresaDAO.loadEmpresaByORMID(contactoOrm.getIdEmpresa().getIdEmpresa());
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
                
                empresaNegocio.setIdEmpresa(empresaOrm.getIdEmpresa());
                empresaNegocio.setRut(empresaOrm.getRut());
                empresaNegocio.setRazonSocial(empresaOrm.getRazonSocial());
                empresaNegocio.setNombreEmpresa(empresaOrm.getNombreEmpresa());
                empresaNegocio.setRepresentante(empresaOrm.getRepresentante());
                empresaNegocio.setMailEmpresa(empresaOrm.getMailEmpresa());
                empresaNegocio.setTelefonoEmpresa(empresaOrm.getTelefonoEmpresa());
                empresaNegocio.setPaisEmpresa(empresaOrm.getPaisEmpresa());
                empresaNegocio.setRegionEmpresa(empresaOrm.getRegionEmpresa());
                empresaNegocio.setCiudadEmpresa(empresaOrm.getCiudadEmpresa());
                empresaNegocio.setDomicilio(empresaOrm.getDomicilio());
                
                contactoNegocio.setEmpresa(empresaNegocio);
                
                listaContacto.add(contactoNegocio);
            }
        //}
        return listaContacto;
    }
	
	/**
	 * Método de busqueda simple de contacto empresarial
	 * @param contacto de tipo Contacto
	 * @return listaContacto de tipo List<Contacto>, que es el resultado de la búsqueda
	 * @throws PersistentException
	 */
	public List<Contacto> busquedaAvanzadaCont(Contacto contacto) throws PersistentException {
        List<Contacto> listaContacto = new ArrayList<Contacto>();
        List<orm.Contacto> listaContactos = new ArrayList<orm.Contacto>();
        String query = "";
        
        if (contacto.getNombre() != null && !contacto.getNombre().equals("")) {
            query += "Contacto.nombre='" + contacto.getNombre() + "' ";
        }
        if ((contacto.getNombre() != null && !contacto.getNombre().equals("")) && 
        		(contacto.getApellido() != null && !contacto.getApellido().equals(""))) {
            query += "and ";
        }
        if (contacto.getApellido() != null && !contacto.getApellido().trim().equals("")) {
            query += "Contacto.apellido='" + contacto.getApellido() + "' ";
        }
        if (((contacto.getNombre() != null && !contacto.getNombre().trim().equals("")) || 
        		contacto.getApellido() != null && !contacto.getApellido().trim().equals("")) && 
        		(contacto.getTelefono() != null && !contacto.getTelefono().trim().equals(""))) {
            query += "and ";
        }
        if (contacto.getTelefono() != null && !contacto.getTelefono().trim().equals("")) {
            query += "Contacto.telefono='" + contacto.getTelefono() + "' ";
        }
        if (((contacto.getNombre() != null && !contacto.getNombre().trim().equals("")) || 
        		contacto.getApellido() != null && !contacto.getApellido().trim().equals("")
                || contacto.getTelefono() != null && !contacto.getTelefono().trim().equals("")) && 
                contacto.getMail() != null && !contacto.getMail().trim().equals("")) {
            query += "and ";
        }
        if (contacto.getMail() != null && !contacto.getMail().trim().equals("")) {
            query += "Contacto.mail='" + contacto.getMail() + "'";
        }
        if (contacto.getCiudad() != null && !contacto.getCiudad().trim().equals("")) {
            query += "Contacto.ciudad='" + contacto.getCiudad() + "'";
        }
        if (contacto.getRegion() != null && !contacto.getRegion().trim().equals("")) {
            query += "Contacto.region='" + contacto.getRegion() + "'";
        }
        if (contacto.getPais() != null && !contacto.getPais().trim().equals("")) {
            query += "Contacto.pais='" + contacto.getPais() + "'";
        }

        listaContactos = orm.ContactoDAO.queryContacto(query, null);
       
        if (listaContactos != null) {
            for (orm.Contacto contactoOrm : listaContactos) {
                Contacto contactoNegocio = new Contacto();
              // Empresa empresaNegocio = new Empresa();
               // orm.Empresa empresaOrm = orm.EmpresaDAO.loadEmpresaByORMID(contactoOrm.getUid());//falta codigo aca?
                //empresaNegocio.setNombre(empresaOrm.getNombre());
                //empresaNegocio.setUid(empresaOrm.getUid());
        
             //   contactoNegocio.setEmpresa(empresaNegocio);
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
                
                
                listaContacto.add(contactoNegocio);
            }
        }
        return listaContacto;
    }
	
}
