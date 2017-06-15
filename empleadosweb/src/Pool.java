import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Pool {

	private static DataSource datasource;
	
	private static final String RUTA_XML = "java:comp/env/jdbc/pool";
	
	private Pool(){
		try{
			InitialContext ic = new InitialContext();
			datasource = (DataSource)ic.lookup(RUTA_XML);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static{
		new Pool();
	}
	
	public static Connection getConnection(){
		Connection conexion = null;
		try {
			conexion = datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}

	/*public static void cerrarConexion(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

	public static void liberarRecursos(Connection connection, Statement statement){
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void liberarRecursos(Connection connection, Statement statement, ResultSet resultset){
		try {		
			connection.close();
			statement.close();
			resultset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
