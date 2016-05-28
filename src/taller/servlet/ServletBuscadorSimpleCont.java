package taller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

import capanegocio.Contacto;

/**
 * Servlet implementation class ServletBuscadorSimpleCont
 */
public class ServletBuscadorSimpleCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletBuscadorSimpleCont() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
		request.setAttribute("msg",	" Error en sesión, debe ingresar sus datos de usuario.");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String textoBusqueda;

		try{
			textoBusqueda = request.getParameter("textoBusqueda");
		}catch(NullPointerException e){
			textoBusqueda="";
		}
		Contacto contacto = new Contacto();
		List<Contacto> lista = new ArrayList<Contacto>();
		try {
			lista = contacto.busquedaSimpleCont(textoBusqueda);
			if (lista.isEmpty()){
				request.setAttribute("msg", "La búsqueda no arrojó resultados");
			}else{
				request.setAttribute("msg", "Resultado de la búsqueda");
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.removeAttribute("busqueda");
		request.setAttribute("busqueda", lista);
		request.getRequestDispatcher("/BusquedaSimple.jsp").forward(request, response);

	}

}
