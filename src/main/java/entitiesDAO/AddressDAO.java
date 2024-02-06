package entitiesDAO;

import java.util.List;

import entities.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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
	
	/**
	 * 
	 * @param id
	 * @param addressModified This method receives the Address object from the
	 *                        Servlet with the values collected in the HTML form.
	 */
	public void updateAddress(long addressModifiedId, Address addressModified) {

		TypedQuery<Address> query = em.createQuery("from Address where id=?1", Address.class);
		query.setParameter(1, addressModifiedId);

		try {
			Address updatedAddress = query.getSingleResult();
			em.getTransaction().begin();
			updatedAddress.setName(addressModified.getName());
			updatedAddress.setProvince(addressModified.getProvince());
			updatedAddress.setCity(addressModified.getCity());
			updatedAddress.setPostalCode(addressModified.getPostalCode());
			;

			em.merge(updatedAddress);

			em.getTransaction().commit();
		} catch (NoResultException nre) {
			System.out.println("Calle not found.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}
