package br.com.caelum.notasfiscais.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ComecaComMaiuscula")
public class ComecaComMaiuscula implements Validator {
	public void validate(FacesContext fc, UIComponent component, Object value)
			throws ValidatorException {
		if (value == null) {
			throw new ValidatorException(new FacesMessage(
					"É necessário preencher o campo"));
		} else {
			String valor = value.toString();
			if (!valor.matches("[A-Z].*")) {
				throw new ValidatorException(new FacesMessage(
						"Deveria começar com letra maiúscula"));
			}
		}
	}
}
