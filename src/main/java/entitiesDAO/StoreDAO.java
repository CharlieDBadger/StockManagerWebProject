package entitiesDAO;

import java.util.List;

import entities.Address;
import entities.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class StoreDAO {

	private EntityManager em;

	// CONSTRUCTOR
	public StoreDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertStore(Store store) {
		em.getTransaction().begin();
		try {
			em.persist(store);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public void insertStoreList(List<Store> stores) {
		em.getTransaction().begin();
		try {

			for (Store store : stores) {
				em.persist(store);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public List<Store> selectStore() {
		return em.createQuery("from Store", Store.class).getResultList();
	}

	public List<Store> getStoreByName(String storeName) {
		List<Store> stores;

		Query query = em.createQuery("from Store ue where ue.name=?1", Store.class);

		query.setParameter(1, storeName);
		stores = query.getResultList();

		return stores;
	}

	public void deleteStoreById(long id) {
		try {
			Store search = em.find(Store.class, id);
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

	public void deleteStoreByName(String storeName) {
		em.getTransaction().begin();
		try {
			List<Store> storeList = getStoreByName(storeName);

			for (Store store : storeList) {
				em.remove(store);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	/**
	 * 
	 * @param customerModifiedId
	 * @param customerModified
	 * @param addressModified
	 * @param em
	 * @param parameters         This method receives the Customer object from the
	 *                           Servlet with the values collected in the HTML form.
	 * 
	 */
	public void updateStore(long storeModifiedId, Store storeModified, Address addressModified, EntityManager em) {

		TypedQuery<Store> query = em.createQuery("from Store where id=?1", Store.class);
		query.setParameter(1, storeModifiedId);

		try {
			Store updatedSupplier = query.getSingleResult();
			em.getTransaction().begin();
			updatedSupplier.setName(storeModified.getName());
			updatedSupplier.setMobile(storeModified.getMobile());
			updatedSupplier.setStoreAddres(addressModified);

			em.merge(updatedSupplier);

			em.getTransaction().commit();
		} catch (NoResultException nre) {
			System.out.println("Store NOT found.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}
