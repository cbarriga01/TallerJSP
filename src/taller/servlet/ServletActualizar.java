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

/**
 * Servlet implementation class ServletActualizar
 */
//@WebServlet("/ServletActualizar")
public class ServletActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActualizar() {
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
		PersistentTransaction t = null;
		PrintWriter out= response.getWriter();
		
		
		try{
			int id= Integer.parseInt(request.getParameter("id"));
			String nombre= request.getParameter("nombre");
			String apellido= request.getParameter("apellido");
			String mail= request.getParameter("mail");
			String telefono= request.getParameter("telefono");
			String pais= request.getParameter("pais");
			String region= request.getParameter("region");
			String ciudad= request.getParameter("ciudad");
			
			ServletActualizar refrescar = new ServletActualizar();
			refrescar.validarId(id);
			refrescar.validateEmail(mail);
			refrescar.esEntero(telefono);
			
			Contacto actualizar = new Contacto();
			if(id < 0 || nombre.trim().equals("")|| apellido.trim().equals("")||mail.trim().equals("")||
					telefono.trim().equals("")||pais.trim().equals("")||region.trim().equals("")||
					ciudad.trim().equals("")){
				System.out.println("variable vacia");
				
			} else {
				
				if (nombre.length() <=100 && apellido.length() <=100 && mail.length() <=50 && 
						telefono.length() <= 20 && pais.length() <= 20 && region.length() <= 20 && 
						ciudad.length() <= 20){
					out.println(" Hola tu id es "+ id+ ". Saludos!!!");
					actualizar.setUid(id);
					actualizar.setNombre(nombre);
					actualizar.setApellido(apellido);
					actualizar.setMail(mail);
					actualizar.setTelefono(telefono);
					actualizar.setPais(pais);
					actualizar.setRegion(region);
					actualizar.setCiudad(ciudad);
					try {
						Contacto.actualizar(actualizar);
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
	}

	/**
	 * M�todo que permite validar el formato de un mail
	 * @param email, String , variable con el mail recibido
	 * @return booleano que representra true si esta bueno o false si esta malo
	 */
	private boolean validateEmail(String email) {
		 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
	
	/**
	 * M�todo que permite validar que el formato de la cadena ingresada sea num�rico
	 * @param cad = cadena ingresada
	 * @return
	 */
	private boolean esEntero(String cad){
		 for(int i = 0; i<cad.length(); i++)
		 if( !Character.isDigit(cad.charAt(i)) ){
			 return false;
		 }
		 return true;
	 }
	
	/**
	 * M�todo que permite validar si el campo ingresado en id es entero
	 * @param id = campo ingresado en id
	 * @return
	 */
	private boolean validarId(int id){
		String cad = String.valueOf(id);
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