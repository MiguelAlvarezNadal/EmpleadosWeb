

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ConsultaEmpleados
 */
@WebServlet("/ConsultaEmpleados")
public class ConsultaEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger("mylog");
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaEmpleados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		log.info("Info - Esto funciona correctamente.");
		EmpleadoService es = new EmpleadoService();
		log.info("Info - Creamos una variable de tipo lista de empleados.");
		List<Empleado> le = es.getEmpleados();
	
		log.warn("Warn - Creamos un for para recorrer todos los empleados.");
		//Declaramos la variable del mapa
		Map<Integer, Empleado> m_empleado = new HashMap<Integer, Empleado>();
		for (Empleado e : le)
		{
			log.warn("Warn - Escribimos el nombre y la ID del empleado " + e.getNombre() + " por consola.");
			System.out.println(e.getNombre() + " "+ e.getId());
			m_empleado.put(e.getId(), e);
		}
		log.debug("Mapa Empleados Creado");
		//Me devuelve todas las claves.
		Set<Integer> conjunto_claves =  m_empleado.keySet();
		//Paso de uno a otro, como el resultSet();
		Iterator<Integer> it = conjunto_claves.iterator();
		int clave = -1;
		Empleado eaux = null;
		System.out.println("Creamos el While");
		//hasNext() - Nos dice si hay siguiente o no
		while(it.hasNext()){
			clave = it.next();
			eaux = m_empleado.get(clave);
			System.out.println(eaux.getNombre() + " "+ eaux.getId());
		}

		ServletContext sc = request.getServletContext();
		//
		sc.setAttribute("mapae", m_empleado);
		log.debug("DEBUG - Mapa almacenado en el contexto");
		
		System.out.println("Finalizamos el while");
		//TODO falta generera el jsp
		log.error("Error - Se recoge los datos y los mandamos con el nombre 'lempleados'");
		request.setAttribute("lempleados", le);
		log.error("Error -  Enviamos los datos al jsp");
		request.getRequestDispatcher("listaempleados.jsp")
		.forward(request, response);
		
		long tiempo_inicial = System.currentTimeMillis();
		long tiempo_final = System.currentTimeMillis();
		long tiempo_total = tiempo_final - tiempo_inicial;
		long segundos = tiempo_total/1000;
		System.out.println("Ha tardado " + segundos + " s");
		System.out.println("Ha tardado " + tiempo_total);	
		//response.getWriter().append("LLAMO A GET Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
