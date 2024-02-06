package entitiesDAO;

import java.util.List;

import entities.Address;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class UserDAO {
	private EntityManager em;

	// CONSTRUCTOR
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
			List<User> usersList = getUserByName(userName);

			for (User users : usersList) {
				em.remove(users);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	/**
	 * 
	 * @param id
	 * @param userModified This method receives the User object from the Servlet
	 *                     with the values collected in the HTML form.
	 */
	public void updateUser(long userModifiedId, User userModified) {

		TypedQuery<User> query = em.createQuery("from User where id=?1", User.class);
		query.setParameter(1, userModifiedId);

		try {
			User updatedUser = query.getSingleResult();
			em.getTransaction().begin();
			updatedUser.setName(userModified.getName());
			updatedUser.setLastName(userModified.getLastName());
			updatedUser.setPassword(userModified.getPassword());
			updatedUser.setRole(userModified.getRole());
			updatedUser.setMail(userModified.getMail());
			updatedUser.setPhone(userModified.getPhone());
			updatedUser.setGender(userModified.getGender());
			updatedUser.setBirth(userModified.getBirth());

			em.merge(updatedUser);

			em.getTransaction().commit();
		} catch (NoResultException nre) {
			System.out.println("User NOT found.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}
