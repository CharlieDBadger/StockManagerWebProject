package entitiesDAO;

import java.util.List;

import entities.Envoice;
import entities.Receipt;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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
}