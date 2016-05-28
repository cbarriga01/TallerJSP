package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Contacto;
import capanegocio.Empresa;

/**
 * Servlet implementation class ServletActualizarEmpresa
 */
public class ServletActualizarEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActualizarEmpresa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
		request.setAttribute("msg",	" Error en sesión, debe ingresar sus datos de usuario.");
		rs.forward(request, response);
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
			String rut= request.getParameter("rut");
			String razonSocial= request.getParameter("razonSocial");
			String nombre= request.getParameter("nombre");
			String representante= request.getParameter("representante");
			String mail= request.getParameter("mail");
			String telefono= request.getParameter("telefono");
			String pais= request.getParameter("pais");
			String region= request.getParameter("region");
			String ciudad= request.getParameter("ciudad");
			String domicilio= request.getParameter("domicilio");
			String msg = "";
			
			ServletActualizarEmpresa refrescar = new ServletActualizarEmpresa();
			refrescar.validarId(id);
			
			Empresa actualizar = new Empresa();
			if(id < 0 || rut.trim().equals("") || razonSocial.trim().equals("") || nombre.trim().equals("") ||
					representante.trim().equals("") || mail.trim().equals("") || telefono.trim().equals("") || 
					pais.trim().equals("") || region.trim().equals("") || ciudad.trim().equals("") || 
					domicilio.trim().equals("")){
				System.out.println("variable vacia");
				
			} else {
				
				if (rut.length() <=12 && razonSocial.length() <=30 && nombre.length() <=30 && 
						representante.length() <=50 && mail.length() <= 20 && telefono.length() <= 20 &&
						pais.length() <= 20 && region.length() <= 20 && ciudad.length() <= 20 && 
						domicilio.length() <= 30){
					out.println(" Hola tu id es "+ id+ ". Saludos!!!");
					actualizar.setIdEmpresa(id);
					actualizar.setRut(rut);
					actualizar.setRazonSocial(razonSocial);
					actualizar.setNombreEmpresa(nombre);
					actualizar.setRepresentante(representante);
					actualizar.setMailEmpresa(mail);
					actualizar.setTelefonoEmpresa(telefono);
					actualizar.setPaisEmpresa(pais);
					actualizar.setRegionEmpresa(region);
					actualizar.setCiudadEmpresa(ciudad);
					actualizar.setDomicilio(domicilio);
					try {
						Empresa.actualizar(actualizar);
						msg = "Actualizaci�n exitosa";
						RequestDispatcher rs = request.getRequestDispatcher("ActualizarEmpresa.jsp");
						request.setAttribute("msg", msg);
						rs.forward(request, response);
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
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
