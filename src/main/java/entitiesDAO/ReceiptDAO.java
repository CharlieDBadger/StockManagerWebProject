package entitiesDAO;

import java.util.List;

import entities.Receipt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class ReceiptDAO {
	private EntityManager em;

	public ReceiptDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertReceipt(Receipt receipt) {
		em.getTransaction().begin();
		try {
			em.persist(receipt);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public void insertReceiptList(List<Receipt> receipts) {
		em.getTransaction().begin();
		try {

			for (Receipt receipt : receipts) {
				em.persist(receipt);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public List<Receipt> selectReceipt() {
		return em.createQuery("from Receipt", Receipt.class).getResultList();
	}

	public List<Receipt> getReceiptByCode(String receiptCode) {
		List<Receipt> receipt;

		Query query = em.createQuery("from Receipt ue where ue.receiptCode=?1", Receipt.class);

		query.setParameter(1, receiptCode);
		receipt = query.getResultList();

		return receipt;
	}

	public void deleteReceiptById(long id) {
		try {
			Receipt search = em.find(Receipt.class, id);
			em.getTransaction().begin();
			em.remove(search);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void deleteReceiptByCode(String receiptCode) {
		em.getTransaction().begin();
		try {
			List<Receipt> receiptList = getReceiptByCode(receiptCode);

			for (Receipt receipt : receiptList) {
				em.remove(receipt);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	/**
	 * 
	 * @param envoiceModifiedId
	 * @param envoiceModified
	 * @param em
	 * @return 
	 */
	public void updateReceipt(long receiptModifiedId, Receipt receiptModified, EntityManager em) {

		TypedQuery<Receipt> query = em.createQuery("from Receipt where id=?1", Receipt.class);
		query.setParameter(1, receiptModifiedId);

		try {
			Receipt updatedReceipt = query.getSingleResult();
			em.getTransaction().begin();
			
			updatedReceipt.setReceiptDetails(receiptModified.getReceiptDetails());
			updatedReceipt.setObservation(receiptModified.getObservation());

			em.merge(updatedReceipt);

			em.getTransaction().commit();
		} catch (NoResultException nre) {
			System.out.println("Receipt NOT found.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}