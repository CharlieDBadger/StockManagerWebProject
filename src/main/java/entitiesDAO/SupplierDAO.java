package entitiesDAO;

import java.util.List;

import entities.Address;
import entities.Supplier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class SupplierDAO {
	private EntityManager em;

	public SupplierDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public String insertSupplier(Supplier supplier) {
		em.getTransaction().begin();
		String message;
		try {
			em.persist(supplier);
			em.getTransaction().commit();
			message = "Usuario insertado con exito.";

		} catch (Exception e) {
			em.getTransaction().rollback();
			message = "Ha ocurrido un error, intente de nuevo.";
		}
		return message;
	}

	public void insertSupplierList(List<Supplier> suppliers) {
		em.getTransaction().begin();
		try {

			for (Supplier supplier : suppliers) {
				em.persist(supplier);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public List<Supplier> selectSupplier() {
		return em.createQuery("from Supplier", Supplier.class).getResultList();
	}

	public List<Supplier> getCustomerByCIF(String supplierCIF) {
		List<Supplier> suppliers;

		Query query = em.createQuery("from Supplier ue where ue.cif=?1", Supplier.class);

		query.setParameter(1, supplierCIF);
		suppliers = query.getResultList();

		return suppliers;
	}

	public void deleteSupplierById(long id) {
		try {
			Supplier search = em.find(Supplier.class, id);
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

	public void deleteSupplierByName(String customerCIF) {
		em.getTransaction().begin();
		try {
			List<Supplier> suppliersList = getCustomerByCIF(customerCIF);

			for (Supplier supplier : suppliersList) {
				em.remove(supplier);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	/**
	 * 
	 * @param supplierModifiedId
	 * @param supplierModified   This method receives the Supplier object from the
	 *                           Servlet with the values collected in the HTML form.
	 * @param addressModified
	 * @param em
	 */
	public String updateSupplier(long supplierModifiedId, Supplier supplierModified, Address addressModified,
			EntityManager em) {

		TypedQuery<Supplier> query = em.createQuery("from Supplier where id=?1", Supplier.class);
		query.setParameter(1, supplierModifiedId);

		String message;

		
		try {
			Supplier updatedSupplier = query.getSingleResult();
			em.getTransaction().begin();
			updatedSupplier.setName(supplierModified.getName());
			updatedSupplier.setCif(supplierModified.getCif());
			updatedSupplier.setMobile(supplierModified.getMobile());
			updatedSupplier.setAddress(addressModified);
			updatedSupplier.setDescription(supplierModified.getDescription());

			em.merge(updatedSupplier);

			em.getTransaction().commit();
			
			message = "Proveedor añadido con exito.";

		} catch (NoResultException nre) {
			message = "Proveedor no encontrado.";

			System.out.println("Supplier not found.");
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			message = "Ha ocurrido un error. Intentelo de nuevo.";
			System.out.println(message);

		}
		return message;
	}
}
