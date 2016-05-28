package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Contacto;
import capanegocio.Usuario;

/**
 * Servlet implementation class ServletRegistrarUsuario
 */
public class ServletRegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarUsuario() {
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
		PrintWriter out= response.getWriter();
		PersistentTransaction t = null;
		String user= "";
		String password= "";
		String msg="";
		ServletRegistrarUsuario ingreso = new ServletRegistrarUsuario();
		
		//try{
			user= request.getParameter("user");
			password= request.getParameter("password");
				
			if(user.trim().equals("")|| password.trim().equals("")){
				System.out.println("variable vacia");
				
			}else{
				if (user.length() <=20 && password.length() <=20 ){
					out.println(" Hola tu usuario es "+ user+ ". Saludos!!!");
					
					Usuario ingresar = new Usuario();
					try{
						ingresar.setUsuario(user);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try{
						ingresar.setPassword(password);
					}catch (NullPointerException e){
						e.printStackTrace();
					}
					try {
						Usuario.ingresar(ingresar);
						msg = "Ingreso exitoso";
						RequestDispatcher rs = request.getRequestDispatcher("IngresarUsuario.jsp");
						request.setAttribute("msg", msg);
						rs.forward(request, response);
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					msg = "Error en el ingreso, datos inv�lidos";
					RequestDispatcher rs = request.getRequestDispatcher("IngresarUsuario.jsp");
					request.setAttribute("msg", msg);
					rs.forward(request, response);
				}
				
			}
		//}catch(NullPointerException e){
		//	e.printStackTrace();
		//}
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
