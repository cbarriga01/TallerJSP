package taller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

import capanegocio.Contacto;
import capanegocio.Empresa;

/**
 * Servlet implementation class ServletEliminarEmpresa
 */
public class ServletEliminarEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminarEmpresa() {
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
		int id= Integer.parseInt(request.getParameter("idEmpresaEl"));
		String msg = "";
		ServletEliminarEmpresa borrar = new ServletEliminarEmpresa();
		borrar.validarId(id);
		Empresa eliminar = new Empresa();
		
		if(id<0){
			System.out.println("variable vacia");
		} else {
			eliminar.setIdEmpresa(id);
			try {
				Empresa.borrar(eliminar);
				msg = "Empresa eliminada exitosamente";
				RequestDispatcher rs = request.getRequestDispatcher("BusquedaSimple.jsp");
				request.setAttribute("msg", msg);
				rs.forward(request, response);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * M�todo que permite validar si el campo ingresado en id es entero
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
