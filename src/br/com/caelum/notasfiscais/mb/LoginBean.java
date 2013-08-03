package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		return this.usuario.getSenha() != null;
	}

	private void limparUsuario() {
		this.usuario = new Usuario();
	}

	public String efetuaLogin() {
		UsuarioDAO dao = new UsuarioDAO();

		if (dao.existe(usuario)) {
			return "produto";
		} else {
			String salvarLogin = this.usuario.getLogin();
			limparUsuario();
			this.usuario.setLogin(salvarLogin);

			return "login";
		}
	}

	public String efetuaLogoff() {
		limparUsuario();

		return "login";
	}
}
