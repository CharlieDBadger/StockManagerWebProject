package enums;

import java.util.List;

import entities.Customer;
import entitiesDAO.CustomerDAO;
import jakarta.persistence.EntityManager;
import tools.JpaUtil;

public enum CustomerENUM {

	INSTANCE;

	private List<Customer> CustomerList;


	public List<Customer> getCustomerList() {
		EntityManager em = JpaUtil.getEM("HibernateOracle");

		CustomerDAO customerDao = new CustomerDAO(em);

		this.CustomerList = customerDao.selectCustomer();
		
		return CustomerList;
	}

}
