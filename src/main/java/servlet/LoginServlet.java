package servlet;

import java.io.IOException;
import java.util.List;

import entities.User;
import enums.UserENUM;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String message;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Iniciando");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginName = request.getParameter("userName");
		String loginPassword = request.getParameter("userPassword");

		List<User> userList = UserENUM.INSTANCE.getUserList();
		User userLogged = null;
		boolean check = false;

		for (User userFromList : userList) {
			if (userFromList.getName().equals(loginName) && userFromList.getPassword().equals(loginPassword)) {

				userLogged = userFromList;
				
				check = true;
				break;
			}
		}
		
		if (check) {
			
			HttpSession session = request.getSession();

			session.setAttribute("userLogged", userLogged);

			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			
			rd.forward(request, response);
			
		} else if (!check) {
			
			message = "Usuario y/o Contraseña no validos.";
			
			// Redirección a JSP
			request.setAttribute("message", message);

			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			// Se envia al JSP
			rd.forward(request, response);
			
		}
	}

}
