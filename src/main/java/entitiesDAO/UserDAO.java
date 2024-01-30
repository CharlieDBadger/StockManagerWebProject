package entitiesDAO;

import java.util.List;

import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class UserDAO {
	private EntityManager em;
	
	//CONSTRUCTOR
	public UserDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertUser(User user) {
		em.getTransaction().begin();
		try {
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public void insertUserList(List<User> users) {
		em.getTransaction().begin();
		try {

			for (User user : users) {
				em.persist(user);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public List<User> selectUser() {
		return em.createQuery("from User", User.class).getResultList();
	}
	
	public List<User> getUserByName(String userName) {
		List<User> users;

		Query query = em.createQuery("from User ue where ue.name=?1", User.class);

		query.setParameter(1, userName);
		users = query.getResultList();

		return users;
	}

	public void deleteUserById(long id) {
		try {
			User search = em.find(User.class, id);
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

	public void deleteUserByName(String userName) {
		em.getTransaction().begin();
		try {
			List <User> usersList = getUserByName(userName);

			for (User users : usersList) {
				em.remove(users);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}
}
