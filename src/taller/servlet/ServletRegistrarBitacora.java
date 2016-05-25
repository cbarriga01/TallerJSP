package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Bitacora;
import capanegocio.Contacto;

/**
 * Servlet implementation class ServletRegistrarBitacora
 */
public class ServletRegistrarBitacora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarBitacora() {
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
		//doGet(request, response);
		PrintWriter out= response.getWriter();
		PersistentTransaction t = null;
		
		String titulo= "";
		String texto= "";
		String contacto= "";
		String msg="";
		ServletRegistrarBitacora ingreso = new ServletRegistrarBitacora();
		
		titulo = request.getParameter("titulo");
		texto = request.getParameter("texto");
		contacto = request.getParameter("idContacto");
		int idContacto = Integer.parseInt(contacto);
		
		if ((titulo.length() <= 20) && (texto.length() <= 250)){
			Contacto con = new Contacto();
			Bitacora ingresar = new Bitacora();
			
			if ((titulo != null) && (!titulo.equals(""))) {
				ingresar.setTitulo(titulo);
			}
			
			if ((texto != null) && (!texto.equals(""))) {
				ingresar.setTexto(texto);
			}
			
			con.setIdContacto(idContacto);
			
			if ((con != null) && (!con.equals(""))) {
				ingresar.setContacto(con);
			}
			
			String r="";
			
			try {
				r=Bitacora.ingresarBitacora(ingresar);
				msg = "Ingreso exitoso";
				RequestDispatcher rs = request.getRequestDispatcher("IngresarBitacora.jsp");
				request.setAttribute("msg", msg);
				rs.forward(request, response);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
