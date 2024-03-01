package servlet;

import java.io.IOException;

import entities.Address;
import entities.Customer;
import entitiesDAO.CustomerDAO;
import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.JpaUtil;

/**
 * Servlet implementation class UserServlet
 */
@WebInitParam(name = "persistenceUnit", value = "HibernateOracle")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManager em = JpaUtil.getEM("HibernateOracle");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
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

		CustomerDAO customerDAO = new CustomerDAO(em);

		Customer searchCustomer = null;

		if (request.getParameter("delete") != null) {

			String message = customerDAO.deleteCustomerById(Long.parseLong(request.getParameter("delete")));
			
			request.setAttribute("message", message);

			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			// Se envia al JSP
			rd.forward(request, response);

		} else if (request.getParameter("modify") != null) {

			searchCustomer = customerDAO.selectCustomerByDNI(request.getParameter("modify"));

			// Redirección a JSP
			request.setAttribute("customerToModify", searchCustomer);

			RequestDispatcher rd = request.getRequestDispatcher("CustomerForm.jsp");
			// Se envia al JSP
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Objetos inicializados.
		Customer customer;
		Address address;

		// Conexión.
		CustomerDAO customerDAO = new CustomerDAO(em);

		// Recolección de datos Cliente.
		String id = request.getParameter("idCustomer");
		long idLong = 0;
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
		}
		String name = request.getParameter("name");
		String dni = request.getParameter("dni");
		String mobile = request.getParameter("mobile");
		String observation = request.getParameter("observation");

		// Recoleccion de datos Dirección
		String addressName = request.getParameter("addressName");
		String province = request.getParameter("province");
		String city = request.getParameter("cityAddress");
		String postalCode = request.getParameter("pcAddress");

		// Creación de Address
		address = new Address(addressName, province, city, postalCode);

		// Creación de objeto Customer
		customer = new Customer(name, dni, mobile, address, observation);

		// Inicialización mensaje
		String message = null;

		// Inserción o actualización a DDBB
		if (idLong == 0) {
			System.out.println("Pasa por inserción");
			message = customerDAO.insertCustomer(customer);
		} else if (idLong != 0) {
			System.out.println("Pasa por actualización");
			customer.setId(idLong);
			message = customerDAO.updateCustomer(idLong, customer);
		}
		// Redirección a JSP
		request.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		// Se envia al JSP
		rd.forward(request, response);
	}

}
