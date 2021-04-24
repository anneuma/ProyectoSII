package tarea2.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tarea1.jpa.Asignatura;
import tarea2.exception.AsignaturaNoEncontradaException;

@Stateless
public class AsignaturaEJB implements GestionAsignatura {
  @PersistenceContext(name="ProyectoSII")
	private EntityManager em;
	
	@Override
	public void modificarAsignatura (Asignatura asignatura) throws AsignaturaNoEncontradaException {
		Asignatura asignaturaEntity = em.find(Asignatura.class, asignatura.getId());
		if (asignaturaEntity == null) {
			throw new AsignaturaNoEncontradaException();
		}
		em.merge(asignatura);
	}
	
	@Override
	public void eliminarAsignatura (Asignatura asignatura) throws AsignaturaNoEncontradaException {
		Asignatura asignaturaEntity = em.find(Asignatura.class, asignatura.getId());
		if (asignaturaEntity == null) {
			throw new AsignaturaNoEncontradaException();
		}
		em.remove(em.merge(asignatura));
	}
}
