package webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.orm.PersistentException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import capanegocio.Contacto;

/**
 * 
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
	 * @return resultadoBusqueda
	 * @throws PersistentException
	 */
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
				resultadoBusqueda = "La búsqueda no contiene resultados";
			}else{
				resultadoBusqueda = gson.toJson(listaContactoBuscar);
			}			
		}catch(PersistentException p){
			resultadoBusqueda = "Error capa de servicio: " + p.getMessage();
		}
		
		return resultadoBusqueda;
	}
			
}
