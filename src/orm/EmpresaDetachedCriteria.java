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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class EmpresaDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public EmpresaDetachedCriteria() {
		super(orm.Empresa.class, orm.EmpresaCriteria.class);
		idEmpresa = new IntegerExpression("idEmpresa", this.getDetachedCriteria());
		rut = new StringExpression("rut", this.getDetachedCriteria());
		razonSocial = new StringExpression("razonSocial", this.getDetachedCriteria());
		nombreEmpresa = new StringExpression("nombreEmpresa", this.getDetachedCriteria());
		representante = new StringExpression("representante", this.getDetachedCriteria());
		mailEmpresa = new StringExpression("mailEmpresa", this.getDetachedCriteria());
		telefonoEmpresa = new StringExpression("telefonoEmpresa", this.getDetachedCriteria());
		paisEmpresa = new StringExpression("paisEmpresa", this.getDetachedCriteria());
		regionEmpresa = new StringExpression("regionEmpresa", this.getDetachedCriteria());
		ciudadEmpresa = new StringExpression("ciudadEmpresa", this.getDetachedCriteria());
		domicilio = new StringExpression("domicilio", this.getDetachedCriteria());
		contacto = new CollectionExpression("ORM_Contacto", this.getDetachedCriteria());
	}
	
	public EmpresaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.EmpresaCriteria.class);
		idEmpresa = new IntegerExpression("idEmpresa", this.getDetachedCriteria());
		rut = new StringExpression("rut", this.getDetachedCriteria());
		razonSocial = new StringExpression("razonSocial", this.getDetachedCriteria());
		nombreEmpresa = new StringExpression("nombreEmpresa", this.getDetachedCriteria());
		representante = new StringExpression("representante", this.getDetachedCriteria());
		mailEmpresa = new StringExpression("mailEmpresa", this.getDetachedCriteria());
		telefonoEmpresa = new StringExpression("telefonoEmpresa", this.getDetachedCriteria());
		paisEmpresa = new StringExpression("paisEmpresa", this.getDetachedCriteria());
		regionEmpresa = new StringExpression("regionEmpresa", this.getDetachedCriteria());
		ciudadEmpresa = new StringExpression("ciudadEmpresa", this.getDetachedCriteria());
		domicilio = new StringExpression("domicilio", this.getDetachedCriteria());
		contacto = new CollectionExpression("ORM_Contacto", this.getDetachedCriteria());
	}
	
	public ContactoDetachedCriteria createContactoCriteria() {
		return new ContactoDetachedCriteria(createCriteria("ORM_Contacto"));
	}
	
	public Empresa uniqueEmpresa(PersistentSession session) {
		return (Empresa) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Empresa[] listEmpresa(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Empresa[]) list.toArray(new Empresa[list.size()]);
	}
}

