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
 * Servlet implementation class ServletRegistrarEmpresa
 */
public class ServletRegistrarEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarEmpresa() {
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
		PrintWriter out= response.getWriter();
		PersistentTransaction t = null;
		String rut= "";
		String razonSocial= "";
		String nombre= "";
		String representante= "";
		String mail= "";
		String telefono= "";
		String pais= "";
		String region= "";
		String ciudad= "";
		String domicilio= "";
		String msg="";
		ServletRegistrarEmpresa ingreso = new ServletRegistrarEmpresa();
		
		//try{
			rut= request.getParameter("rut");
			razonSocial= request.getParameter("razonSocial");
			nombre= request.getParameter("nombre");
			representante= request.getParameter("representante");
			mail= request.getParameter("mail");
			telefono= request.getParameter("telefono");
			pais= request.getParameter("pais");
			region= request.getParameter("region");
			ciudad= request.getParameter("ciudad");
			domicilio= request.getParameter("domicilio");
			
			if(rut.trim().equals("") || razonSocial.trim().equals("") || nombre.trim().equals("") ||
					representante.trim().equals("") || mail.trim().equals("") || telefono.trim().equals("") || 
					pais.trim().equals("") || region.trim().equals("") || ciudad.trim().equals("") || 
					domicilio.trim().equals("")){
				System.out.println("variable vacia");
				
			}else{
				if (rut.length() <=12 && razonSocial.length() <=30 && nombre.length() <=30 && 
						representante.length() <=50 && mail.length() <= 20 && telefono.length() <= 20 &&
						pais.length() <= 20 && region.length() <= 20 && ciudad.length() <= 20 && 
						domicilio.length() <= 30){
					out.println(" Hola tu nombre es "+ nombre+ ". Saludos!!!");
					
					Empresa ingresar = new Empresa();
					try{
						ingresar.setRut(rut);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setRazonSocial(razonSocial);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setNombreEmpresa(nombre);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setRepresentante(representante);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setMailEmpresa(mail);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setTelefonoEmpresa(telefono);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setPaisEmpresa(pais);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setRegionEmpresa(region);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setCiudadEmpresa(ciudad);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setDomicilio(domicilio);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try {
						Empresa.ingresar(ingresar);
						msg = "Ingreso exitoso";
						RequestDispatcher rs = request.getRequestDispatcher("IngresarContacto.jsp");
						request.setAttribute("msg", msg);
						rs.forward(request, response);
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					msg = "Error en el ingreso, datos inválidos";
					RequestDispatcher rs = request.getRequestDispatcher("IngresarContacto.jsp");
					request.setAttribute("msg", msg);
					rs.forward(request, response);
				}
				
			}
		//}catch(NullPointerException e){
		//	e.printStackTrace();
		//}
	}

}
