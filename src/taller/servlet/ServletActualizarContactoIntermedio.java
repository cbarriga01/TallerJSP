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

import capanegocio.Empresa;

/**
 * Servlet implementation class ServletActualizarContactoIntermedio
 */
public class ServletActualizarContactoIntermedio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActualizarContactoIntermedio() {
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

		String idContacto = request.getParameter("id");
		String run = request.getParameter("run");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String mail = request.getParameter("mail");
		String telefono = request.getParameter("telefono");
		String pais = request.getParameter("pais");
		String region = request.getParameter("region");
		String ciudad = request.getParameter("ciudad");
		String direccion = request.getParameter("direccion");
		String imagen = request.getParameter("imagen");
		String empresa = request.getParameter("empresa");
		
		RequestDispatcher rs = request.getRequestDispatcher("/ActualizarContacto.jsp");
		request.setAttribute("id", idContacto);
		request.setAttribute("run", run);
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido", apellido);
		request.setAttribute("mail", mail);
		request.setAttribute("telefono", telefono);
		request.setAttribute("pais", pais);
		request.setAttribute("region", region);
		request.setAttribute("ciudad", ciudad);
		request.setAttribute("direccion", direccion);
		
		List<Empresa> listaEmpresa = new ArrayList<>();
		Empresa empresaNegocio = new Empresa();
		
		try {
			
			listaEmpresa = empresaNegocio.listarEmpresa();
			request.setAttribute("listaEmpresa", listaEmpresa);
			request.getRequestDispatcher("/ActualizarContacto.jsp").forward(request, response);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rs.forward(request, response);
	}

}
