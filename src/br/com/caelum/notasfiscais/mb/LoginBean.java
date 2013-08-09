package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.PaginaUtil;
import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.modelo.UsuarioLogado;

//@ManagedBean // nao pode colocar pq tem o @Named
//@SessionScoped // nao vai funcionar com JSF, usar o @SessionScoped do CDI(weld)

// colocar o LoginBean no contexto do CDI
@Named
// esse é do Weld
// @SessionScoped
@RequestScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7744682344761402201L;

	private UsuarioDAO dao;
	private UsuarioLogado usuarioLogado;
	private Usuario usuario = new Usuario();

	// aqui ele dá um new no UsuarioDAO
	@Inject
	public LoginBean(UsuarioDAO dao, UsuarioLogado usuarioLogado) {
		this.dao = dao;
		this.usuarioLogado = usuarioLogado;
	}

	public LoginBean() {

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioLogado getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String efetuaLogin() {
		boolean loginValido = dao.existe(usuario);
		if (loginValido) {
			this.usuarioLogado.guardaUsuario(usuario);

			return PaginaUtil.PRODUTO;
		} else {
			return efetuaLogoff();
		}
	}

	public String efetuaLogoff() {
		System.out.println("logoff");
		this.usuarioLogado.efetuaLogoff();
		this.usuario = new Usuario();
		
		return login();
	}

	public String login() {
		return PaginaUtil.LOGIN;
	}
}

/**
 * deixa o carrinho de compras na session e o carrinho de compras bean em
 * request
 */

/**
 * da pra colocar o @SessionScoped, @Named, isLogado() no Usuario e dai criar
 * uma outra variavel de usuario
 */
