package taller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import capanegocio.Contacto;

/**
 * Servlet implementation class ServletBuscadorAvCont
 */
public class ServletBuscadorAvCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletBuscadorAvCont() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nombre = "", apellido = "", telefono = "", mail = "", ciudad = "", region = "", pais = "";
		try {
			nombre = request.getParameter("nombre");
		} catch (NullPointerException e) {
		}
		try {
			apellido = request.getParameter("apellido");
		} catch (NullPointerException e) {
		}
		try {
			telefono = request.getParameter("telefono");
		} catch (NullPointerException e) {
		}
		try {
			mail = request.getParameter("mail");
		} catch (NullPointerException e) {
		}
		try {
			ciudad = request.getParameter("ciudad");
		} catch (NullPointerException e) {
		}
		try {
			region = request.getParameter("region");
		} catch (NullPointerException e) {
		}
		try {
			pais = request.getParameter("pais");
		} catch (NullPointerException e) {
		}

		Contacto contacto = new Contacto();
		contacto.setNombre(nombre);
		contacto.setApellido(apellido);
		contacto.setTelefono(telefono);
		contacto.setMail(mail);
		contacto.setCiudad(ciudad);
		contacto.setRegion(region);
		contacto.setPais(pais);
		List<Contacto> lista = new ArrayList<Contacto>();
		try {
			lista = contacto.busquedaAvanzadaCont(contacto);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.removeAttribute("busqueda");
		request.setAttribute("busqueda", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("FormularioBuscarContacto.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
