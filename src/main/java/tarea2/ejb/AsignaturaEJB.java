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
	
	@Override
	public List<Titulacion> obtenerListaTitulacion(Titulacion titulacion) throws TitulacionNoEncontradaException {
		Titulacion titulacionEntity = em.find(Titulacion.class, titulacion.getId());
		if (titulacionEntity == null) {
			throw new TitulacionNoEncontradaException();
		}
		return titulacion.getTitulaciones();
	}
	
	@Override
	public GrupoAsignatura obtenerGrupoAsignatura(Grupo grupo) throws GrupoNoEncontradoException {
		Grupo grupoEntity = em.find(Grupo.class, grupo.getId());
		if (grupoEntity == null) {
			throw new GrupoNoEncontradoException();
		}
		return grupo.getGrupos();
	}
	
	@Override
	public Clase obtenerClase (Clase clase) throws ClaseNoEncontradaException {
		Clase claseEntity = em.find(Clase.class, clase.getId());
		if (claseEntity == null) {
			throw new ClaseNoEncontradaException();
		}
		return clase.getClases();
	}
	
	@Override
	public Asignatura_matricula obtenerAsignaturaMatricula(Matricula matricula) throws MatriculaNoEncontradaException {
		Matricula matriculaentity = em.find(Matricula.class, matricula.getId());
		if (matriculaentity == null) {
			throw new MatriculaNoEncontradaException();
		}
		
		return matricula.getAsignaturas_matricula();
	}
	
	@Override
	public Optativa obtenerOptativa (Optativa optativa) throws OptativaNoEncontradaException {
		Optativa optativaEntity = em.find(Optativa.class, optativa.getId());
		if (optativaEntity == null) {
			throw new OptativaNoEncontradaException();
		}
		return optativa.getOptativas();
	}
}
