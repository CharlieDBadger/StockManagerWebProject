package entitiesDAO;

import java.util.List;

import entities.Item;
import entities.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class StoreDAO {

	private EntityManager em;
	
	//CONSTRUCTOR
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
			List <Store> storeList = getStoreByName(storeName);

			for (Store store : storeList) {
				em.remove(store);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
}
