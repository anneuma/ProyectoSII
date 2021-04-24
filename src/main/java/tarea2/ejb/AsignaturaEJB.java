package tarea2.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tarea1.jpa.*;
import tarea2.exception.*;

@Stateless
public class AsignaturaEJB implements GestionAsignatura {
	@PersistenceContext(name="ProyectoSII")
	private EntityManager em;
	
	@Override
	public void modificarAsignatura (Asignatura asignatura) throws AsignaturaNoEncontradaException {
		Asignatura asignaturaEntity = em.find(Asignatura.class, asignatura.getReferencia());
		if (asignaturaEntity == null) {
			throw new AsignaturaNoEncontradaException();
		}
		em.merge(asignatura);
	}
	
	@Override
	public void eliminarAsignatura (Asignatura asignatura) throws AsignaturaNoEncontradaException {
		Asignatura asignaturaEntity = em.find(Asignatura.class, asignatura.getReferencia());
		if (asignaturaEntity == null) {
			throw new AsignaturaNoEncontradaException();
		}
		em.remove(em.merge(asignatura));
	}
	
	@Override
	public Titulacion obtenerTitulacion(Titulacion titulacion) throws TitulacionNoEncontradaException {
		Titulacion titulacionEntity = em.find(Titulacion.class, titulacion.getCodigo());
		if (titulacionEntity == null) {
			throw new TitulacionNoEncontradaException();
		}
		return titulacion;
	}
	
	@Override
	public Grupo_asignatura obtenerGrupoAsignatura(Grupo grupo) throws GrupoNoEncontradoException {
		Grupo grupoEntity = em.find(Grupo.class, grupo.getId());
		if (grupoEntity == null) {
			throw new GrupoNoEncontradoException();
		}
		return grupo.getGrupo_asignatura();
	}
	
	@Override
	public Clase obtenerClase (Clase clase) throws ClaseNoEncontradaException {
		Clase claseEntity = em.find(Clase.class, clase.getDia());
		if (claseEntity == null) {
			throw new ClaseNoEncontradaException();
		}
		return clase;
	}
	
	@Override
	public Asignaturas_matricula obtenerAsignaturaMatricula(Matricula matricula) throws MatriculaNoEncontradaException {
		Matricula matriculaentity = em.find(Matricula.class, matricula.getId());
		if (matriculaentity == null) {
			throw new MatriculaNoEncontradaException();
		}
		
		return matricula.getAsignatura_matricula();
	}
	
	@Override
	public Optativa obtenerOptativa (Optativa optativa) throws OptativaNoEncontradaException {
		Optativa optativaEntity = em.find(Optativa.class, optativa.getCodigo());
		if (optativaEntity == null) {
			throw new OptativaNoEncontradaException();
		}
		return optativa;
	}

	@Override
	public void insertarAsignatura(Asignatura asignatura) throws ProyectoException {
		Asignatura asignaturaEntity = em.find(Asignatura.class, asignatura.getReferencia());
		if (asignaturaEntity == null) {
			throw new AsignaturaNoEncontradaException();
		}
		em.persist(asignatura);
	}

	@Override
	public void actualizarAsignatura(Asignatura asignatura) throws ProyectoException {
		Asignatura asignaturaEntity = em.find(Asignatura.class, asignatura.getReferencia());
		if (asignaturaEntity == null) {
			throw new AsignaturaNoEncontradaException();
		}
		em.merge(asignatura);
	}
}
