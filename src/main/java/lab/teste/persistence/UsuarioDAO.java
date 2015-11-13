
package lab.teste.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import lab.teste.entity.Usuario;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Integer> {

	private static final long serialVersionUID = 1L;

	public List<Usuario> find(String filter) {
		StringBuffer ql = new StringBuffer();
		ql.append("  from Usuario p ");
		// use where and or operator as filter
		// ql.append(" where lower(p.attribute) like :attribute ");
		// ql.append(" or lower(p.anotherAttribute) like :anotherAttribute ");
		// list of attributes

		// nome

		// email

		// senha

		// seat

		TypedQuery<Usuario> query = getEntityManager().createQuery(ql.toString(), Usuario.class);
		// use setParameter to fill attributes
		// query.setParameter("attribute", "%" + filter.toLowerCase() + "%");

		return query.getResultList();
	}

	public Boolean validaLogin(String login, String password) {

		StringBuffer user = new StringBuffer();

		user.append("  from Usuario p ");
		user.append(" where (p.email) like :email ");
		user.append("    and (p.senha) like :senha ");

		TypedQuery<Usuario> query = getEntityManager().createQuery(user.toString(), Usuario.class);
		query.setParameter("email", login);
		query.setParameter("senha", password);

		Usuario usuario;
		usuario = (Usuario) query.getSingleResult();
		if (usuario != query) {
			usuario = null;
		} 
			return (usuario != null);
		
	}
		
	

}
