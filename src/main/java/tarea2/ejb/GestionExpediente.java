package tarea2.ejb;

import java.util.List;
import javax.ejb.Local;
import tarea1.jpa.*;
import tarea2.exception.AlumnoNoEncontradoException;
import tarea2.exception.ProyectoException;
import tarea2.exception.TitulacionNoEncontradaException;

@Local
public interface GestionExpediente {
	
	public void modificarExpediente(Expediente expediente) throws ProyectoException;

	public void eliminarExpediente(Expediente expediente) throws ProyectoException;
		
	public Encuesta obtenerEncuesta (Encuesta encuesta) throws ProyectoException;
		
	public Matricula obtenerMatricula (Matricula matricula) throws ProyectoException;

	public Alumno obtenerAlumno(Alumno alumno) throws ProyectoException;

	public Titulacion obtenerTitulacion(Titulacion titulacion) throws ProyectoException;
}
