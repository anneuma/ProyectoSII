package tarea2.ejb;

import java.util.List;

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
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getCodigo());
		if (titulacionentity != null)
		{
			throw new TitulacionExisteException();
		}
		
		em.persist(titulacion);
	}
	
	@Override
	public void actualizarTitulacion(Titulacion titulacion) throws TitulacionNoExisteException
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getCodigo());
		if (titulacionentity == null)
		{
			throw new TitulacionNoExisteException();
		}
		
		em.merge(titulacion);
	}
	
	@Override
	public void eliminarTitulacion(Titulacion titulacion) throws TitulacionNoExisteException
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getCodigo());
		if (titulacionentity == null)
		{
			throw new TitulacionNoExisteException();
		}
		
		em.remove(em.merge(titulacion));
	}
	
	@Override
	public List<Expediente> obtenerExpedientes(Titulacion titulacion) throws TitulacionNoExisteException
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getCodigo());
		if (titulacionentity == null)
		{
			throw new TitulacionNoExisteException();
		}
		
		return titulacion.getExpedientes();
	}
	
	@Override
	public List<Centro> obtenerCentros(Titulacion titulacion) throws TitulacionNoExisteException
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getCodigo());
		if (titulacionentity == null)
		{
			throw new TitulacionNoExisteException();
		}
		
		return titulacion.getCentros();
	}
	
	@Override
	public List<Grupo> obtenerGrupos(Titulacion titulacion) throws TitulacionNoExisteException
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getCodigo());
		if (titulacionentity == null)
		{
			throw new TitulacionNoExisteException();
		}
		
		return titulacion.getGrupos();
	}
	
	@Override
	public List<Asignatura> obtenerAsignaturas(Titulacion titulacion) throws TitulacionNoExisteException
	{
		Titulacion titulacionentity = em.find(Titulacion.class, titulacion.getCodigo());
		if (titulacionentity == null)
		{
			throw new TitulacionNoExisteException();
		}
		
		return titulacion.getAsignaturas();
	}
	
	
	
	
	
	
	
}
