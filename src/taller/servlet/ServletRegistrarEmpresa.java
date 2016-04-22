package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		ServletRegistrarEmpresa ingreso = new ServletRegistrarEmpresa();
		
		try{
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
					ingresar.setRut(rut);
					ingresar.setRazonSocial(razonSocial);
					ingresar.setNombreEmpresa(nombre);
					ingresar.setRepresentante(representante);
					ingresar.setMailEmpresa(mail);
					ingresar.setTelefonoEmpresa(telefono);
					ingresar.setPaisEmpresa(pais);
					ingresar.setRegionEmpresa(region);
					ingresar.setCiudadEmpresa(ciudad);
					ingresar.setDomicilio(domicilio);
					try {
						Empresa.ingresar(ingresar);
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("Los campos ingresados sobrepasan el límite de caracteres permitidos...");
				}
				
			}
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}

}
