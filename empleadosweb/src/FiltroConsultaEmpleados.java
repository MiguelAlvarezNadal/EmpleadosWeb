

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class FiltroConsultaEmpleados
 */
@WebFilter("/ConsultaEmpleados")
public class FiltroConsultaEmpleados implements Filter {
	private final static Logger log = Logger.getLogger("mylog");
    /**
     * Default constructor. 
     */
    public FiltroConsultaEmpleados() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		// pass the request along the filter chain
		
		//Mensaje de log Inicial
		log.debug("DEBUG - PASA POR EL FILTRO ANTES DE EJECUTAR CONSULTAEMPLEADOS");
		long tiempo_inicial = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		//Mensaje de log Final
		log.debug("DEBUG - PASA POR EL FILTRO DESPUÉS DE EJECUTAR CONSULTAEMPLEADOS");
		long tiempo_final = System.currentTimeMillis();
		long tiempo_total = tiempo_final - tiempo_inicial;
		System.out.println("Ha tardado " + tiempo_total);
		
		ServletContext sc = request.getServletContext();
		//sc.setAttribute("peticiones", 0);
		//Integer peticiones = (Integer)sc.getAttribute("peticiones");
		Long tms = (Long)sc.getAttribute("tms");
		if(tms == null){
			sc.setAttribute("tms", tiempo_total);
			sc.setAttribute("peticiones", 1);
			log.debug("TIEMPO MEDIO = " + tiempo_total + " ms");
		}
		else{
			//tms = (tms + tiempo_total)/2;
			Integer peticiones = (Integer)sc.getAttribute("peticiones");
			peticiones = peticiones + 1;
			tms = (tms + tiempo_total)/peticiones;
			sc.setAttribute("tms", tms);
			sc.setAttribute("peticiones", peticiones);
			log.debug("TIEMPO MEDIO = " + tms + " ms");
			log.debug("Nº de peticiones = " + peticiones);
		}		
		/*if(peticiones == null){
			log.debug("No existen peticiones");
			sc.setAttribute("peticiones", 0);
			long tiempo_medio = tiempo_total;
			log.debug("El tiempo medio de espera para la petición es " + tiempo_medio);
			sc.setAttribute("media", tiempo_medio);
			//log.debug("El tiempo medio de espera para la peticion es " + tiempo_total);
		}
		else{
			peticiones = peticiones + 1;
			sc.setAttribute("peticiones", peticiones);
			log.debug("Peticiones = " + peticiones);
			long tiempo_medio = 0;
			tiempo_medio = (tiempo_medio + tiempo_total)/peticiones;
			log.debug("El tiempo medio de espera para la petición es " + tiempo_medio);
		}*/
		

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
