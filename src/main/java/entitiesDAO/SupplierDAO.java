package entitiesDAO;

import java.util.List;

import entities.Supplier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class SupplierDAO {
	private EntityManager em;

	public SupplierDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void insertSupplier(Supplier supplier) {
		em.getTransaction().begin();
		try {
			em.persist(supplier);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
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
			List <Supplier> suppliersList = getCustomerByCIF(customerCIF);

			for (Supplier supplier : suppliersList) {
				em.remove(supplier);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}
}
