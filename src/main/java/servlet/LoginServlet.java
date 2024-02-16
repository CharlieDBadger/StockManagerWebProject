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

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String loginName = request.getParameter("userName");
		String loginPassword = request.getParameter("userPassword");
		
		List <User> userList = UserENUM.INSTANCE.getUserList();
		
		for (User user : userList) {
			if(user.getName().equals(loginName) & user.getPassword().equals(loginPassword)) {
				// Redirección a JSP
				request.setAttribute("userLogged", user);

				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				// Se envia al JSP
				rd.forward(request, response);
				break;
			}
		}		
	}

}
