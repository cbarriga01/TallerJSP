package capanegocio;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import taller.servlet.TallerServlet;

/**
 * 
 * @author César Barriga I.
 * 
 * Clase relacionada a la lógica de negocio de la aplicación referente a Usuarios
 * Se encarga de enviar transacciones a la Base de Datos
 *
 */
public class Usuario {
	
	public Usuario() {
	}
	
	private int idusuario;
	private String usuario;
	private String password;
	
	/**
	 * 
	 * @return int idusuario del usuario
	 */
	public int getIdusuario() {
		return idusuario;
	}
	
	/**
	 * 
	 * @return String user del usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * 
	 * @return String password del usuario
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @param int idusuario del usuario
	 */
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
	/**
	 * 
	 * @param String user del usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * 
	 * @param String password del usuario
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Método que permite ingresar un usuario de la BD
	 * @param Usuario usuario, objeto que contiene los datos a ingresar
	 * @return String msg, mensaje que informa el estado de la transacción
	 * @throws PersistentException
	 */
	public static String ingresar(Usuario usuario) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "Ingreso fallido de usuario";
		//try{
			try {
				orm.Usuario lormUsuario = orm.UsuarioDAO.createUsuario();
				// Initialize the properties of the persistent object here
				try{
					lormUsuario.setUsuario(usuario.getUsuario());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormUsuario.setPassword(usuario.getPassword());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				
				orm.UsuarioDAO.save(lormUsuario);
				t.commit();
				msg = "Ingreso exitoso de empresa";
			}
			catch (Exception e) {
				t.rollback();
			}
		//} catch (NullPointerException e){
		//	e.printStackTrace();
		//}
		return msg;		
	}
	
	/**
	 * Método que permite actualizar un usuario de la Base de Datos
	 * @param Usuario usuario, objeto que contiene los datos a actualizar
	 * @return String msg, mensaje que informa el estado de la transacción
	 * @throws PersistentException
	 */
	public static String actualizar(Usuario usuario) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		//try{
			try {
				orm.Usuario lormUsuario = orm.UsuarioDAO.loadUsuarioByORMID(usuario.getIdusuario());  //orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='victor'", null);
				// Update the properties of the persistent object
				try{
					lormUsuario.setUsuario(usuario.getUsuario());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormUsuario.setPassword(usuario.getUsuario());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				msg = "Ingreso Exitoso";
				orm.UsuarioDAO.save(lormUsuario);
				t.commit();
			}
			catch (Exception e) {
				t.rollback();
			}
		//} catch (NullPointerException e){
		//	e.printStackTrace();
		//}
		return msg;
		
	}
	
	/**
	 * Método que permite eliminar un usuario de la Base de Datos
	 * @param Usuario usuario, objeto que contiene los datos a eliminar
	 * @return String msg, mensaje que informa el estado de la transacción
	 * @throws PersistentException
	 */
	public static String borrar(Usuario usuario) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg = "";
		try{
			try {
				orm.Usuario lormUsario = orm.UsuarioDAO.loadUsuarioByORMID(usuario.getIdusuario());
				// Delete the persistent object<
				msg="Dato eliminado...";
				orm.UsuarioDAO.delete(lormUsario);
				t.commit();
			}
			catch (Exception e) {
				t.rollback();
			}
		} catch (NullPointerException e){
			e.printStackTrace();
		}
		return msg;
	}
	
	/**
	 * Método que permite listar los usuarios almacenados en la Base de Datos
	 * @return List <Usuario> listaUsuario, lista con los datos de usuario almacenados
	 * @throws PersistentException
	 */
	public static List <Usuario> listar() throws PersistentException {
		
		List <orm.Usuario> listaUsuarioOrm = orm.UsuarioDAO.queryUsuario(null, null);
		List <Usuario> listaUsuario = new ArrayList<>();
		
		for (orm.Usuario usuarioOrm:listaUsuarioOrm) {
			Usuario usuario= new Usuario();
			usuario.setUsuario(usuarioOrm.getUsuario());
			usuario.setPassword(usuarioOrm.getPassword());
			listaUsuario.add(usuario);
		}
		
		return listaUsuario;
	}
	
	public static List <Usuario> buscarUsuario() throws PersistentException {
		Usuario usuario = new Usuario();
		List <orm.Usuario> listaUsuarioOrm = orm.UsuarioDAO.queryUsuario("Usuario.user='"+usuario.getUser()+"'& Usuario.password='"+usuario.getPassword()+"'", null);
		List <Usuario> listaUsuario = new ArrayList<>();
		
		for (orm.Usuario usuarioOrm:listaUsuarioOrm) {
			//Usuario usuario= new Usuario();
			usuario.setUsuario(usuarioOrm.getUsuario());
			usuario.setPassword(usuarioOrm.getPassword());
			listaUsuario.add(usuario);
		}
		
		return listaUsuario;
	}

	public static Usuario busquedaUsuario(Usuario usuarioRec) throws PersistentException {
		Usuario usuario=new Usuario();
		try{
		orm.Usuario usuarioOrm = orm.UsuarioDAO.loadUsuarioByQuery("Usuario.user='"+usuarioRec.getUser()+"'AND Usuario.password='"+usuarioRec.getPassword()+"'", null);
		
			usuario.setUsuario(usuarioOrm.getUsuario());
			usuario.setPassword(usuarioOrm.getPassword());
		
		System.out.println(" record(s) retrieved.");
		return usuario;
		}catch(NullPointerException e){
			e.printStackTrace();
			
			return usuario;
		}
	}

}
