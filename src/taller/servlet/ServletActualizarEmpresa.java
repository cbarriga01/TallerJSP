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
			String pais= request.getParameter("pais");
			String ciudad= request.getParameter("ciudad");
			String direccion= request.getParameter("direccion");
			
			ServletActualizarEmpresa refrescar = new ServletActualizarEmpresa();
			refrescar.validarId(id);
			
			Empresa actualizar = new Empresa();
			if(id < 0 || nombre.trim().equals("")|| pais.trim().equals("")||ciudad.trim().equals("")||
					direccion.trim().equals("")){
				System.out.println("variable vacia");
				
			} else {
				
				if (nombre.length() <=20 && pais.length() <= 20 && ciudad.length() <= 20 && 
						direccion.length() <= 20){
					out.println(" Hola tu id es "+ id+ ". Saludos!!!");
					actualizar.setId(id);
					actualizar.setNombre(nombre);
					actualizar.setPais(pais);
					actualizar.setCiudad(ciudad);
					actualizar.setDireccion(direccion);
					try {
						Empresa.actualizar(actualizar);
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
	 * Método que permite validar si el campo ingresado en id es entero
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
