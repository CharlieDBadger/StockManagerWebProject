package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import entities.User;
import entitiesDAO.UserDAO;
import enums.UserENUM;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.JpaUtil;
import tools.Tools;

/**
 * Servlet implementation class UserServlet
 */
@WebInitParam(name = "persistenceUnit", value = "HibernateOracle")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManager em = JpaUtil.getEM("HibernateOracle");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Modificación, recibe los datos de UserList

		UserDAO userDAO = new UserDAO(em);

		User searchUser = null;

		if (request.getParameter("delete") != null) {

			String message = userDAO.deleteUserById(Long.parseLong(request.getParameter("delete")));
			
			request.setAttribute("message", message);

			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			// Se envia al JSP
			rd.forward(request, response);

		} else if (request.getParameter("modify") != null) {

			searchUser = userDAO.selectUserByDNI(request.getParameter("modify"));

			// Redirección a JSP
			request.setAttribute("userToModify", searchUser);

			RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
			// Se envia al JSP
			rd.forward(request, response);
		} else if (request.getParameter("ascendentName") != null) {

			List <User> userListNameAsc = userDAO.ascListName();

			// Redirección a JSP
			request.setAttribute("userList", userListNameAsc);

			RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
			// Se envia al JSP
			rd.forward(request, response);}
		
		else if (request.getParameter("ascendentDni") != null) {

			List <User> userListNameAsc = userDAO.ascListDNI();

			// Redirección a JSP
			request.setAttribute("userList", userListNameAsc);

			RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
			// Se envia al JSP
			rd.forward(request, response);}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user;
		// Conexión
		UserDAO userDAO = new UserDAO(em);

		// Recolección de datos.
		String id = request.getParameter("idUser");
		long idLong = 0;
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
		}

		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		String dni = request.getParameter("dni");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String mail = request.getParameter("email");
		String phone = request.getParameter("telephone");
		String gender = request.getParameter("gender");

		String birth = request.getParameter("birth");

		// Conversión fechaString -> fechaDate
//		System.out.println("Formato cumpleaños " + birth);
		Date dateBirth;
		try {
			dateBirth = Tools.convertStringToDate(birth);
		} catch (ParseException e) {
			dateBirth = null;
			e.printStackTrace();
		}
		
//		System.out.println(Tools.convertDateToString(dateBirth));
	
		
		// Creación de Objeto
		user = new User(name, lastName, dni, password, role, mail, phone, gender, dateBirth);

		
		String message = null;
		// Inserción o actualización a DDBB
		if (idLong == 0) {
			message = userDAO.insertUser(user);
		} else if (idLong != 0) {
			user.setId(idLong);
			message= userDAO.updateUser(idLong, user);
		}
		// Redirección a JSP
		request.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		// Se envia al JSP
		rd.forward(request, response);
	}

}
