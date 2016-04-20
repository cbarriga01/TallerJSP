/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateTaller1MagisterInformaticaData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByQuery(null, null);
			// Update the properties of the persistent object
			orm.ContactoDAO.save(lormContacto);
			orm.Usuario lormUsuario = orm.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Update the properties of the persistent object
			orm.UsuarioDAO.save(lormUsuario);
			orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByQuery(null, null);
			// Update the properties of the persistent object
			orm.EmpresaDAO.save(lormEmpresa);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Contacto by ContactoCriteria");
		orm.ContactoCriteria lormContactoCriteria = new orm.ContactoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormContactoCriteria.uid.eq();
		System.out.println(lormContactoCriteria.uniqueContacto());
		
		System.out.println("Retrieving Usuario by UsuarioCriteria");
		orm.UsuarioCriteria lormUsuarioCriteria = new orm.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormUsuarioCriteria.idusuario.eq();
		System.out.println(lormUsuarioCriteria.uniqueUsuario());
		
		System.out.println("Retrieving Empresa by EmpresaCriteria");
		orm.EmpresaCriteria lormEmpresaCriteria = new orm.EmpresaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormEmpresaCriteria.id.eq();
		System.out.println(lormEmpresaCriteria.uniqueEmpresa());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateTaller1MagisterInformaticaData retrieveAndUpdateTaller1MagisterInformaticaData = new RetrieveAndUpdateTaller1MagisterInformaticaData();
			try {
				retrieveAndUpdateTaller1MagisterInformaticaData.retrieveAndUpdateTestData();
				//retrieveAndUpdateTaller1MagisterInformaticaData.retrieveByCriteria();
			}
			finally {
				orm.Taller1MagisterInformaticaPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
