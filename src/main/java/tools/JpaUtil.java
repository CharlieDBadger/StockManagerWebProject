package tools;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	private static EntityManager em;

	public static EntityManager getEM(String persistenceUnit) {
		if (em == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
			em = emf.createEntityManager();
		}
		return em;
	}
}