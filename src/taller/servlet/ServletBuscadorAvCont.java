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

		Contacto contacto = new Contacto();
		String run = request.getParameter("run");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String mail = request.getParameter("mail");
		String telefono = request.getParameter("telefonofono");
		String pais = request.getParameter("pais");
		String region = request.getParameter("region");
		String ciudad = request.getParameter("ciudad");
		String direccion = request.getParameter("direccion");
		
		if(run != null){
			contacto.setRun(run);
		} else {
			contacto.setRun("");
		}
		
		if(nombre != null){
			contacto.setNombre(nombre);
		} else {
			contacto.setNombre("");
		}
		
		if(apellido != null){
			contacto.setApellido(apellido);;
		} else {
			contacto.setApellido("");
		}
		
		if(mail != null){
			contacto.setMail(mail);
		} else {
			contacto.setMail("");
		}
		
		if(telefono != null){
			contacto.setTelefono(telefono);
		} else {
			contacto.setTelefono("");
		}
		
		if(pais != null){
			contacto.setPais(pais);
		} else {
			contacto.setPais("");
		}
		
		if(region != null){
			contacto.setRegion(region);
		} else {
			contacto.setRegion("");
		}
		
		if(ciudad != null){
			contacto.setCiudad(ciudad);
		} else {
			contacto.setCiudad("");
		}
		
		if(direccion != null){
			contacto.setDireccion(direccion);
		} else {
			contacto.setDireccion("");
		}

		try {
			List<Contacto> listaContactoBuscar = contacto.busquedaAvanzadaCont(contacto);
			if(!listaContactoBuscar.isEmpty()){
				request.removeAttribute("busqueda");
				request.setAttribute("busqueda", listaContactoBuscar);				
				request.getRequestDispatcher( "BusquedaAvanzada.jsp").forward(request, response);
			} else {
				RequestDispatcher rs = request.getRequestDispatcher("BusquedaAvanzada.jsp");
				request.setAttribute("mensaje",	"No se encontraron datos asociados a la busqueda");
				rs.forward(request, response);
			}
		} catch (PersistentException e) {
			RequestDispatcher rs = request.getRequestDispatcher("BusquedaAvanzada.jsp");
			request.setAttribute("mensaje",	e.getMessage());
			rs.forward(request, response);
		}		
		
		
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
