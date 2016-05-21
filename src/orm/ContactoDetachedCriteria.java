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

public class ContactoDetachedCriteria extends AbstractORMDetachedCriteria {
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
	public final StringExpression imagen;
	public final IntegerExpression idEmpresaId;
	public final AssociationExpression idEmpresa;
	
	public ContactoDetachedCriteria() {
		super(orm.Contacto.class, orm.ContactoCriteria.class);
		idContacto = new IntegerExpression("idContacto", this.getDetachedCriteria());
		run = new StringExpression("run", this.getDetachedCriteria());
		nombreContacto = new StringExpression("nombreContacto", this.getDetachedCriteria());
		apellidoContacto = new StringExpression("apellidoContacto", this.getDetachedCriteria());
		mailContacto = new StringExpression("mailContacto", this.getDetachedCriteria());
		telefonoContacto = new StringExpression("telefonoContacto", this.getDetachedCriteria());
		paisContacto = new StringExpression("paisContacto", this.getDetachedCriteria());
		regionContacto = new StringExpression("regionContacto", this.getDetachedCriteria());
		ciudadContacto = new StringExpression("ciudadContacto", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		imagen = new StringExpression("imagen", this.getDetachedCriteria());
		idEmpresaId = new IntegerExpression("idEmpresa.idEmpresa", this.getDetachedCriteria());
		idEmpresa = new AssociationExpression("idEmpresa", this.getDetachedCriteria());
	}
	
	public ContactoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.ContactoCriteria.class);
		idContacto = new IntegerExpression("idContacto", this.getDetachedCriteria());
		run = new StringExpression("run", this.getDetachedCriteria());
		nombreContacto = new StringExpression("nombreContacto", this.getDetachedCriteria());
		apellidoContacto = new StringExpression("apellidoContacto", this.getDetachedCriteria());
		mailContacto = new StringExpression("mailContacto", this.getDetachedCriteria());
		telefonoContacto = new StringExpression("telefonoContacto", this.getDetachedCriteria());
		paisContacto = new StringExpression("paisContacto", this.getDetachedCriteria());
		regionContacto = new StringExpression("regionContacto", this.getDetachedCriteria());
		ciudadContacto = new StringExpression("ciudadContacto", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		imagen = new StringExpression("imagen", this.getDetachedCriteria());
		idEmpresaId = new IntegerExpression("idEmpresa.idEmpresa", this.getDetachedCriteria());
		idEmpresa = new AssociationExpression("idEmpresa", this.getDetachedCriteria());
	}
	
	public EmpresaDetachedCriteria createIdEmpresaCriteria() {
		return new EmpresaDetachedCriteria(createCriteria("idEmpresa"));
	}
	
	public Contacto uniqueContacto(PersistentSession session) {
		return (Contacto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Contacto[] listContacto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Contacto[]) list.toArray(new Contacto[list.size()]);
	}
}

