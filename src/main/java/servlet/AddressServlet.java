package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import entities.Address;
import entitiesDAO.AddressDAO;
import jakarta.persistence.EntityManager;
import tools.JpaUtil;

/**
 * Servlet implementation class AddressServlet
 */
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManager em = JpaUtil.getEM("HibernateOracle");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddressServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Address variables.
		long id = Long.parseLong(request.getParameter("idDireccion"));

		String name = request.getParameter("nombreDireccion");
		String province = request.getParameter("provinciaDireccion");
		String city = request.getParameter("ciudadDireccion");
		String postalCode = request.getParameter("codigoPostalDireccion");

		Address address = new Address(name, province, city, postalCode);
		System.out.println(address.getCity());
		AddressDAO addressDAO = new AddressDAO(em);

		if (id == 0) {
			addressDAO.insertAddress(address);
		} else if (id < 0) {
			address.setId(id);
			addressDAO.updateAddress(id, address);
		}
		
		response.getWriter().append("pasa");

	}

}
