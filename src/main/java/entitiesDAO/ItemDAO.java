package entitiesDAO;

import java.util.List;

import entities.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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

	public Item getItemByCode(String itemCode) {

		TypedQuery<Item> query = em.createQuery("from Item where code=?1", Item.class);
		query.setParameter(1, itemCode);

		Item item = query.getSingleResult();

		return item;
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
			List<Item> itemsList = getItemByName(itemName);

			for (Item item : itemsList) {
				em.remove(item);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	/**
	 * 
	 * @param id
	 * @param addressModified This method receives the Item object from the Servlet
	 *                        with the values collected in the HTML form.
	 */
	public void updateItem(long itemModifiedId, Item itemModified) {

		TypedQuery<Item> query = em.createQuery("from Item where id=?1", Item.class);
		query.setParameter(1, itemModifiedId);

		try {
			Item updatedItem = query.getSingleResult();
			em.getTransaction().begin();
			updatedItem.setCode(itemModified.getCode());
			updatedItem.setName(itemModified.getName());
			updatedItem.setKind(itemModified.getKind());
			;

			em.merge(updatedItem);

			em.getTransaction().commit();
		} catch (NoResultException nre) {
			System.out.println("Item not found.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}
