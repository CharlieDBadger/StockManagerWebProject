package entitiesDAO;

import java.util.List;

import jakarta.persistence.EntityManager;

public class StockMovDAO {
	private EntityManager em;

	public StockMovDAO(EntityManager em) {
		super();
		this.em = em;
	}



	public void insertReceiptDetailsDAO(ReceiptDetailsDAO receiptDetails) {
		em.getTransaction().begin();
		try {
			em.persist(receiptDetails);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public void insertReceiptDetailsDAODAOList(List<ReceiptDetailsDAO> receiptDetails) {
		em.getTransaction().begin();
		try {

			for (ReceiptDetailsDAO receipt : receiptDetails) {
				em.persist(receipt);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public List<ReceiptDetailsDAO> selectReceiptDetailsDAO() {
		return em.createQuery("from ReceiptDetailsDAO", ReceiptDetailsDAO.class).getResultList();
	}
}
