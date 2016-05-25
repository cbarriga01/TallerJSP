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

public class BitacoraCriteria extends AbstractORMCriteria {
	public final IntegerExpression idBitacora;
	public final StringExpression titulo;
	public final StringExpression texto;
	public final IntegerExpression idContactoId;
	public final AssociationExpression idContacto;
	
	public BitacoraCriteria(Criteria criteria) {
		super(criteria);
		idBitacora = new IntegerExpression("idBitacora", this);
		titulo = new StringExpression("titulo", this);
		texto = new StringExpression("texto", this);
		idContactoId = new IntegerExpression("idContacto.idContacto", this);
		idContacto = new AssociationExpression("idContacto", this);
	}
	
	public BitacoraCriteria(PersistentSession session) {
		this(session.createCriteria(Bitacora.class));
	}
	
	public BitacoraCriteria() throws PersistentException {
		this(orm.Taller1MagisterInformaticaPersistentManager.instance().getSession());
	}
	
	public ContactoCriteria createIdContactoCriteria() {
		return new ContactoCriteria(createCriteria("idContacto"));
	}
	
	public Bitacora uniqueBitacora() {
		return (Bitacora) super.uniqueResult();
	}
	
	public Bitacora[] listBitacora() {
		java.util.List list = super.list();
		return (Bitacora[]) list.toArray(new Bitacora[list.size()]);
	}
}

