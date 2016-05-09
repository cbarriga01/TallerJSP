package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Contacto;

/**
 * Servlet implementation class ServletEliminar
 */
//@WebServlet("/ServletEliminar")
public class ServletEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminar() {
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
		int id= Integer.parseInt(request.getParameter("id"));
		
		ServletEliminar borrar = new ServletEliminar();
		borrar.validarId(id);
		Contacto eliminar = new Contacto();
		
		if(id<0){
			System.out.println("variable vacia");
		} else {
			eliminar.setIdContacto(id);
			try {
				Contacto.borrar(eliminar);
				RequestDispatcher rs = request.getRequestDispatcher("EliminarContacto.jsp");
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * Método que permite validar si el campo ingresado en id es entero
	 * @param id = campo ingresado en id
	 * @return
	 */
	public boolean validarId(int id){
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
