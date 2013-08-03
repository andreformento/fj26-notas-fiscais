package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6965312367315153181L;

	private Produto produto = new Produto();
	private List<Produto> produtos;

	private Double resultado;

	private DAO<Produto> getDAO() {
		return new DAO<>(Produto.class);
	}
	
	public Produto getNovoProduto() {
		return new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String grava() {
		getDAO().adiciona(produto);
		produto = new Produto();
		produtos = null;

		return "produto?faces-redirect=true";
	}

	public String atualiza() {
		getDAO().atualiza(produto);
		produto = new Produto();
		produtos = null;

		return "produto?faces-redirect=true";
	}

	public List<Produto> getProdutos() {
		if (produtos == null) {
			produtos = getDAO().listaTodos();
			resultado = null;
		}
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Double getPrecoTotal() {
		if (resultado == null) {
			resultado = 0d;

			for (Produto p : getProdutos()) {
				if (p.getPreco() != null)
					resultado += p.getPreco();
			}
		}

		return resultado;
	}

	public void remove(Produto p) {
		getDAO().remove(p);
		this.produtos = null;
	}

}
