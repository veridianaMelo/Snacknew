package lab.teste.rest;

import java.security.Principal;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.gov.frameworkdemoiselle.security.Credentials;
import br.gov.frameworkdemoiselle.security.LoggedIn;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.util.Beans;
import br.gov.frameworkdemoiselle.util.ValidatePayload;
import lab.teste.entity.Usuario;

@Path("auth")
public class AuthREST {

	@Inject
	private SecurityContext securityContext;

	@POST
	@Path("login")
	@ValidatePayload
	@Consumes("application/json")
	@Produces("application/json")
	public Principal login(CredentialsBody body) {
		Usuario credentials = Beans.getReference(Usuario.class);
		credentials.setEmail(body.email);
		credentials.setSenha(body.senha);

		securityContext.login();
		return securityContext.getUser();
	}

	@POST
	@LoggedIn
	@Path("logout")
	@ValidatePayload
	public void logout() {
		securityContext.logout();
	}

	public static class CredentialsBody {

		@NotNull(message = "{required.field}")
		@Size(min = 1, message = "{required.field}")
		public String email;

		@NotNull(message = "{required.field}")
		@Size(min = 1, message = "{required.field}")
		public String senha;
	}
}
