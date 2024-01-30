package entitiesDAO;

import java.util.List;


import jakarta.persistence.EntityManager;

public class EnvoiceDetailsDAO {
	private EntityManager em;

	public EnvoiceDetailsDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void insertEnvoiceDetailsDAO(EnvoiceDetailsDAO envoiceDetails) {
		em.getTransaction().begin();
		try {
			em.persist(envoiceDetails);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}


	public void insertEnvoiceDetailsDAOList(List<EnvoiceDetailsDAO> envoiceDetails) {
		em.getTransaction().begin();
		try {

			for (EnvoiceDetailsDAO envoice : envoiceDetails) {
				em.persist(envoice);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public List<EnvoiceDetailsDAO> selectEnvoiceDetailsDAO() {
		return em.createQuery("from EnvoiceDetailsDAO", EnvoiceDetailsDAO.class).getResultList();
	}
}
