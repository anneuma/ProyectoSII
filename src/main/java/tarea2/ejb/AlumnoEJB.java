package tarea2.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tarea1.jpa.Alumno;
import tarea1.jpa.Expediente;
import tarea2.exception.*;

// @autor: Jose Vargas

@Stateless
public class AlumnoEJB implements GestionAlumno {
	
	@PersistenceContext (name="ProyectoSII")
	private EntityManager em;
	
	@Override
	public void insertarAlumno(Alumno alumno) throws AlumnoExisteException
	{
		Alumno alumnoentity = em.find(Alumno.class, alumno.getId());
		if (alumnoentity != null)
		{
			throw new AlumnoExisteException();
		}
		
		em.persist(alumno);
	}
	
	@Override
	public void actualizarAlumno(Alumno alumno) throws AlumnoNoExisteException
	{
		Alumno alumnoentity = em.find(Alumno.class, alumno.getId());
		if (alumnoentity == null)
		{
			throw new AlumnoNoExisteException();
		}
		
		em.merge(alumno);
	}
	
	@Override
	public void eliminarAlumno(Alumno alumno) throws AlumnoNoExisteException
	{
		Alumno alumnoentity = em.find(Alumno.class, alumno.getId());
		if (alumnoentity == null)
		{
			throw new AlumnoNoExisteException();
		}
		
		em.remove(em.merge(alumno));
	}
	
	@Override
	public List<Expediente> obtenerExpedientes(Alumno alumno) throws AlumnoNoExisteException
	{
		Alumno alumnoentity = em.find(Alumno.class, alumno.getId());
		if (alumnoentity == null)
		{
			throw new AlumnoNoExisteException();
		}
		
		return alumno.getExpedientes();
	}
	
	@Override
	public void solicitarCambioHorario(Alumno alumno, String documento) throws AlumnoNoExisteException, DocumentoNoExisteException
	{
		Alumno alumnoentity = em.find(Alumno.class, alumno.getId());
		if (alumnoentity == null)
		{
			throw new AlumnoNoExisteException();
		}
		
		if (documento == null)
		{
			throw new DocumentoNoExisteException();
		}
		
	}
	
	
	
}
