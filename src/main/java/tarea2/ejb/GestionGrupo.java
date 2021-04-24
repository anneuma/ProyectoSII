package tarea2.ejb;

import javax.ejb.Local;

import tarea1.jpa.*;
import tarea2.exception.ProyectoException;;

@Local
public interface GestionGrupo {
	
	public void insertarGrupo(String curso, String letra, String turno_mañana_tarde, Boolean ingles, Boolean visible, Boolean asignar, Long plazas, Titulacion nombre) throws ProyectoException;

	public void eleminarGrupo(Long id) throws ProyectoException;
}
