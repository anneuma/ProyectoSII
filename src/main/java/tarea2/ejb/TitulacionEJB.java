package tarea2.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tarea1.jpa.*;
import tarea2.exception.*;

// @autor: Jose Vargas

@Stateless
public class TitulacionEJB implements GestionTitulacion {
	
	@PersistenceContext (name="ProyectoSII")
	private EntityManager em;
	
	@Override
	public void insertarTitulacion(Titulacion titulacion) throws TitulacionExisteException
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getId());
		if (alumnoentity != null)
		{
			throw new AlumnoExisteException("La titulacion ya existe")
		}
		
		em.persist(titulacion);
	}
	
	@Override
	public void actualizarTitulacion(Titulacion titulacion) throws TitulacionNoExisteException
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getId());
		if (titulacionentity == null)
		{
			throw new TitulacionNoExisteException("La titulacion no existe");
		}
		
		em.merge(titulacion);
	}
	
	@Override
	public void eliminarTitulacion titulacionentity = em.find(Titulacion.class, titulacion.getId());
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getId());
		if (titulacionentity == null)
		{
			throw new TitulacionNoExisteException("La titulacion no existe");
		}
		
		em.remove(em.merge(titulacion));
	}
	
	@Override
	public void List<Expediente> obtenerExpedientes(Titulacion titulacion) throws AlumnoNoExistenteException
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getId());
		if (titulacionentity == null)
		{
			throw new TitulacionNoExisteException("La titulacion no existe");
		}
		
		return titulacion.getExpedientes();
	}
	
	@Override
	public void List<Centro> obtenerCentros(Titulacion titulacion) throws AlumnoNoExistenteException
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getId());
		if (titulacionentity == null)
		{
			throw new TitulacionNoExisteException("La titulacion no existe");
		}
		
		return titulacion.getCentros();
	}
	
	@Override
	public void List<Grupo> obtenerGrupos(Titulacion titulacion) throws AlumnoNoExistenteException
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getId());
		if (titulacionentity == null)
		{
			throw new TitulacionNoExisteException("La titulacion no existe");
		}
		
		return titulacion.getGrupos();
	}
	
	@Override
	public void List<Asignatura> obtenerAsignaturas(Titulacion titulacion) throws AlumnoNoExistenteException
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getId());
		if (titulacionentity == null)
		{
			throw new TitulacionNoExisteException("La titulacion no existe");
		}
		
		return titulacion.getAsignaturas();
	}
	
	
	
	
	
	
	
}