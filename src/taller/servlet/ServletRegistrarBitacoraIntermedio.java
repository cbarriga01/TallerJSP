package taller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRegistrarBitacoraIntermedio
 */
public class ServletRegistrarBitacoraIntermedio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarBitacoraIntermedio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idContacto = request.getParameter("idContacto");
		String nombreContacto = request.getParameter("nombre");
		String apellidoContacto = request.getParameter("apellido");
		RequestDispatcher rs = request.getRequestDispatcher("/IngresarBitacora.jsp");
		request.setAttribute("idContacto", idContacto);
		
		request.setAttribute("msg",	"Bitácora de " + nombreContacto + " " + apellidoContacto);
		request.getRequestDispatcher("/IngresarBitacora.jsp").forward(request, response);
		
		rs.forward(request, response);
	}

}
