package tarea2.ejb;

import java.util.List;

import javax.ejb.Local;

import tarea1.jpa.*;
import tarea2.exception.GrupoNoEncontradoException;
import tarea2.exception.ProyectoException;;
/**
*
* @author Francisco José Aragonés de la Rosa
*/
@Local
public interface GestionGrupo {
	
	public void insertarGrupo(Grupo grupo) throws ProyectoException;
	
	public void actualizarGrupoTitulacion(Grupo grupo, Titulacion titulacion) throws ProyectoException;
	
	public void actualizarGrupo(Grupo grupo) throws ProyectoException;

	public void eliminarGrupo(Grupo grupo) throws ProyectoException;
	
	public Grupo_asignatura obtenerGrupoAsignatura(Grupo grupo) throws ProyectoException;
	
	public List<Grupo> obtenerListaGrupos() throws ProyectoException;
	
	public void asignarGrupo(Matricula matricula) throws ProyectoException;

	public List<Grupo> obtenerListaGruposRelacionados(Grupo grupo) throws GrupoNoEncontradoException;
}
