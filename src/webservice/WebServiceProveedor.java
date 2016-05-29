package webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.orm.PersistentException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import capanegocio.Contacto;
import capanegocio.Usuario;

/**
 * Clase encargada del funcionamiento de los servicios web mediante el patrón DAO.
 * @author César Barriga I.
 *
 */
public class WebServiceProveedor {
	  
	/**
	 * Método que realiza una búsqueda simple en base a los datos ingresados
	 * @param busqueda
	 * @return listaJsonContacto con los resultados de la búsqueda
	 * @throws PersistentException
	 */
	@WebMethod(operationName="busquedaSimpleCont")
	public String busquedaSimpleCont(@WebParam(name="busqueda")String busqueda)throws PersistentException{
		
		List<Contacto> listaContactoArray= new ArrayList<Contacto>();
		Contacto contacto=new Contacto();
		Gson listaJsonContacto=new GsonBuilder().create();
	
		try{
			listaContactoArray=contacto.busquedaSimpleCont(busqueda);
			if(listaContactoArray.isEmpty()){
				return "no se encontraron datos";
			}else{
				return listaJsonContacto.toJson(listaContactoArray);	
			   }
			}
		catch (PersistentException e){
			return e.getMessage();
		}
	
	}
	
	/**
	 * Método que realiza una búsqueda avanzada en base a los parámetros que contienen 
	 * datos ingresados, no se consideran los parámetros que no contienen datos
	 * 
	 * @param run
	 * @param nombre
	 * @param apellido
	 * @param mail
	 * @param telefono
	 * @param pais
	 * @param region
	 * @param ciudad
	 * @param direccion
	 * @return resultado en formato Json
	 * @throws PersistentException
	 */
	
	@WebMethod(operationName = "busquedaAvanzada")
	public String busquedaAvanzada(@WebParam(name="busquedaAvanzada")String busquedaAvanzada)
			throws PersistentException{
		
		String resultado = "";
		List<Contacto> listarContactos = new ArrayList<Contacto>();
		Contacto contacto = new Contacto();
		Gson listarJson =new Gson();
		try{
			 contacto=listarJson.fromJson(busquedaAvanzada, Contacto.class);
			
		}catch(JsonSyntaxException e){
			return null;
		}
	
		if(contacto.getRun()!= null){
			contacto.setRun(contacto.getRun());
		}			
		else{
			contacto.setRun("");
		}
		
		if(contacto.getNombre() != null){
			contacto.setNombre(contacto.getNombre());
		}else{
			contacto.setNombre("");
		}
		
		if(contacto.getApellido() != null){
			contacto.setApellido(contacto.getApellido());
		}else{
			contacto.setApellido("");
		}
		
		if(contacto.getMail() != null){
			contacto.setMail(contacto.getMail());
		}else{
			contacto.setMail("");
		}
		
		if(contacto.getTelefono()!= null){
			contacto.setTelefono(contacto.getTelefono());
		}else{
			contacto.setTelefono("");
		}
		
		if(contacto.getPais() != null){
			contacto.setPais(contacto.getPais());
		}else{
			contacto.setPais("");
		}
		
		if(contacto.getRegion() != null){
			contacto.setRegion(contacto.getRegion());
		}else{
			contacto.setRegion("");
		}
		if(contacto.getCiudad()!= null){
			contacto.setCiudad(contacto.getCiudad());
		}else{
			contacto.setCiudad("");
		}
		if(contacto.getDireccion()!= null){
			contacto.setDireccion(contacto.getDireccion());
		}else{
			contacto.setDireccion("");
		}
	
		
		 listarJson = new GsonBuilder().create();
		
		try{
			listarContactos = contacto.busquedaAvanzadaCont(contacto);
			if(listarContactos.isEmpty()){
				resultado = "no se encontraron datos";
			}else{
				resultado = listarJson.toJson(listarContactos);
			}			
		}catch(PersistentException p){
			resultado = p.getMessage();
		}
		return resultado;
	}
	/**
	 * Método encargado de la comprobación de un usuario
	 * @param usuario
	 * @param password
	 * @return String valido, retorna un mensaje indicando si el usuario es válido o no
	 * @throws PersistentException
	 */
	@WebMethod(operationName = "comprobarUsuario")
	public String comprobarUsuario(
			@WebParam(name = "usuario") String usuario,
			@WebParam(name = "password") String password) throws PersistentException{
		
		Usuario us = new Usuario();
		String valido = "f";
		
		if(usuario != null){
			us.setUsuario(usuario);
		}			
		else{
			us.setUsuario("");
		}
		
		if(password != null){
			us.setPassword(password);
		}			
		else{
			us.setPassword("");
		}
		
		
		if(us.validarUsuario(us)){
			valido = "si";
		}else{
			valido = "no";
		}
		
		return valido;
	}
	
	/**
	 * Método encargado de mostrar el perfil de un contacto empresarial
	 * @param idContacto
	 * @return El perfil del contacto empresarial en formato Json o bien un mensaje de error
	 */
	@WebMethod(operationName = "verPerfil")
	public String verPerfil(@WebParam(name = "idContacto") String idContacto){
		int id=Integer.parseInt(idContacto);
		try {
			Contacto contactoNegocio=Contacto.verPerfilContacto(id);
			Gson listarJson = new GsonBuilder().create();
			return listarJson.toJson(contactoNegocio);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
	}
			
}
