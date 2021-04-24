package tarea2.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tarea1.jpa.Matricula;
import tarea1.jpa.Asignaturas_matricula;
import tarea2.exception.*;

// @autor: Jose Vargas

@Stateless
public class MatriculaEJB implements GestionMatricula 
{
	@PersistenceContext (name="ProyectoSII")
	private EntityManager em;
	
	@Override
	public void insertarMatricula(Matricula matricula) throws MatriculaExisteException
	{
		Matricula matriculaentity = em.find(Matricula.class, matricula.getId());
		if (matriculaentity != null)
		{
			throw new MatriculaExisteException("La matricula ya existe")
		}
		
		em.persist(matricula);
	}
	
	@Override
	public void actualizarMatricula(Matricula matricula) throws MatriculaNoExisteException
	{
		Matricula matriculaentity = em.find(Matricula.class, matricula.getId());
		if (matriculaentity == null)
		{
			throw new MatriculaNoExisteException("La matricula no existe");
		}
		
		em.merge(matricula);
	}
	
	@Override
	public void eliminarMatricula(Matricula matricula) throws MatriculaNoExisteException
	{
		Matricula matriculaentity = em.find(Matricula.class, matricula.getId());
		if (matriculaentity == null)
		{
			throw new MatriculaNoExisteException("La matricula no existe");
		}
		
		em.remove(em.merge(matricula));
	}
	
	@Override
	public Asignatura_matricula obtenerAsignaturaMatricula(Matricula matricula) throws MatriculaNoExisteException
	{
		Matricula matriculaentity = em.find(Matricula.class, matricula.getId());
		if (matriculaentity == null)
		{
			throw new MatriculaNoExisteException("La matricula no existe");
		}
		
		return matricula.getAsignaturas_matricula();
	}
	
	@Override
	public List<Expediente> obtenerExpedientes(Matricula matricula) throws MatriculaNoExistenException
	{
		Matricula matriculaentity = em.find(Matricula.class, matricula.getId());
		if (matriculaentity == null)
		{
			throw new MatriculaNoExisteException("La matricula no existe");
		}
		
		return matricula.getExpedientes();
	}
	
	
}