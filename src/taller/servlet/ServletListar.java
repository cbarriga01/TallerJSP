package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import capanegocio.Contacto;

/**
 * Servlet implementation class ServletListar
 */
//@WebServlet("/ServletListar")
public class ServletListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Contacto> lista = new ArrayList<>();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			lista=Contacto.listar();
			PrintWriter out = response.getWriter();
			for(Contacto contacto:lista){
				out.println("Run: " + contacto.getRun());
				out.println("Nombre: " + contacto.getNombre());
				out.println("Apellido: " + contacto.getApellido());
				out.println("Mail: " + contacto.getMail());
				out.println("Telefono: " + contacto.getTelefono());
				out.println("Pais: " + contacto.getPais());
				out.println("Region: " + contacto.getRegion());
				out.println("Ciudad: " + contacto.getCiudad());
				out.println("Direccion " + contacto.getDireccion());
				out.println("Imagen " + contacto.getImagen());
				out.println("Empresa " + contacto.getEmpresa().getNombreEmpresa());
				System.out.println("Empresa " + contacto.getEmpresa().getNombreEmpresa());
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaContacto", lista);
		request.getRequestDispatcher("/ListarContacto.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
