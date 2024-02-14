package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.JpaUtil;
import tools.Tools;

/**
 * Servlet implementation class UserServlet
 */
public class PruebaServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		EntityManager em = JpaUtil.getEM("HibernateOracle");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PruebaServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		UserDAO userDAO = new UserDAO (em);
//		
//		List <User> userList = userDAO.selectUser();
//
//		// Si necesitamos pasar un objeto o listado, usamos el atributo.
//		request.setAttribute("userList", userList);
//
//		// Redirección a JSP
//		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp?numero=8");
//
//		// Se envia al JSP
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user;

		String id = request.getParameter("id");
		long idLong = Long.parseLong(id);

		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");

		String birth = request.getParameter("birth");
		Date dateBirth = null;

		try {
			dateBirth = Tools.convertStringToDate(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// id verification in DDBB
//		if (id == null) {
//			user = new User(name, lastName, password, role, mail, phone, gender, dateBirth);
//		} else {
//			user = new User(idLong, name, lastName, password, role, mail, phone, gender, dateBirth);
//		}

//		response.getWriter().append("<H1>Tu numero " + user + "</h1");

	}

}
