package entitiesDAO;

import java.util.List;

import entities.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ItemDAO {
	private EntityManager em;

	// CONSTRUCTOR
	
	public ItemDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertItem(Item item) {
		em.getTransaction().begin();
		try {
			em.persist(item);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}


	public void insertItemList(List<Item> items) {
		em.getTransaction().begin();
		try {

			for (Item item : items) {
				em.persist(item);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public List<Item> selectItem() {
		return em.createQuery("from Item", Item.class).getResultList();
	}
	
	public List<Item> getItemByName(String itemName) {
		List<Item> items;

		Query query = em.createQuery("from Item ue where ue.name=?1", Item.class);

		query.setParameter(1, itemName);
		items = query.getResultList();

		return items;
	}

	public void deleteItemById(long id) {
		try {
			Item search = em.find(Item.class, id);
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

	public void deleteItemByName(String itemName) {
		em.getTransaction().begin();
		try {
			List <Item> itemsList = getItemByName(itemName);

			for (Item item : itemsList) {
				em.remove(item);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
}
