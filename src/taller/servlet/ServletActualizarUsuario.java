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

import capanegocio.Contacto;
import capanegocio.Usuario;

/**
 * Servlet implementation class ServletActualizarUsuario
 */
public class ServletActualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActualizarUsuario() {
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
		PersistentTransaction t = null;
		PrintWriter out= response.getWriter();
		
		
		try{
			int id= Integer.parseInt(request.getParameter("id"));
			String user= request.getParameter("user");
			String password= request.getParameter("password");
			String msg= "";
			
			ServletActualizarUsuario refrescar = new ServletActualizarUsuario();
			refrescar.validarId(id);
			
			Usuario actualizar = new Usuario();
			if(id < 0 || user.trim().equals("")|| password.trim().equals("")){
				System.out.println("variable vacia");
				
			} else {
				
				if (user.length() <=20 && password.length() <=20 ){
					out.println(" Hola tu id es "+ id+ ". Saludos!!!");
					actualizar.setIdusuario(id);
					actualizar.setUsuario(user);
					actualizar.setPassword(password);
					try {
						Usuario.actualizar(actualizar);
						msg = "Actualización exitosa";
						RequestDispatcher rs = request.getRequestDispatcher("ActualizarUsuario.jsp");
						request.setAttribute("msg", msg);
						rs.forward(request, response);
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}

	/**
	 * Método que permite validar si el campo ingresado en id es entero
	 * @param id= campo ingresado en id
	 * @return
	 */
	private boolean validarId(int id){
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
