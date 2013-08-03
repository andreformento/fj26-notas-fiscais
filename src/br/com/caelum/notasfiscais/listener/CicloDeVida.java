package br.com.caelum.notasfiscais.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class CicloDeVida implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5244584475005266908L;

	@Override
	public void beforePhase(PhaseEvent phaseEvent) {
		System.out.println("Antes: " + phaseEvent.getPhaseId());
	}

	@Override
	public void afterPhase(PhaseEvent phaseEvent) {
		System.out.println("Depois: " + phaseEvent.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
