package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6965312367315153181L;

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;

	private DAO<Usuario> getDAO() {
		return new DAO<Usuario>(Usuario.class);
	}

	public Usuario getNovoUsuario() {
		return new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String grava() {
		getDAO().adiciona(usuario);
		usuario = new Usuario();
		usuarios = null;

		return "usuario?faces-redirect=true";
	}

	public String atualiza() {
		getDAO().atualiza(usuario);
		usuario = new Usuario();
		usuarios = null;

		return "usuario?faces-redirect=true";
	}

	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			usuarios = getDAO().listaTodos();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void remove(Usuario u) {
		getDAO().remove(u);
		this.usuarios = null;
	}

}
