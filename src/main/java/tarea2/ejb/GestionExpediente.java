package tarea2.ejb;

import java.util.List;
import javax.ejb.Local;
import tarea1.jpa.*;
import tarea2.exception.ProyectoException;

@Local
public interface GestionExpediente {
	
	public void modificarExpediente(Expediente expediente) throws ProyectoException;

	public void eliminarExpediente(Expediente expediente) throws ProyectoException;
	
	public List<Titulacion> obtenerListaTitulacion(Titulacion titulacion) throws ProyectoException;
	
	public Encuesta obtenerEncuesta (Encuesta encuesta) throws ProyectoException;
	
	public List<Alumno> obtenerListaAlumno (Alumno alumno) throws ProyectoException;
	
	public Matricula obtenerMatricula (Matricula matricula) throws ProyectoException;
}
