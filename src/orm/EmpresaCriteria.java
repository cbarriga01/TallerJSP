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

public class EmpresaCriteria extends AbstractORMCriteria {
	public final IntegerExpression idEmpresa;
	public final StringExpression rut;
	public final StringExpression razonSocial;
	public final StringExpression nombreEmpresa;
	public final StringExpression representante;
	public final StringExpression mailEmpresa;
	public final StringExpression telefonoEmpresa;
	public final StringExpression paisEmpresa;
	public final StringExpression regionEmpresa;
	public final StringExpression ciudadEmpresa;
	public final StringExpression domicilio;
	public final CollectionExpression contacto;
	
	public EmpresaCriteria(Criteria criteria) {
		super(criteria);
		idEmpresa = new IntegerExpression("idEmpresa", this);
		rut = new StringExpression("rut", this);
		razonSocial = new StringExpression("razonSocial", this);
		nombreEmpresa = new StringExpression("nombreEmpresa", this);
		representante = new StringExpression("representante", this);
		mailEmpresa = new StringExpression("mailEmpresa", this);
		telefonoEmpresa = new StringExpression("telefonoEmpresa", this);
		paisEmpresa = new StringExpression("paisEmpresa", this);
		regionEmpresa = new StringExpression("regionEmpresa", this);
		ciudadEmpresa = new StringExpression("ciudadEmpresa", this);
		domicilio = new StringExpression("domicilio", this);
		contacto = new CollectionExpression("ORM_Contacto", this);
	}
	
	public EmpresaCriteria(PersistentSession session) {
		this(session.createCriteria(Empresa.class));
	}
	
	public EmpresaCriteria() throws PersistentException {
		this(orm.Taller1MagisterInformaticaPersistentManager.instance().getSession());
	}
	
	public ContactoCriteria createContactoCriteria() {
		return new ContactoCriteria(createCriteria("ORM_Contacto"));
	}
	
	public Empresa uniqueEmpresa() {
		return (Empresa) super.uniqueResult();
	}
	
	public Empresa[] listEmpresa() {
		java.util.List list = super.list();
		return (Empresa[]) list.toArray(new Empresa[list.size()]);
	}
}

