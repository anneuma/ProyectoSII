ackage tarea2.ejb;

import javax.ejb.Local;

import tarea1.jpa.*;
import tarea2.exception.ProyectoException;

// @autor: José Vargas

@Local
public interface GestionTitulacion {
	
	public void insertarTitulacion(Titulacion titulacion) throws ProyectoException;
	
	
	public void actualizarTitulacion(Titulacion titulacion) throws ProyectoException;
	
	
	public void eliminarTitulacion(Titulacion titulacion) throws ProyectoException;
	
	
	public List<Expediente> obtenerExpedientes(Titulacion titulacion) throws ProyectoException;
	
	
	public List<Expediente> obtenerGrupos(Titulacion titulacion) throws ProyectoException;
	
	public List<Expediente> obtenerAsignaturas(Titulacion titulacion) throws ProyectoException;
	
	public List<Expediente> obtenerCentros(Titulacion titulacion) throws ProyectoException;
}