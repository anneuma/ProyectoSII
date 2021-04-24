package tarea2.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tarea1.jpa.*;
import tarea2.exception.*;

@Stateless
public class AsignaturaEJB implements GestionExpediente {
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
	public List<Titulacion> obtenerListaTitulacion(Titulacion titulacion) throws TitulacionNoEncontradaException {
		Titulacion titulacionEntity = em.find(Titulacion.class, titulacion.getId());
		if (titulacionEntity == null) {
			throw new TitulacionNoEncontradaException();
		}
		return titulacion.getTitulaciones();
	}
	
	@Override
	public Encuesta obtenerEncuesta (Encuesta encuesta) throws EncuestaNoEncontradaException {
		Encuesta encuestaEntity = em.find(Encuesta.class, encuesta.getId());
		if (encuestaEntity == null) {
			throw new EncuestaNoEncontradaException();
		}
		return encuesta.getEncuestas();
	}
	
	@Override
	public List<Alumno> obtenerListaAlumno (Alumno alumno) throws AlumnoNoEncontradoException {
		Alumno alumnoEntity = em.find(Alumno.class, alumno.getId());
		if (alumnoEntity == null) {
			throw new AlumnoNoEncontradoException();
		}
		return alumno.getAlumnos();
	}
	
	@Override
	public Matricula obtenerMatricula (Matricula matricula) throws MatriculaNoEncontradaException {
		Matricula matriculaEntity = em.find(Matricula.class, matricula.getId());
		if (matriculaEntity == null) {
			throw new MatriculaNoEncontradaException();
		}
		return matricula.getMatriculas();
	}
}
