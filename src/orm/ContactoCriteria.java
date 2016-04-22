/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ContactoCriteria extends AbstractORMCriteria {
	public final IntegerExpression idContacto;
	public final StringExpression run;
	public final StringExpression nombreContacto;
	public final StringExpression apellidoContacto;
	public final StringExpression mailContacto;
	public final StringExpression telefonoContacto;
	public final StringExpression paisContacto;
	public final StringExpression regionContacto;
	public final StringExpression ciudadContacto;
	public final StringExpression direccion;
	public final IntegerExpression idEmpresaId;
	public final AssociationExpression idEmpresa;
	
	public ContactoCriteria(Criteria criteria) {
		super(criteria);
		idContacto = new IntegerExpression("idContacto", this);
		run = new StringExpression("run", this);
		nombreContacto = new StringExpression("nombreContacto", this);
		apellidoContacto = new StringExpression("apellidoContacto", this);
		mailContacto = new StringExpression("mailContacto", this);
		telefonoContacto = new StringExpression("telefonoContacto", this);
		paisContacto = new StringExpression("paisContacto", this);
		regionContacto = new StringExpression("regionContacto", this);
		ciudadContacto = new StringExpression("ciudadContacto", this);
		direccion = new StringExpression("direccion", this);
		idEmpresaId = new IntegerExpression("idEmpresa.idEmpresa", this);
		idEmpresa = new AssociationExpression("idEmpresa", this);
	}
	
	public ContactoCriteria(PersistentSession session) {
		this(session.createCriteria(Contacto.class));
	}
	
	public ContactoCriteria() throws PersistentException {
		this(orm.Taller1MagisterInformaticaPersistentManager.instance().getSession());
	}
	
	public EmpresaCriteria createIdEmpresaCriteria() {
		return new EmpresaCriteria(createCriteria("idEmpresa"));
	}
	
	public Contacto uniqueContacto() {
		return (Contacto) super.uniqueResult();
	}
	
	public Contacto[] listContacto() {
		java.util.List list = super.list();
		return (Contacto[]) list.toArray(new Contacto[list.size()]);
	}
}

