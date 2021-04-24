package tarea2.ejb;

import java.util.List;
import javax.ejb.Local;
import tarea1.jpa.Asignatura;
import tarea2.exception.ProyectoException;

@Local
public interface GestionAsignatura {
	
	public void modificarAsignatura(Asignatura asignatura) throws ProyectoException;

	public void eliminarAsignatura(Asignatura asignatura) throws ProyectoException;
	
	public List<Asignatura> consultarAsignatura(Asignatura asignatura) throws ProyectoException;
}
