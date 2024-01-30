package entitiesDAO;

import java.util.List;

import entities.Envoice;
import entities.Receipt;
import entities.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class EnvoiceDAO {
	private EntityManager em;

	
	
	public EnvoiceDAO(EntityManager em) {
		super();
		this.em = em;
	}


	public void insertEnvoice(Envoice envoice) {
		em.getTransaction().begin();
		try {
			em.persist(envoice);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}


	public void insertEnvoiceList(List<Receipt> envoices) {
		em.getTransaction().begin();
		try {

			for (Receipt envoice : envoices) {
				em.persist(envoice);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public List<Envoice> selectEnvoice() {
		return em.createQuery("from Envoice", Envoice.class).getResultList();
	}
	
	public List<Envoice> getEnvoiceByCode(String envoiceCode) {
		List<Envoice> envoice;

		Query query = em.createQuery("from Envoice ue where ue.envoiceCode=?1", Envoice.class);

		query.setParameter(1, envoiceCode);
		envoice = query.getResultList();

		return envoice;
	}

	public void deleteEnvoiceById(long id) {
		try {
			Envoice search = em.find(Envoice.class, id);
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

	public void deleteEnvoiceByCode(String envoiceCode) {
		em.getTransaction().begin();
		try {
			List <Envoice> envoiceList = getEnvoiceByCode(envoiceCode);

			for (Envoice envoice : envoiceList) {
				em.remove(envoice);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
}
