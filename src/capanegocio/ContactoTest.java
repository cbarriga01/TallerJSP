/**
 * 
 */
package capanegocio;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Kal-El
 *
 */
public class ContactoTest {

	/**
	 * Test method for {@link capanegocio.Contacto#ingresar(capanegocio.Contacto)}.
	 */
	@Test
	public void testIngresar() {
		Contacto contacto = new Contacto();
		contacto.setNombre("Cesar");
		contacto.setApellido("Barriga");
		contacto.setMail("cesar@cesar.com");
		contacto.setTelefono("888888");
		contacto.setPais("Chile");
		contacto.setRegion("IX");
		contacto.setCiudad("Temuco");
		
		assertTrue(contacto.getNombre().equals("Cesar"));
		assertTrue(contacto.getApellido().equals("Barriga"));
		assertTrue(contacto.getMail().equals("cesar@cesar.com"));
		assertTrue(contacto.getTelefono().equals("888888"));
		assertTrue(contacto.getPais().equals("Chile"));
		assertTrue(contacto.getRegion().equals("IX"));
		assertTrue(contacto.getCiudad().equals("Temuco"));
	}

	/**
	 * Test method for {@link capanegocio.Contacto#actualizar(capanegocio.Contacto)}.
	 */
	@Test
	public void testActualizar() {
		Contacto contacto = new Contacto();
		contacto.setUid(12);
		contacto.setNombre("Cesar");
		contacto.setApellido("Barriga");
		contacto.setMail("cesar@cesar.com");
		contacto.setTelefono("888888");
		contacto.setPais("Chile");
		contacto.setRegion("IX");
		contacto.setCiudad("Temuco");
		
		assertTrue(contacto.getUid()==12);
		assertTrue(contacto.getNombre().equals("Cesar"));
		assertTrue(contacto.getApellido().equals("Barriga"));
		assertTrue(contacto.getMail().equals("cesar@cesar.com"));
		assertTrue(contacto.getTelefono().equals("888888"));
		assertTrue(contacto.getPais().equals("Chile"));
		assertTrue(contacto.getRegion().equals("IX"));
		assertTrue(contacto.getCiudad().equals("Temuco"));
	}

	/**
	 * Test method for {@link capanegocio.Contacto#borrar(capanegocio.Contacto)}.
	 */
	@Test
	public void testBorrar() {
		Contacto contacto = new Contacto();
		contacto.setUid(12);
		assertTrue(contacto.getUid()==12);
	}

	/**
	 * Test method for {@link capanegocio.Contacto#listar()}.
	 */
	@Test
	public void testListar() {
		fail("Not yet implemented");
	}

}
