package tarea2.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tarea1.jpa.Alumno;
import tarea1.jpa.Asignaturas_matricula;
import tarea1.jpa.Expediente;
import tarea1.jpa.Grupo;
import tarea1.jpa.Grupo_asignatura;
import tarea1.jpa.Matricula;
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
		em.merge(grupo);
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
	public List<Grupo> obtenerListaGruposRelacionados(Grupo grupo) throws GrupoNoEncontradoException {
		Grupo grupoEntity = em.find(Grupo.class, grupo.getId());
		if (grupoEntity == null) {
			throw new GrupoNoEncontradoException();
		}
		return grupo.getGrupos();
	}

	@Override
	public void asignarGrupo(Matricula matricula) throws MatriculaNoEncontradaException {
		Matricula matriculaEntity = em.find(Matricula.class, matricula.getId());
		if (matriculaEntity == null) {
			throw new MatriculaNoEncontradaException();
		}
		Grupo grupo1A = new Grupo((long) 1, "primero", "A", "mañana", false, true, true, (long) 42);
		for (Asignaturas_matricula asig: matricula.getAsignaturas_matricula()) {
			asig.setGrupo(grupo1A);
		}
	}

	@Override
	public List<Grupo> obtenerListaGrupos() throws ProyectoException {
		Query query = em.createQuery("SELECT g FROM Grupo g");
		List<Grupo> grupos = query.getResultList();
		return grupos;
	}
}
