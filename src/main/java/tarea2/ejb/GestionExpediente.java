package tarea2.ejb;

import java.util.List;
import javax.ejb.Local;
import tarea1.jpa.Expediente;
import tarea2.exception.ProyectoException;

@Local
public interface GestionExpediente {
	
	public void modificarExpediente(Expediente expediente) throws ProyectoException;

	public void eliminarExpediente(Expediente expediente) throws ProyectoException;
	
	public List<Expediente> consultarExpediente(Expediente expediente) throws ProyectoException;
}
