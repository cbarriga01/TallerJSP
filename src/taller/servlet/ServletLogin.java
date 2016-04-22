package taller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

import capanegocio.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Metodo utilizado para desloguear
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//me llega la url "proyecto/login/out"
        // String action=(request.getPathInfo()!=null?request.getPathInfo():"");
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("user")!= null){
            sesion.invalidate();
            response.sendRedirect("FormularioLogin.jsp");
        }
		
		//me llega la url "TallerJSP/login/out"
        /*String action=(request.getPathInfo()!=null?request.getPathInfo():"");
        HttpSession sesion = request.getSession();
        if(action.equals("/out")){
            sesion.invalidate();
            response.sendRedirect("/FormularioIngreso.jsp");
        }else{
        	
        }*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Metodo encargado de logear
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion = request.getSession();
        String usu, pass;
        usu = request.getParameter("user");
        pass = request.getParameter("password");
        Usuario usuario=new Usuario();
        usuario.setUser(usu);
        usuario.setPassword(pass);
        
        try {
			usuario=Usuario.busquedaUsuario(usuario);
			if(!usuario.getUser().equals("")){
	        	sesion.setAttribute("user", "password");
	        	response.sendRedirect("FormularioIngreso.jsp");
	        }else{
	        	response.sendRedirect("LoginFallido.jsp");
	        }
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
		
		/*
		HttpSession sesion = request.getSession();
        String user, password;
        user = request.getParameter("user");
        password = request.getParameter("password");*/
        //deber�amos buscar el usuario en la base de datos, pero dado que se escapa de este tema, ponemos un ejemplo en el mismo c�digo
        //if(user.equals("admin") && password.equals("admin")/* && sesion.getAttribute("usuario") == null*/){
            //si coincide usuario y password y adem�s no hay sesi�n iniciada
            //sesion.setAttribute("usuario", user);
            //redirijo a p�gina con informaci�n de login exitoso
            //response.sendRedirect("LoginExito.jsp");
        //}else{
        	//response.sendRedirect("LoginFallido.jsp");
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
