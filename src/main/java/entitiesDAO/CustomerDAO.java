package entitiesDAO;

import java.util.List;

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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
			List <Customer> customersList = getCustomerByDNI(customerDNI);

			for (Customer customer : customersList) {
				em.remove(customer);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}
}
