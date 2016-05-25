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

public class BitacoraDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idBitacora;
	public final StringExpression titulo;
	public final StringExpression texto;
	public final IntegerExpression idContactoId;
	public final AssociationExpression idContacto;
	
	public BitacoraDetachedCriteria() {
		super(orm.Bitacora.class, orm.BitacoraCriteria.class);
		idBitacora = new IntegerExpression("idBitacora", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		texto = new StringExpression("texto", this.getDetachedCriteria());
		idContactoId = new IntegerExpression("idContacto.idContacto", this.getDetachedCriteria());
		idContacto = new AssociationExpression("idContacto", this.getDetachedCriteria());
	}
	
	public BitacoraDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.BitacoraCriteria.class);
		idBitacora = new IntegerExpression("idBitacora", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		texto = new StringExpression("texto", this.getDetachedCriteria());
		idContactoId = new IntegerExpression("idContacto.idContacto", this.getDetachedCriteria());
		idContacto = new AssociationExpression("idContacto", this.getDetachedCriteria());
	}
	
	public ContactoDetachedCriteria createIdContactoCriteria() {
		return new ContactoDetachedCriteria(createCriteria("idContacto"));
	}
	
	public Bitacora uniqueBitacora(PersistentSession session) {
		return (Bitacora) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Bitacora[] listBitacora(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Bitacora[]) list.toArray(new Bitacora[list.size()]);
	}
}

