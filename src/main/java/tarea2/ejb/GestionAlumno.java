package tarea2.ejb;

import javax.ejb.Local;

import tarea1.jpa.*;
import tarea2.exception.ProyectoException;

// @autor: José Vargas

@Local
public interface GestionAlumno {
	
	public void insertarAlumno(Alumno alumno) throws ProyectoException;
	
	
	public void actualizarAlumno(Alumno alumno) throws ProyectoException;
	
	
	public void eliminarAlumno(Alumno alumno) throws ProyectoException;
	
	
	public List<Expediente> obtenerExpedientes(Alumno alumno) throws ProyectoException;
	
	
	
	
	
}