package tarea2.ejb;

import java.util.List;

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
	
	
	public List<Grupo> obtenerGrupos(Titulacion titulacion) throws ProyectoException;
	
	public List<Asignatura> obtenerAsignaturas(Titulacion titulacion) throws ProyectoException;
	
	public  List<Centro> obtenerCentros(Titulacion titulacion) throws ProyectoException;
}