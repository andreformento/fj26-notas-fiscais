package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.datamodel.NotaFiscalDataModel;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@ManagedBean
public class ListaNotasFiscaisBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6308362025670563843L;

	private LazyDataModel<NotaFiscal> dataModel;
	private List<NotaFiscal> notas;

	public ListaNotasFiscaisBean() {

	}

	public List<NotaFiscal> getNotas() {
		return notas;
	}

	public void limparLista() {
		notas = null;
	}

	public LazyDataModel<NotaFiscal> getDataModel() {
		if (dataModel == null) {
			this.dataModel = new NotaFiscalDataModel();

			DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);

			this.dataModel.setRowCount(dao.contaTodos());
		}

		return dataModel;
	}

}
