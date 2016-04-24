package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Contacto;
import capanegocio.Empresa;
import ormsamples.CreateTaller1MagisterInformaticaData;

/**
 * Servlet implementation class TallerServlet
 */
//@WebServlet("/TallerServlet")
public class TallerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TallerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		PersistentTransaction t = null;
		String run= "";
		String nombre= "";
		String apellido= "";
		String mail= "";
		String telefono= "";
		String pais= "";
		String region= "";
		String ciudad= "";
		String direccion= "";
		String empresa= "";
		TallerServlet ingreso = new TallerServlet();
		
		//try{
			run= request.getParameter("run");
			nombre= request.getParameter("nombre");
			apellido= request.getParameter("apellido");
			mail= request.getParameter("mail");
			telefono= request.getParameter("telefono");
			pais= request.getParameter("pais");
			region= request.getParameter("region");
			ciudad= request.getParameter("ciudad");
			direccion= request.getParameter("direccion");
			//Obtener request de la empresa
			empresa= request.getParameter("empresa");
			int idEmpresa = Integer.parseInt(empresa);
			
			ingreso.validateEmail(mail);
			ingreso.esEntero(telefono);
			//Validar datos empresa
			if(run.trim().equals("") || nombre.trim().equals("") || apellido.trim().equals("")||
					mail.trim().equals("") || telefono.trim().equals("") || pais.trim().equals("") || 
					region.trim().equals("") || ciudad.trim().equals("") || direccion.trim().equals("") ||
					idEmpresa < 0){
				System.out.println("variable vacia");
				
			}else{
				if (run.length() <=12 && nombre.length() <=50 && apellido.length() <=50 && mail.length() <=20 && 
						telefono.length() <= 20 && pais.length() <= 20 && region.length() <= 20 && 
						ciudad.length() <= 20 && direccion.length() <= 30){
					out.println(" Hola tu nombre es "+ nombre+ ". Saludos!!!");
					
					//Instanciar clase empresa
					Empresa emp = new Empresa();
 					Contacto ingresar = new Contacto(); //renombrar ingresar por objetoContacto o similar
					try{
						ingresar.setRun(run);
					}catch (NullPointerException e) {
						e.printStackTrace();
					}
					try{
						ingresar.setNombre(nombre);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setApellido(apellido);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setMail(mail);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setTelefono(telefono);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setPais(pais);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setRegion(region);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setCiudad(ciudad);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setDireccion(direccion);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					//asignar al contacto el objeto de la empresa
					
					//Instanciar variable que almacene la respuesta de la capa de negocio
					emp.setIdEmpresa(idEmpresa);
					try{
						ingresar.setEmpresa(emp);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					
					String r="";
					
					try {
						r=Contacto.ingresar(ingresar);
						//asignar a la variable creada la respuesta del metodo ingresar
						//Contacto.ingresar(ingresar);
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("Los campos ingresados sobrepasan el límite de caracteres permitidos...");
				}
				
			}
		//}catch(NullPointerException e){
		//	e.printStackTrace();
		//}
		
		
	}

	/**
	 * Método que permite validar el formato de un mail
	 * @param email = cadena con el mail recibido
	 * @return
	 */
	public boolean validateEmail(String email) {
		 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
	
	/**
	 * Método que permite validar que el formato de la cadena ingresada sea numérico
	 * @param cad = cadena ingresada
	 * @return
	 */
	public boolean esEntero(String cad){
		 for(int i = 0; i<cad.length(); i++)
		 if( !Character.isDigit(cad.charAt(i)) ){
			 return false;
		 }
		 return true;
	 }
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
