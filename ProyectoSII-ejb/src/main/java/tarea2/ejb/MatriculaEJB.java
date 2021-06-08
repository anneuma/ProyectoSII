package tarea2.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tarea1.jpa.Matricula;
import tarea1.jpa.Asignaturas_matricula;
import tarea1.jpa.Expediente;
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
			throw new MatriculaExisteException();
		}
		
		em.persist(matricula);
	}
	
	@Override
	public void actualizarMatricula(Matricula matricula) throws MatriculaNoExisteException
	{
		Matricula matriculaentity = em.find(Matricula.class, matricula.getId());
		if (matriculaentity == null)
		{
			throw new MatriculaNoExisteException();
		}
		
		em.merge(matricula);
	}
	
	@Override
	public void eliminarMatricula(Matricula matricula) throws MatriculaNoExisteException
	{
		Matricula matriculaentity = em.find(Matricula.class, matricula.getId());
		if (matriculaentity == null)
		{
			throw new MatriculaNoExisteException();
		}
		
		em.remove(em.merge(matricula));
	}
	
	@Override
	public String obtenerAsignaturaMatricula(Matricula matricula) throws MatriculaNoExisteException
	{
		Matricula matriculaentity = em.find(Matricula.class, matricula.getId());
		if (matriculaentity == null)
		{
			throw new MatriculaNoExisteException();
		}
		
		return matricula.getListado_asignaturas();
	}
	
	@Override
	public Expediente obtenerExpedientes(Matricula matricula) throws MatriculaNoExisteException
	{
		Matricula matriculaentity = em.find(Matricula.class, matricula.getId());
		if (matriculaentity == null)
		{
			throw new MatriculaNoExisteException();
		}
		
		return matricula.getExpedientes();
	}
	
	@Override
	public void elegirHorario(Matricula matricula, String horario) throws MatriculaNoExisteException
	{
		Matricula matriculaentity = em.find(Matricula.class, matricula.getId());
		if (matriculaentity == null)
		{
			throw new MatriculaNoExisteException();
		}
		
		matricula.setTurno_preferente(horario);
	}
	
	
}
