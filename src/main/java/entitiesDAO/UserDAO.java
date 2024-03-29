package entitiesDAO;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class UserDAO {
	private EntityManager em;
	private static final Logger logger = LogManager.getLogger(User.class);


	// CONSTRUCTOR
	public UserDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public String insertUser(User user) {
		em.getTransaction().begin();
		String message;
		try {
			em.persist(user);
			em.getTransaction().commit();
			message = "Usuario insertado con exito.";
			logger.info("Usuario insertado con exito.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			message = "Ha ocurrido un error, intente de nuevo.";
			logger.info("Ha ocurrido un error, intente de nuevo.");
		}
		return message;
	}

	public void insertUserList(List<User> users) {
		em.getTransaction().begin();
		try {
			logger.info("Insertando listado de usuarios.");
			for (User user : users) {
				em.persist(user);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public List<User> selectUser() {
		logger.info("Consultando listado de Usuarios");
		return em.createQuery("from User", User.class).getResultList();
	}

	public List<User> getUserByName(String userName) {
		List<User> users;
		logger.info("Consultando usuario por nombre: " + userName);
		Query query = em.createQuery("from User ue where ue.name=?1", User.class);

		query.setParameter(1, userName);
		users = query.getResultList();

		return users;
	}

	public User selectUserByDNI(String userDNI) throws NoResultException {
		
		logger.info("Consultando Usuario por DNI: " + userDNI);
		TypedQuery<User> query = em.createQuery("from User where dni=?1", User.class);
		query.setParameter(1, userDNI);

		User searchUser = query.getSingleResult();

		return searchUser;
	}

	public String deleteUserById(long id) {
		String message = null;
		
		try {
			User search = em.find(User.class, id);
			em.getTransaction().begin();
			em.remove(search);
			em.getTransaction().commit();
			message = "Usuario eliminado.";
			logger.info("Usuario eliminado.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return message;
	}

	public void deleteUserByDni(String dni) {
		try {
			User searchUser = selectUserByDNI(dni);
			em.getTransaction().begin();
			em.remove(searchUser);
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
	public String updateUser(long userModifiedId, User userModified) {

		TypedQuery<User> query = em.createQuery("from User where id=?1", User.class);
		query.setParameter(1, userModifiedId);

		String message;

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

			message = "Usuario actualizado con exito.";
			logger.info("Usuario actualizado con exito.");
		} catch (NoResultException nre) {
			message = "Usuario no encontrado.";
			logger.info("Usuario no encontrado.");
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			message = "Ha ocurrido un error. Intentelo de nuevo.";
			logger.info("Ha ocurrido un error. Intentelo de nuevo.");
		}
		return message;
	}
	
//	CONSULTA LISTADO PORDEN DESCENDENTE
	
	public List <User> ascListName (){
			
		logger.info("Consultando listado de Usuarios");
		return em.createQuery("from User u ORDER BY u.name ASC", User.class).getResultList();
	}
	
	public List <User> ascListDNI (){
		
		logger.info("Consultando listado de Usuarios");
		return em.createQuery("from User u ORDER BY u.dni ASC", User.class).getResultList();
	}
	
	
	
}
