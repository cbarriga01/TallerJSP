/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateTaller1MagisterInformaticaData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.createContacto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : bitacora, idEmpresa, direccion, ciudadContacto, regionContacto, paisContacto, telefonoContacto, mailContacto, apellidoContacto, nombreContacto, run
			orm.ContactoDAO.save(lormContacto);
			orm.Usuario lormUsuario = orm.UsuarioDAO.createUsuario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : password, usuario
			orm.UsuarioDAO.save(lormUsuario);
			orm.Empresa lormEmpresa = orm.EmpresaDAO.createEmpresa();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : contacto, domicilio, ciudadEmpresa, regionEmpresa, paisEmpresa, telefonoEmpresa, mailEmpresa, representante, nombreEmpresa, razonSocial, rut
			orm.EmpresaDAO.save(lormEmpresa);
			orm.Bitacora lormBitacora = orm.BitacoraDAO.createBitacora();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : idContacto, texto, titulo
			orm.BitacoraDAO.save(lormBitacora);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateTaller1MagisterInformaticaData createTaller1MagisterInformaticaData = new CreateTaller1MagisterInformaticaData();
			try {
				createTaller1MagisterInformaticaData.createTestData();
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
