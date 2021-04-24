package tarea2.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tarea1.jpa.Titulacion;
import tarea2.exception.ProyectoException;

@Stateless
public class GrupoEJB implements GestionGrupo {

	@Override
	public void insertarGrupo(String curso, String letra, String turno_mañana_tarde, Boolean ingles, Boolean visible,
			Boolean asignar, Long plazas, Titulacion nombre) throws ProyectoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eleminarGrupo(Long id) throws ProyectoException {
		// TODO Auto-generated method stub
		
	}

}
