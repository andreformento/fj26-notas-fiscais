package br.com.caelum.notasfiscais.modelo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class UsuarioLogado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2193564949761183189L;

	private Usuario usuario;

	public void guardaUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		System.out.println("usuario = " + this.usuario);
		return this.usuario != null;
	}

	public boolean getLogado() {
		return isLogado();
	}

	public void efetuaLogoff() {
		this.usuario = null;
	}

}
