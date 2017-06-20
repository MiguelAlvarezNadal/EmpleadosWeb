

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class EscuchaInicioYFinSesion
 *
 */
@WebListener
public class EscuchaInicioYFinSesion implements HttpSessionListener {
	private final static Logger log = Logger.getLogger("mylog");
    /**
     * Default constructor. 
     */
    public EscuchaInicioYFinSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	HttpSession sesion = arg0.getSession();
    	String id_sesion = sesion.getId();
    	log.debug("Sesion creada = " + id_sesion);
    	//TODO Sumar uno a la variable sesionesactivas presente en el saco del contexto
    	//Accedo al saco del contexto
    	ServletContext sc = sesion.getServletContext();
    	//Obtengo el valor de las sesionesactivas
    	int sesionesactivas = (int)sc.getAttribute("sesionesactivas");
    	//incrementamos a uno el numero de sesiones
    	sesionesactivas = sesionesactivas + 1;
    	//Vuelvo a meter el numero de sesiones en el saco de contexto ya actualizado
    	sc.setAttribute("sesionesactivas", sesionesactivas);
    	log.debug("Sesiones activas = " + sesionesactivas);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	HttpSession sesion = arg0.getSession();
    	String id_sesion = sesion.getId();
    	log.debug("Sesion finalizada = " + id_sesion);
    	//TODO Restar uno a la variable sesionesactivas presente en el saco del contexto
    	ServletContext sc = sesion.getServletContext();
    	int sesionesactivas = (int)sc.getAttribute("sesionesactivas");
    	sesionesactivas = sesionesactivas - 1;
    	sc.setAttribute("sesionesactivas", sesionesactivas);
    	log.debug("Sesiones activas = " + sesionesactivas);
    	//Eliminar sesion:
    	//TODO Actualizo el mapa de sesiones y elimino la que acaba de destruirse.
    	Map<String, String> mapa_nombre_sesion = (Map<String, String>)sc.getAttribute("mapa_nombre_sesion");
    	mapa_nombre_sesion.remove(id_sesion);
    	log.debug("Sesion destruida del mapa de sesiones");
    }
	
}
