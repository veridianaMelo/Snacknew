package lab.teste.business;


import lab.teste.entity.Usuario;
import lab.teste.persistence.UsuarioDAO;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import java.util.List;


@BusinessController
public class UsuarioBC extends DelegateCrud<Usuario, Integer, UsuarioDAO> {
	private static final long serialVersionUID = 1L;

	public List<Usuario> find(String filter) {
		return getDelegate().find(filter);
	}

}
