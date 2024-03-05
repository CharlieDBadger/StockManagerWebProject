package enums;

import java.util.List;

import entities.User;
import entitiesDAO.UserDAO;
import jakarta.persistence.EntityManager;
import tools.JpaUtil;

public enum UserENUM {

	INSTANCE;

	private List<User> userList;

	public List<User> getUserList() {
		
		EntityManager em = JpaUtil.getEM("HibernateOracle");

		UserDAO userDao = new UserDAO(em);

		this.userList = userDao.selectUser();
		return userList;
	}

}
