

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sun.org.apache.bcel.internal.classfile.Attribute;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Application Lifecycle Listener implementation class EscuchaInicioYFinContexto
 *
 */
@WebListener
public class EscuchaInicioYFinContexto implements ServletContextListener {
	private final static Logger log = Logger.getLogger("mylog");
    /**
     * Default constructor. 
     */
    public EscuchaInicioYFinContexto() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	log.debug("Contexto destruido");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {
         // TODO Auto-generated method stub
    	log.debug("Contexto iniciado");
    	//Accedo el saco del contexto
    	ServletContext sc = arg0.getServletContext();
    	//Inicio contador de sesiones
    	int numsesiones = 0;
    	//Meto el contador al saco del contexto
    	sc.setAttribute("sesionesactivas", numsesiones);
    }
	
}
