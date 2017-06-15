

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ConsultarMiInfo
 */
@WebServlet("/ConsultarMiInfo")
public class ConsultarMiInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger("mylog");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarMiInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Recuperamos a la sesion para poder acceder al atributo id
		HttpSession sesion = request.getSession(false);
		String id = (String)sesion.getAttribute("id");
		EmpleadoService es = new EmpleadoService();
		int id_empleado = Integer.parseInt(id);
		Empleado empleado = es.ObtenerInfoEmpleado(id_empleado);
		//Bean Java => clase de java sencilla con su set y get.
		request.setAttribute("empleado", empleado);
		request.getRequestDispatcher("miperfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
