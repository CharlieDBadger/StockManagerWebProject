package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPrueba
 */
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServletPrueba() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String resultado = (Integer.parseInt(request.getParameter("numero")) % 2 == 0) ? "es par" : "es impar";

		System.out.println("Resultado " + resultado + " tu id es: " + request.getRequestId());

		response.getWriter().append("<H1>Tu numero " + resultado + "</h1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		String nombre = request.getParameter("nombre");
		String contraseña = request.getParameter("contraseña");
		
		response.setContentType("text/html");

		if (nombre != null && contraseña != null) {
			response.getWriter().append("Lectura de response como HTML");
			response.getWriter()
					.append("<p style=color:red;> Nombre: " + nombre + "</p>" + "<br>Contraseña: " + contraseña);
		}

	}

}
