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
 * 
 * @author C�sar Barriga I.
 *
 */
public class WebServiceProveedor {
	  
	/**
	 * M�todo que realiza una b�squeda simple en base a los datos ingresados
	 * @param busqueda
	 * @return listaJsonContacto con los resultados de la b�squeda
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
	 * M�todo que realiza una b�squeda avanzada en base a los par�metros que contienen 
	 * datos ingresados, no se consideran los par�metros que no contienen datos
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
	 * @return resultadoBusqueda
	 * @throws PersistentException
	 */
	/*
	@WebMethod(operationName="busquedaAvanzadaCont")
	public String busquedaAvanzadaCont(
			@WebParam(name = "run") String run, 
			@WebParam(name = "nombre") String nombre, 
			@WebParam(name = "apellido") String apellido,
			@WebParam(name = "mail") String mail,
			@WebParam(name = "telefono") String telefono,
			@WebParam(name = "pais") String pais,
			@WebParam(name = "region") String region,
			@WebParam(name = "ciudad") String ciudad,
			@WebParam(name = "direccion") String direccion) throws PersistentException{
		
		String resultadoBusqueda = "";
		List<capanegocio.Contacto> listaContactoBuscar = new ArrayList<capanegocio.Contacto>();
		capanegocio.Contacto contacto = new capanegocio.Contacto();
		
		if(run != null){
			contacto.setRun(run);
		} else {
			contacto.setRun("");
		}
		
		if(nombre != null){
			contacto.setNombre(nombre);
		} else {
			contacto.setNombre("");
		}
		
		if(apellido != null){
			contacto.setApellido(apellido);;
		} else {
			contacto.setApellido("");
		}
		
		if(mail != null){
			contacto.setMail(mail);
		} else {
			contacto.setMail("");
		}
		
		if(telefono != null){
			contacto.setTelefono(telefono);
		} else {
			contacto.setTelefono("");
		}
		
		if(pais != null){
			contacto.setPais(pais);
		} else {
			contacto.setPais("");
		}
		
		if(region != null){
			contacto.setRegion(region);
		} else {
			contacto.setRegion("");
		}
		
		if(ciudad != null){
			contacto.setCiudad(ciudad);
		} else {
			contacto.setCiudad("");
		}
		
		if(direccion != null){
			contacto.setDireccion(direccion);
		} else {
			contacto.setDireccion("");
		}
		
		Gson gson = new GsonBuilder().create();
		
		try{
			listaContactoBuscar = contacto.busquedaAvanzadaCont(contacto);
			if(listaContactoBuscar.isEmpty()){
				resultadoBusqueda = "La b�squeda no contiene resultados";
			}else{
				resultadoBusqueda = gson.toJson(listaContactoBuscar);
			}			
		}catch(PersistentException p){
			resultadoBusqueda = "Error capa de servicio: " + p.getMessage();
		}
		
		return resultadoBusqueda;
	}
	*/
	
	@WebMethod(operationName = "busquedaAvanzada")
	public String busquedaAvanzada(String busquedaAvanzada)throws PersistentException{
		
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
			valido = "true";
		}else{
			valido = "false";
		}
		
		return valido;
	}
	
	public String verPerfil(String idContacto){
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
