package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
@ViewScoped
public class NotaFiscalBean {
	private Item item = new Item();
	private NotaFiscal notaFiscal = new NotaFiscal();
	private Long idProduto;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public void guardaItem() {
		DAO<Produto> dao = new DAO<Produto>(Produto.class);

		Produto produto = dao.buscaPorId(idProduto);
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());

		notaFiscal.adicionarItem(item);
		item.setNotaFiscal(notaFiscal);

		item = new Item();
	}
	
	public void gravar() {
		DAO<NotaFiscal> dao = new DAO<>(NotaFiscal.class);
		dao.adiciona(notaFiscal);
		this.notaFiscal = new NotaFiscal();
		this.item = new Item();
	}

	public void tiraItem(Item i) {
		notaFiscal.removerItem(item);
	}
	
	public Double getValorTotalNotaFiscal() {
		return notaFiscal.getValorTotalNotaFiscal();
	}

}
