package br.com.caelum.notasfiscais.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.caelum.stella.format.CNPJFormatter;

@FacesConverter("cnpj")
public class ConverterCNPJ implements Converter {

	// vem da view, vai pro banco
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String stringDaView) {
		return new CNPJFormatter().unformat(stringDaView);
	}

	// vem do banco, vai pra view
	@Override
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object objectDoBanco) {
		if (objectDoBanco == null)
			return null;
		else
			return new CNPJFormatter().format(objectDoBanco.toString());
	}

}
