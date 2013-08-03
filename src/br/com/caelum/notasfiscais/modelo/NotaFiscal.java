package br.com.caelum.notasfiscais.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class NotaFiscal {

	@Id
	@GeneratedValue
	private Long id;

	private String cnpj;

	@Temporal(TemporalType.DATE)
	private Calendar data = Calendar.getInstance();

	// mappedBy="notaFiscal" -> nome da coluna na outra classe
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "notaFiscal")
	private List<Item> itens = new ArrayList<Item>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public boolean adicionarItem(Item item) {
		return this.itens.add(item);
	}

	public boolean removerItem(Item item) {
		return this.itens.remove(item);
	}

	public Double getValorTotalNotaFiscal() {
		Double resultado = 0d;

		for (Item item : itens)
			if (item.getTotal() != null)
				resultado += item.getTotal();

		return resultado;
	}

}
