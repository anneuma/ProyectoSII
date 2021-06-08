package tarea2.ejb;

import java.util.List;

import javax.ejb.Local;

import tarea1.jpa.*;
import tarea2.exception.GrupoExisteException;
import tarea2.exception.GrupoNoEncontradoException;
import tarea2.exception.ProyectoException;
import tarea2.exception.TitulacionNoEncontradaException;;
/**
*
* @author Francisco José Aragonés de la Rosa
*/
@Local
public interface GestionGrupo {
	
	public void insertarGrupo(Grupo grupo, Long titulacioncodigo) throws ProyectoException;
	
	public void actualizarGrupo(Grupo grupo) throws ProyectoException;

	public void eliminarGrupo(Grupo grupo) throws ProyectoException;
	
	public List<Grupo_asignatura> obtenerGrupoAsignatura(Grupo grupo) throws ProyectoException;
	
	public List<Grupo> obtenerListaGrupos() throws ProyectoException;
	
	public void asignarGrupo(Matricula matricula) throws ProyectoException;

	public List<Grupo> obtenerListaGruposRelacionados(Grupo grupo) throws ProyectoException;

	public void actualizarGrupoTitulacion(Grupo grupo, Long titulacioncodigo) throws ProyectoException;

	Titulacion obtenerTitulacion(long titulacioncodigo) throws ProyectoException;

}
