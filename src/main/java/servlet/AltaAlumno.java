package Servlets;

import java.io.IOException;

import entidades.Alumno;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AltaAlumno
 */
public class AltaAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AltaAlumno() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nombre = request.getParameter("nombre");
	    String apellido = request.getParameter("apellido");
	    String sexo = request.getParameter("sexo");
	    String dni = request.getParameter("dni");
	    String rol = request.getParameter("rol");
	    String email = request.getParameter("email");
	    
	    //Creamos alumno
	    Alumno alumno = new Alumno (nombre, apellido, sexo, dni, rol, email);
	    
	    response.getWriter().append(alumno.toString());
	}

}
