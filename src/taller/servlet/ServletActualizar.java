package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Contacto;
import capanegocio.Empresa;

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
		/*HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
		request.setAttribute("msg",	" Error en sesión, debe ingresar sus datos de usuario.");
		rs.forward(request, response);*/
		List<Empresa> listaEmpresa = new ArrayList<>();
		Empresa empresa = new Empresa();
		
		try {
			
			listaEmpresa = empresa.listarEmpresa();
			request.setAttribute("listaEmpresa", listaEmpresa);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/ActualizarContacto.jsp").forward(request, response);
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
			String run= request.getParameter("run");
			String nombre= request.getParameter("nombre");
			String apellido= request.getParameter("apellido");
			String mail= request.getParameter("mail");
			String telefono= request.getParameter("telefono");
			String pais= request.getParameter("pais");
			String region= request.getParameter("region");
			String ciudad= request.getParameter("ciudad");
			String direccion= request.getParameter("direccion");
			String imagen= request.getParameter("textArea");
			String empresa= request.getParameter("empresa");
			String msg = "";
			int idEmpresa = Integer.parseInt(empresa);
			
			ServletActualizar refrescar = new ServletActualizar();
			refrescar.validarId(id);
			refrescar.validarRun(run);
			refrescar.validarEmail(mail);
			refrescar.validarEntero(telefono);
			
			if ((refrescar.validarId(id)) && (refrescar.validarRun(run) == true) 
					&& (refrescar.validarEmail(mail) == true)
					&& (refrescar.validarEntero(telefono))){
			
				Empresa emp = new Empresa();
				Contacto actualizar = new Contacto();
					
				if (run.length() <=12 && nombre.length() <=50 && apellido.length() <=50 
						&& mail.length() <=20 && telefono.length() <= 20 
						&& pais.length() <= 20 && region.length() <= 20 
						&& ciudad.length() <= 20 && direccion.length() <= 30){
					out.println(" Hola tu id es "+ id+ ". Saludos!!!");
					
					actualizar.setIdContacto(id);
					if ((run != null) && (!run.equals(""))) {
						actualizar.setRun(run);
					}
					if ((nombre != null) && (!nombre.equals(""))){
						actualizar.setNombre(nombre);
	 			    }
	 					
	 			    if ((apellido != null) && (!apellido.equals(""))) {
	 			    	actualizar.setApellido(apellido);
	 			    }
	 				    
	 			    if ((mail != null) && (!mail.equals(""))) {
	 			    	actualizar.setMail(mail);
	 			    }
	 				    
	 			    if ((telefono != null) && (!telefono.equals(""))) {
	 			    	actualizar.setTelefono(telefono);
	 			    }
	 				    
	 			    if ((pais != null) && (!pais.equals(""))) {
	 			    	actualizar.setPais(pais);
	 			    }
	 				    
	 			    if ((region != null) && (!region.equals(""))) {
	 			    	actualizar.setRegion(region);
	 			    }
	 				    
	 			    if ((ciudad != null) && (!ciudad.equals(""))) {
	 			    	actualizar.setCiudad(ciudad);
	 			    }
	 				    
	 			    if ((direccion != null) && (!direccion.equals(""))) {
	 			    	actualizar.setDireccion(direccion);
	 			    }
					
	 			    actualizar.setImagen(imagen);
						
					emp.setIdEmpresa(idEmpresa);
					try{
						actualizar.setEmpresa(emp);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					
					String r="";
					try {
						r=Contacto.actualizar(actualizar);
						msg = "Actualización exitosa";
						RequestDispatcher rs = request.getRequestDispatcher("ActualizarContacto.jsp");
						request.setAttribute("msg", msg);
						rs.forward(request, response);
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			} else { //Else de validaci�n de rut, mail y entero
				msg = "Error en el ingreso, datos inv�lidos";
				RequestDispatcher rs = request.getRequestDispatcher("ActualizarContacto.jsp");
				request.setAttribute("msg", msg);
				rs.forward(request, response);
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
	private boolean validarEmail(String email) {
		 
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
	private boolean validarEntero(String cad){
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
	 * M�todo que permite validar si el run ingresado es v�lido
	 * @param String run del contacto a validar
	 * @return boolean validacion, indica si el run es valido o no
	 */
	public static boolean validarRun(String run) {
		 
		boolean validacion = false;
		try {
			run = run.toUpperCase();
			run = run.replace(".", "");
			run = run.replace("-", "");
			int runAux = Integer.parseInt(run.substring(0, run.length() - 1));
			 
			char dv = run.charAt(run.length() - 1);
			 
			int m = 0, s = 1;
			for (; runAux != 0; runAux /= 10) {
				s = (s + runAux % 10 * (9 - m++ % 6)) % 11;
			}
			if (dv == (char) (s != 0 ? s + 47 : 75)) {
				validacion = true;
			}
			 
		} catch (java.lang.NumberFormatException e) {
		} catch (Exception e) {
		}
		return validacion;
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
