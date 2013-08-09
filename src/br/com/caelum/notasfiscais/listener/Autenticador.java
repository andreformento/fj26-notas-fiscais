package br.com.caelum.notasfiscais.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.caelum.notasfiscais.mb.LoginBean;

public class Autenticador implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6698103745880203985L;

	@Override
	public void beforePhase(PhaseEvent phaseEvent) {

	}

	@Override
	public void afterPhase(PhaseEvent phaseEvent) {
		FacesContext contexto = phaseEvent.getFacesContext();

		/*
		 * Pode ser esse aqui pra redirecionar. Usa servlet e por isso precisa
		 * da url.
		 */
		// contexto.getCurrentInstance().getExternalContext().redirect("pagina");

		String urlPaginaAtual = contexto.getViewRoot().getViewId();
		if ("/login.xhtml".equals(urlPaginaAtual)) {
			return;
		} else {
			LoginBean loginBean = contexto.getApplication()
					.evaluateExpressionGet(contexto, "#{loginBean}",
							LoginBean.class);
			System.out.println("vai para a pagina de login? "
					+ !loginBean.getUsuarioLogado().isLogado());
			if (!loginBean.getUsuarioLogado().isLogado()) {
				NavigationHandler navigationHandler = contexto.getApplication()
						.getNavigationHandler();
				navigationHandler.handleNavigation(contexto, null,
						"login?faces-redirect=true");

				contexto.renderResponse();
			}
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
