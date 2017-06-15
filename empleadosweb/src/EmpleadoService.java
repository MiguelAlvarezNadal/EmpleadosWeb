

import java.util.List;

public class EmpleadoService {
	
	public Empleado ObtenerInfoEmpleado(int id){
		Empleado empleado = null;
		
		EmpleadoBD empleadobd = null;
		empleadobd = new EmpleadoBD();
		empleado = empleadobd.ObtenerEmpleado(id);
		
		return empleado;
	}
	
	public List<Empleado> getEmpleados ()
	{
		List<Empleado> l_empleados = null;
		
			EmpleadoBD empleadoBD = new EmpleadoBD();
			l_empleados = empleadoBD.getEmpleadosBD();
		
		return l_empleados;
	}
	
	public List<Empleado> getEmpleadosByDpto (int ndpto)
	{
		List<Empleado> l_empleados = null;
		
			EmpleadoBD empleadoBD = new EmpleadoBD();
			l_empleados = empleadoBD.getEmpleadosBDByDpto(ndpto);
		
		return l_empleados;
	}
	
	public boolean ValidarUsuario(String usuario, String pwd){
		boolean valido = false;
		
		EmpleadoBD empleadobd = null;
		empleadobd = new EmpleadoBD();
		valido = empleadobd.existeEmpleadoEnBD(usuario, pwd);
		
		return valido;
	}

}
