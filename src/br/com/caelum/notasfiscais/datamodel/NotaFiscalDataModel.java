package br.com.caelum.notasfiscais.datamodel;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

public class NotaFiscalDataModel extends LazyDataModel<NotaFiscal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2561161792835611873L;

	@Override
	public List<NotaFiscal> load(int inicio, int quantidade, String campoDeOrdenacao, SortOrder ordem,
			Map<String, String> filtro) {

		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);

		return dao.listaTodosPaginada(inicio, quantidade);
	}

}
