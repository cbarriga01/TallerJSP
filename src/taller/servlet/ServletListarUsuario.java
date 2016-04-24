package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import capanegocio.Contacto;
import capanegocio.Usuario;

/**
 * Servlet implementation class ServletListarUsuario
 */
public class ServletListarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Usuario> lista = new ArrayList<>();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			lista=Usuario.listar();
			PrintWriter out = response.getWriter();
			for(Usuario usuario:lista){
				out.println("User: " + usuario.getUser());
				out.println("Password: " + usuario.getPassword());
			}
			//capanegocio.Usuario user = new capanegocio.Usuario();
			//lista = user.listar();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user", lista);
		request.getRequestDispatcher("/ListarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Usuario> lista = new ArrayList<>();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			lista=Usuario.listar();
			PrintWriter out = response.getWriter();
			for(Usuario usuario:lista){
				out.println("User: " + usuario.getUser());
				out.println("Password: " + usuario.getPassword());
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user", lista);
		request.getRequestDispatcher("/ListarUsuario.jsp").forward(request, response);
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
