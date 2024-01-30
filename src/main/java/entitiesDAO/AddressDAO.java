package entitiesDAO;

import java.util.List;

import entities.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AddressDAO {
	private EntityManager em;

	// CONSTRUCTOR
	public AddressDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertAddress(Address address) {
		em.getTransaction().begin();
		try {
			em.persist(address);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public void insertAddressList(List<Address> addresses) {
		em.getTransaction().begin();
		try {

			for (Address address : addresses) {
				em.persist(address);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public List<Address> selectAddress() {
		return em.createQuery("from Address", Address.class).getResultList();
	}

	public List<Address> getAddressByName(String addressName) {
		List<Address> address;

		Query query = em.createQuery("from Address ue where ue.name=?1", Address.class);

		query.setParameter(1, addressName);
		address = query.getResultList();

		return address;
	}
	

	public void deleteAddressById(long id) {
		try {
			Address search = em.find(Address.class, id);
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
	
	public void deleteAddressByName(String addressName) {
		em.getTransaction().begin();
		try {
			List<Address> addressList = getAddressByName(addressName);

			for (Address address : addressList) {
				em.remove(address);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}
}
