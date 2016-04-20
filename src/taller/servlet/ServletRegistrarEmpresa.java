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
		PrintWriter out= response.getWriter();
		PersistentTransaction t = null;
		String nombre= "";
		String pais= "";
		String ciudad= "";
		String direccion= "";
		ServletRegistrarEmpresa ingreso = new ServletRegistrarEmpresa();
		
		try{
			nombre= request.getParameter("nombre");
			pais= request.getParameter("pais");
			ciudad= request.getParameter("ciudad");
			direccion= request.getParameter("direccion");
			
			if(nombre.trim().equals("")|| pais.trim().equals("")||ciudad.trim().equals("")||
					direccion.trim().equals("")){
				System.out.println("variable vacia");
				
			}else{
				if (nombre.length() <=20 && pais.length() <= 20 && ciudad.length() <= 20 && 
						direccion.length() <= 20){
					out.println(" Hola tu nombre es "+ nombre+ ". Saludos!!!");
					
					Empresa ingresar = new Empresa();
					ingresar.setNombre(nombre);
					ingresar.setPais(pais);
					ingresar.setCiudad(ciudad);
					ingresar.setDireccion(direccion);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
