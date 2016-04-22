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
	
	private int eid;

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
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	/**
	 * Método que permite ingresar un contacto a la BD
	 * @param contacto Contacto, 
	 * @return mensaje de si el ingreso fue exitoso o no
	 * @throws PersistentException
	 */
	public static String ingresar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		try{
			try {
				orm.Contacto lormContacto = orm.ContactoDAO.createContacto();
				TallerServlet servlet = new TallerServlet();
				// Initialize the properties of the persistent object here
				lormContacto.setRun(contacto.run);
				lormContacto.setNombreContacto(contacto.nombre);
				lormContacto.setApellidoContacto(contacto.apellido);
				lormContacto.setMailContacto(contacto.mail);
				lormContacto.setTelefonoContacto(contacto.telefono);
				lormContacto.setPaisContacto(contacto.pais);
				lormContacto.setRegionContacto(contacto.region);
				lormContacto.setCiudadContacto(contacto.ciudad);
				lormContacto.setDireccion(contacto.direccion);
				msg = "Ingreso Exitoso";
				orm.ContactoDAO.save(lormContacto);
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
	 * Método que permite actualizar un contacto en la BD
	 * @param contacto de tipo Contacto,
	 * @return mensaje de si la actualización fue exitosa o no
	 * @throws PersistentException
	 */
	public static String actualizar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		try{
			try {
				orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.idContacto);  //orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='victor'", null);
				// Update the properties of the persistent object
				System.out.println("Id = " + contacto.idContacto);
				lormContacto.setRun(contacto.run);
				lormContacto.setNombreContacto(contacto.nombre);
				lormContacto.setApellidoContacto(contacto.apellido);
				lormContacto.setMailContacto(contacto.mail);
				lormContacto.setTelefonoContacto(contacto.telefono);
				lormContacto.setPaisContacto(contacto.pais);
				lormContacto.setRegionContacto(contacto.region);
				lormContacto.setCiudadContacto(contacto.ciudad);
				lormContacto.setDireccion(contacto.direccion);
				msg = "Ingreso Exitoso";
				orm.ContactoDAO.save(lormContacto);
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
	 * @param contacto de tipo Contacto
	 * @return mensaje de si la eliminación fué exitosa o no
	 * @throws PersistentException
	 */
	public static String borrar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		try{
			try {
				orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.idContacto);
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
            listaContactos = orm.ContactoDAO.queryContacto("Contacto.run='" + busqueda + 
            		"Contacto.nombre='" + busqueda + "' or Contacto.apellido='" + 
            		busqueda + "' or Contacto.mail='" + busqueda + "' or Contacto.telefono='" 
            		+ busqueda + "' or Contacto.pais='" + busqueda+"' or Contacto.region='" + 
            		busqueda+"' or Contacto.ciudad='" + busqueda+"' or Contacto.direccion='" 
            		+ busqueda+"'  ", null);
        }
        if (listaContactos != null) {
            for (orm.Contacto contactoOrm : listaContactos) {
                Contacto contactoNegocio = new Contacto();
              //  Empresa empresaNegocio = new Empresa();
             //   orm.Empresa empresaOrm = orm.EmpresaDAO.loadEmpresaByORMID(contactoOrm.getUid());//falta cosasa aca
               // empresaNegocio.setNombre(empresaOrm.getNombre());
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
