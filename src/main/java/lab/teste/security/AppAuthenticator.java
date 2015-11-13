package lab.teste.security;

import java.security.Principal;

import br.gov.frameworkdemoiselle.security.Credentials;
import br.gov.frameworkdemoiselle.security.InvalidCredentialsException;
import br.gov.frameworkdemoiselle.security.TokenAuthenticator;
import br.gov.frameworkdemoiselle.util.Beans;
import lab.teste.entity.Usuario;
import lab.teste.persistence.UsuarioDAO;

public class AppAuthenticator extends TokenAuthenticator {

	private static final long serialVersionUID = 1L;

	@Override
	protected Principal customAuthentication() throws Exception {
		Principal user = null;
		final Usuario credentials = Beans.getReference(Usuario.class);
		final String email = credentials.getEmail();
		final String senha = credentials.getSenha();
		 UsuarioDAO usuario = new UsuarioDAO();
		
		 boolean resposta=usuario.validaLogin(email, senha);
				 
		if (resposta == true) {
			user = new Principal() {

				@Override
				public String getName() {
					return email;
				}
			};

		} else {
			throw new InvalidCredentialsException();
		}

		return user;
	}
}
