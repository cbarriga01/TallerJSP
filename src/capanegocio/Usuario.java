package capanegocio;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import taller.servlet.TallerServlet;

public class Usuario {
	
	public Usuario() {
	}
	
	private int idusuario;
	private String user;
	private String password;
	
	public int getIdusuario() {
		return idusuario;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * M�todo que permite ingresar un usuario de la BD
	 * @param usuario
	 * @return
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
					lormUsuario.setUser(usuario.getUser());
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
	 * M�todo que permite actualizar un usuario de la BD
	 * @param usuario
	 * @return
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
					lormUsuario.setUser(usuario.getUser());
				}catch (NullPointerException e){
					e.printStackTrace();
				}
				try{
					lormUsuario.setPassword(usuario.getUser());
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
	 * M�todo que permite eliminar un usuario de la BD
	 * @param usuario
	 * @return
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
	 * M�todo que permite listar los usuarios almacenados en la BD
	 * @return
	 * @throws PersistentException
	 */
	public static List <Usuario> listar() throws PersistentException {
		
		List <orm.Usuario> listaUsuarioOrm = orm.UsuarioDAO.queryUsuario(null, null);
		List <Usuario> listaUsuario = new ArrayList<>();
		
		for (orm.Usuario usuarioOrm:listaUsuarioOrm) {
			Usuario usuario= new Usuario();
			usuario.setUser(usuarioOrm.getUser());
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
			usuario.setUser(usuarioOrm.getUser());
			usuario.setPassword(usuarioOrm.getPassword());
			listaUsuario.add(usuario);
		}
		
		return listaUsuario;
	}

	public static Usuario busquedaUsuario(Usuario usuarioRec) throws PersistentException {
		Usuario usuario=new Usuario();
		try{
		orm.Usuario usuarioOrm = orm.UsuarioDAO.loadUsuarioByQuery("Usuario.user='"+usuarioRec.getUser()+"'AND Usuario.password='"+usuarioRec.getPassword()+"'", null);
		
			usuario.setUser(usuarioOrm.getUser());
			usuario.setPassword(usuarioOrm.getPassword());
		
		System.out.println(" record(s) retrieved.");
		return usuario;
		}catch(NullPointerException e){
			e.printStackTrace();
			
			return usuario;
		}
	}

}
