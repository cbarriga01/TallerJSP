package capanegocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import orm.ContactoCriteria;
import taller.servlet.TallerServlet;

/*
 * @author: César Barriga I.
 * 
 * Clase relacionada a la lógica de negocio de la aplicación referente a Contactos
 * Se encarga de enviar transacciones a la Base de Datos
 * 
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
	
	private String imagen;
	
	private Empresa empresa;
	
	private ArrayList<Bitacora> bitacora = new ArrayList<>();

	/**
	 * 
	 * @return Empresa a la que pertenece el contacto
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * 
	 * @param Empresa empresa a la que pertenece el contacto
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * 
	 * @return idContacto del contacto
	 */
	public int getIdContacto() {
		return idContacto;
	}

	/**
	 * 
	 * @param int idContacto del contacto 
	 */
	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	/**
	 * 
	 * @return run del contacto
	 */
	public String getRun() {
		return run;
	}

	/**
	 * 
	 * @param String run del contacto
	 */
	public void setRun(String run) {
		this.run = run;
	}

	/**
	 * 
	 * @return direccion del contacto
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * 
	 * @param String direccion del contacto
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * 
	 * @return nombre del contacto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param String nombre del contacto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return apellido del contacto
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * 
	 * @param String apellido del contacto
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * 
	 * @return mail del contacto
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * 
	 * @param String mail del contacto
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * 
	 * @return telefono del contacto
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * 
	 * @param String telefono del contacto
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * 
	 * @return pais del contacto
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * 
	 * @param String pais del contacto
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * 
	 * @return region del contacto
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * 
	 * @param String region del contcato
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**^
	 * 
	 * @return ciudad del contacto
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * 
	 * @param String ciudad del contacto
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	/**
	 * 
	 * @return imagen del contacto
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * 
	 * @param String imagen del contacto
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Metodo que permite el ingreso de una bitacora al ArrayList Bitacora
	 * @param bitacora
	 */
	public void agregarBitacora(Bitacora bitacora){
		this.bitacora.add(bitacora);
	}
	
	/**
	 * Método que permite ingresar un contacto a la Base de Datos
	 * @param Contacto contacto, objeto que contiene los datos a ingresar
	 * @return String msg, mensaje que informa el estado de la transacción
	 * @throws PersistentException
	 */
	public static String ingresar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";

			try {
				Empresa empresaNegocio = new Empresa();
				orm.Contacto lormContacto = orm.ContactoDAO.createContacto();
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(contacto.getEmpresa().getIdEmpresa());

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
				
				lormContacto.setImagen(contacto.getImagen());
				
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
		return msg;
		
	}
	
	/**
	 * Método que permite actualizar un contacto en la Base de Datos
	 * @param Contacto contacto, objeto que contiene los datos a actualizar
	 * @return String msg, mensaje que informa el estado de la transacción
	 * @throws PersistentException
	 */
	public static String actualizar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "Ingreso fallido de contacto";
			try {
				Empresa empresaNegocio = new Empresa();
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(contacto.getEmpresa().getIdEmpresa());
				orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.getIdContacto());
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
				
					lormContacto.setImagen(contacto.getImagen());
				
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
		return msg;
		
	}
	
	/**
	 * Método que permite eliminar un contacto de la Base de Datos
	 * @param Contacto contacto, objeto que contiene los datos a eliminar
	 * @return String msg, mensaje que informa el estado de la transacción
	 * @throws PersistentException
	 */
	public static String borrar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		try{
			try {
				orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.getIdContacto());
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
	 * Método que permite listar los contactos almacenados en la Base de Datos
	 * @return List <Contacto> listaContacto, lista con contactos almacenados en la Base de Datos
	 * @throws PersistentException
	 */
	public static List <Contacto> listar() throws PersistentException {
		
		List <orm.Contacto> listaContactoOrm = orm.ContactoDAO.queryContacto(null, null);
		List <Contacto> listaContacto = new ArrayList<>();
		
		for (orm.Contacto contactoOrm:listaContactoOrm) {
			Contacto contacto= new Contacto();
			Empresa empresaNegocio = new Empresa();
			orm.Empresa empresaOrm = orm.EmpresaDAO.loadEmpresaByORMID(contactoOrm.getIdEmpresa().getIdEmpresa());
			contacto.setIdContacto(contactoOrm.getIdContacto());
			contacto.setRun(contactoOrm.getRun());
			contacto.setNombre(contactoOrm.getNombreContacto());
			contacto.setApellido(contactoOrm.getApellidoContacto());
			contacto.setMail(contactoOrm.getMailContacto());
			contacto.setTelefono(contactoOrm.getTelefonoContacto());
			contacto.setPais(contactoOrm.getPaisContacto());
			contacto.setRegion(contactoOrm.getRegionContacto());
			contacto.setCiudad(contactoOrm.getCiudadContacto());
			contacto.setDireccion(contactoOrm.getDireccion());
			contacto.setImagen(contactoOrm.getImagen());
			
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
             
             contacto.setEmpresa(empresaNegocio);			
			
			listaContacto.add(contacto);
		}
		
		return listaContacto;
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
        	
        ContactoCriteria ccr = new ContactoCriteria();
        Criterion run = Restrictions.ilike("run", busqueda.toLowerCase());
        Criterion nombreContacto = Restrictions.ilike("nombreContacto", busqueda.toLowerCase());
        Criterion apellidoContacto = Restrictions.ilike("apellidoContacto", busqueda.toLowerCase());
        Criterion mailContacto = Restrictions.ilike("mailContacto", busqueda.toLowerCase());
        Criterion telefonoContacto = Restrictions.ilike("telefonoContacto", busqueda.toLowerCase());
        Criterion paisContacto = Restrictions.ilike("paisContacto", busqueda.toLowerCase());
        Criterion regionContacto = Restrictions.ilike("regionContacto", busqueda.toLowerCase());
        Criterion ciudadContacto = Restrictions.ilike("ciudadContacto", busqueda.toLowerCase());
        Criterion direccion = Restrictions.ilike("direccion", busqueda.toLowerCase());
        Disjunction or=Restrictions.or(run, nombreContacto, apellidoContacto, mailContacto, 
        		telefonoContacto, paisContacto, regionContacto, ciudadContacto, direccion);
        ccr.add(or);
        listaContactos= Arrays.asList(orm.ContactoDAO.listContactoByCriteria(ccr));
        	
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
                contactoNegocio.setImagen(contactoOrm.getImagen());
                
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
        
        ContactoCriteria ccr = new ContactoCriteria();
        
                
        if(contacto.getRun()!= null && !contacto.getRun().trim().equals("")){
        	ccr.add(Restrictions.ilike("run", contacto.getRun().toLowerCase()));
			query += "Contacto.run='"+contacto.getRun()+"' ";
		}
        
		if (contacto.getNombre()!=null && !contacto.getNombre().trim().equals("")){
			ccr.add(Restrictions.ilike("nombreContacto", contacto.getNombre().toLowerCase()));
			query += "Contacto.nombreContacto='"+contacto.getNombre()+"' ";
		}
		
		if(contacto.getApellido()!=null && !contacto.getApellido().trim().equals("")){
			ccr.add(Restrictions.ilike("apellidoContacto", contacto.getApellido().toLowerCase()));
			query += "Contacto.apellidoContacto='"+contacto.getApellido()+"' ";
		}
		
		if(contacto.getMail() != null && !contacto.getMail().trim().equals("")){
			ccr.add(Restrictions.ilike("mailContacto", contacto.getMail().toLowerCase()));
			query += "Contacto.mailContacto='"+contacto.getMail()+"' ";
		}
		
		if(contacto.getTelefono() != null && !contacto.getTelefono().trim().equals("")){
			ccr.add(Restrictions.ilike("telefonoContacto", contacto.getTelefono().toLowerCase()));
			query += "Contacto.telefonoContacto='"+contacto.getTelefono()+ "' ";
		}
		
		if(contacto.getDireccion() != null && !contacto.getPais().trim().equals("")){
			ccr.add(Restrictions.ilike("paisContacto", contacto.getPais().toLowerCase()));
			query += "Contacto.paisContacto='"+contacto.getPais()+ "' ";
		}
		
		if(contacto.getRegion() != null && !contacto.getRegion().trim().equals("")){
			ccr.add(Restrictions.ilike("regionContacto", contacto.getRegion().toLowerCase()));
			query += "Contacto.regionContacto='"+contacto.getRegion()+ "' ";
		}	
				
		if(contacto.getCiudad() != null && !contacto.getCiudad().trim().equals("")){
			ccr.add(Restrictions.ilike("ciudadContacto", contacto.getCiudad().toLowerCase()));
			query += "Contacto.ciudadContacto='"+contacto.getCiudad()+ "' ";
		}	
				
		if(contacto.getDireccion() != null && !contacto.getDireccion().trim().equals("")){
			ccr.add(Restrictions.ilike("direccion", contacto.getDireccion().toLowerCase()));
			query += "Contacto.direccion='"+contacto.getDireccion()+ "' ";
		}	

        listaContactos = Arrays.asList(orm.ContactoDAO.listContactoByCriteria(ccr));
       
        if (!listaContactos.isEmpty()) {
            for (orm.Contacto contactoOrm : listaContactos) {
                Contacto contactoNegocio = new Contacto();
                Empresa empresaBuscar = new Empresa();
                
                orm.Empresa empresaOrm = orm.EmpresaDAO.loadEmpresaByORMID(contactoOrm.getIdEmpresa().getIdEmpresa());
                
                empresaBuscar.setIdEmpresa(empresaOrm.getIdEmpresa());
                empresaBuscar.setRut(empresaOrm.getRut());
                empresaBuscar.setRazonSocial(empresaOrm.getRazonSocial());
                empresaBuscar.setNombreEmpresa(empresaOrm.getNombreEmpresa());
                empresaBuscar.setRepresentante(empresaOrm.getRepresentante());
                empresaBuscar.setMailEmpresa(empresaOrm.getMailEmpresa());
                empresaBuscar.setTelefonoEmpresa(empresaOrm.getTelefonoEmpresa());
                empresaBuscar.setPaisEmpresa(empresaOrm.getPaisEmpresa());
                empresaBuscar.setRegionEmpresa(empresaOrm.getRegionEmpresa());
                empresaBuscar.setCiudadEmpresa(empresaOrm.getCiudadEmpresa());
                empresaBuscar.setDomicilio(empresaOrm.getDomicilio());
                
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
                
                contactoNegocio.setEmpresa(empresaBuscar);
                
                listaContacto.add(contactoNegocio);
            }
        }
        return listaContacto;
    }
	
	/**
	 * Método encargado de mostrar un perfil de contacto
	 * @param idContacto
	 * @return
	 * @throws PersistentException
	 */
	public static Contacto verPerfilContacto(int idContacto) throws PersistentException{
		
		Contacto contacto=new Contacto();
	    orm.Contacto contactoOrm = orm.ContactoDAO.loadContactoByORMID(idContacto);
	    Empresa empresaNegocio = new Empresa();
        orm.Empresa empresaOrm = orm.EmpresaDAO.loadEmpresaByORMID(contactoOrm.getIdEmpresa().getIdEmpresa());
        
	    contacto.setIdContacto(contactoOrm.getIdContacto());
        contacto.setRun(contactoOrm.getRun());
        contacto.setNombre(contactoOrm.getNombreContacto());
        contacto.setApellido(contactoOrm.getApellidoContacto());
        contacto.setMail(contactoOrm.getMailContacto());
        contacto.setTelefono(contactoOrm.getTelefonoContacto());
        contacto.setPais(contactoOrm.getPaisContacto());
        contacto.setRegion(contactoOrm.getRegionContacto());
        contacto.setCiudad(contactoOrm.getCiudadContacto());
        contacto.setDireccion(contactoOrm.getDireccion());
        contacto.setImagen(contactoOrm.getImagen());
        
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
        
        contacto.setEmpresa(empresaNegocio);			
	    
	    return contacto;
	}
	
}
