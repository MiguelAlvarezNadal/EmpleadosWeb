

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroPerfil
 */
@WebFilter("/ConsultarMiInfo")
/**
 * @WebFilter(ServletNames = {"servlet1", "Servlet2", "servlet3"})
 * 
 * */
public class FiltroPerfil implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroPerfil() {
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
		/**
		 * Compurebo si la peticion tiene asociada una sesion y si es así, le dejo pasar al servicio
		 * Si no, le llevo a login
		 * 
		 */
		
		HttpServletRequest hr = (HttpServletRequest)request;
		HttpSession sesion = hr.getSession(false);
		if(sesion == null){
			//No tiene sesion.
			//redirigimos al login.
			HttpServletResponse hresp = (HttpServletResponse)response;
			System.out.println("sin sesion válida");
			hresp.sendRedirect("sinsesion.html");
		}
		else{
			//tiene sesion, le dejo pasar.
			chain.doFilter(request, response);
		}	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
