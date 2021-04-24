package tarea2.ejb;

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
			throw new AlumnoExisteException("El alumno ya existe")
		}
		
		em.persist(alumno);
	}
	
	@Override
	public void actualizarAlumno(Alumno alumno) throws AlumnoNoExisteException
	{
		Alumno alumnoentity = em.find(Alumno.class, alumno.getId());
		if (alumnoentity == null)
		{
			throw new AlumnoNoExisteException("El alumno no existe");
		}
		
		em.merge(alumno);
	}
	
	@Override
	public void eliminarAlumno(Alumno alumno) throws AlumnoNoExistenteException
	{
		Alumno alumnoentity = em.find(Alumno.class, alumno.getId());
		if (alumnoentity == null)
		{
			throw new AlumnoNoExisteException("El alumno no existe");
		}
		
		em.remove(em.merge(alumno));
	}
	
	@Override
	public void List<Expediente> obtenerExpedientes(Alumno alumno) throws AlumnoNoExistenteException
	{
		Alumno alumnoentity = em.find(Alumno.class, alumno.getId());
		if (alumnoentity == null)
		{
			throw new AlumnoNoExisteException("El alumno no existe");
		}
		
		return alumno.getExpedientes();
	}
	
	@Override
	public void public void solicitarCambioHorario(Alumno alumno, String documento) throws AlumnoNoExistenteException, DocumentoNoExistenteException
	{
		Alumno alumnoentity = em.find(Alumno.class, alumno.getId());
		if (alumnoentity == null)
		{
			throw new AlumnoNoExisteException("El alumno no existe");
		}
		
		if (documento == null)
		{
			throw new DocumentoNoExistenteException("El documento para solicitar el cambio no existe");
		}
		
	}
	
	
	
}
