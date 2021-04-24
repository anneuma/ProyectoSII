package tarea2.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tarea1.jpa.Grupo;
import tarea1.jpa.Grupo_asignatura;
import tarea1.jpa.Titulacion;
import tarea2.exception.*;
/**
*
* @author Francisco José Aragonés de la Rosa
*/
@Stateless
public class GrupoEJB implements GestionGrupo {

	@PersistenceContext(name="ProyectoSII")
	private EntityManager em;

	@Override
	public void insertarGrupo(Grupo grupo) throws GrupoExisteException {
		Grupo grupoEntity = em.find(Grupo.class, grupo.getId());
		if (grupoEntity != null) {
			throw new GrupoExisteException();
		}
		em.persist(grupo);
	}

	@Override
	public void actualizarGrupoTitulacion(Grupo grupo, Titulacion titulacion) throws TitulacionNoEncontradaException, GrupoNoEncontradoException {
		Titulacion TitulacionEntity = em.find(Titulacion.class, titulacion.getCodigo());
		if (TitulacionEntity == null) {
			throw new TitulacionNoEncontradaException();
		}
		Grupo grupoEntity = em.find(Grupo.class, grupo.getId());
		if (grupoEntity == null) {
			throw new GrupoNoEncontradoException();
		}
		grupo.setTitulacion(titulacion);
		em.persist(grupo);
	}

	@Override
	public void actualizarGrupo(Grupo grupo) throws GrupoNoEncontradoException {
		Grupo grupoEntity = em.find(Grupo.class, grupo.getId());
		if (grupoEntity == null) {
			throw new GrupoNoEncontradoException();
		}
		em.merge(grupo);
	}

	@Override
	public void eliminarGrupo(Grupo grupo) throws GrupoNoEncontradoException {
		Grupo grupoEntity = em.find(Grupo.class, grupo.getId());
		if (grupoEntity == null) {
			throw new GrupoNoEncontradoException();
		}
        em.remove(em.merge(grupo));
	}

	@Override
	public Grupo_asignatura obtenerGrupoAsignatura(Grupo grupo) throws GrupoNoEncontradoException {
		Grupo grupoEntity = em.find(Grupo.class, grupo.getId());
		if (grupoEntity == null) {
			throw new GrupoNoEncontradoException();
		}
		return grupo.getGrupo_asignatura();
	}

	@Override
	public List<Grupo> obtenerListaGrupos(Grupo grupo) throws GrupoNoEncontradoException {
		Grupo grupoEntity = em.find(Grupo.class, grupo.getId());
		if (grupoEntity == null) {
			throw new GrupoNoEncontradoException();
		}
		return grupo.getGrupos();
	}

	

}
