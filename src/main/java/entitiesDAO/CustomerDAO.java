package entitiesDAO;

import java.util.List;

import entities.Address;
import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CustomerDAO {
	private EntityManager em;

	// CONSTRUCTOR
	public CustomerDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertCustomer(Customer customer) {
		em.getTransaction().begin();
		try {
			em.persist(customer);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No se hizo carnal Customer");
		}
	}

	public void insertCustomerList(List<Customer> customers) {
		em.getTransaction().begin();
		try {

			for (Customer customer : customers) {
				em.persist(customer);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public List<Customer> selectCustomer() {
		return em.createQuery("from Customer", Customer.class).getResultList();
	}

	public List<Customer> getCustomerByDNI(String customerName) {
		List<Customer> customers;

		Query query = em.createQuery("from Customer ue where ue.dni=?1", Customer.class);

		query.setParameter(1, customerName);
		customers = query.getResultList();

		return customers;
	}

	public void deleteCustomerById(long id) {
		try {
			Customer search = em.find(Customer.class, id);
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

	public void deleteCustomerByDNI(String customerDNI) {
		em.getTransaction().begin();
		try {
			List<Customer> customersList = getCustomerByDNI(customerDNI);

			for (Customer customer : customersList) {
				em.remove(customer);
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
	 * @return This method receives the Customer object from the Servlet with the
	 *         values collected in the HTML form.
	 * 
	 */
	public String updateCustomer(long customerModifiedId, Customer customerModified, Address addressModified,
			EntityManager em) {

		TypedQuery<Customer> query = em.createQuery("from Customer where id=?1", Customer.class);
		query.setParameter(1, customerModifiedId);

		String message;
		
		try {
			Customer updatedCustomer = query.getSingleResult();
			em.getTransaction().begin();
			updatedCustomer.setName(customerModified.getName());
			updatedCustomer.setDni(customerModified.getDni());
			updatedCustomer.setMobile(customerModified.getMobile());
			updatedCustomer.setAddress(addressModified);
			updatedCustomer.setObservation(customerModified.getObservation());

			em.merge(updatedCustomer);

			em.getTransaction().commit();
			message = "Usuario Añadido con exito.";
		} catch (NoResultException nre) {
			message = "Usuario no encontrado.";
			System.out.println("Customer NOT found.");
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			message = "Ha ocurrido un error. Intentelo de nuevo.";
			System.out.println(message);

		}
		return message;
	}
}
