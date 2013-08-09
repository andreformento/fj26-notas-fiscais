package br.com.caelum.notasfiscais.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("notas");

	// aqui fala que é um método produtor
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(@Disposes EntityManager entityManager) {
		entityManager.close();
	}

}
