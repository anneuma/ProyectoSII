package tarea2.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tarea1.jpa.Expediente;
import tarea2.exception.ExpedienteNoEncontradoException;

@Stateless
public class AsignaturaEJB implements GestionAsignatura {
	@PersistenceContext(name="ProyectoSII")
	private EntityManager em;
	
	@Override
	public void modificarExpediente (Expediente expediente) throws ExpedienteNoEncontradoException {
		Expediente expedienteEntity = em.find(Expediente.class, expediente.getId());
		if (expedienteEntity == null) {
			throw new ExpedienteNoEncontradoException();
		}
		em.merge(expediente);
	}
	
	@Override
	public void eliminarExpediente (Expediente expediente) throws ExpedienteNoEncontradoException {
		Expediente expedienteEntity = em.find(Expediente.class, expediente.getId());
		if (expedienteEntity == null) {
			throw new ExpedienteNoEncontradoException();
		}
		em.remove(em.merge(expediente));
	}
	
	@Override
	public List<Asignatura> consultarAsignatura(Asignatura asignatura) throws ExpedienteNoEncontradoException {
		Expediente expedienteEntity = em.find(Expediente.class, expediente.getId());
		if (expedienteEntity == null) {
			throw new ExpedienteNoEncontradoException();
		}
		return expediente.getExpedientes();
	}
}
