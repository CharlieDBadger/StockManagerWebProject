package enums;

import java.util.List;

import entities.User;
import entitiesDAO.UserDAO;
import jakarta.persistence.EntityManager;
import tools.JpaUtil;

public enum UserENUM {

	INSTANCE;

	private List<User> userList;

	private UserENUM() {

		EntityManager em = JpaUtil.getEM("HibernateOracle");

		UserDAO userDao = new UserDAO(em);

		this.userList = userDao.selectUser();
	}

	public List<User> getUserList() {
		return userList;
	}

}
