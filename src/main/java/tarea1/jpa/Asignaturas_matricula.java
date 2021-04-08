package tarea1.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignaturas_matricula
 *
 */
@Entity

public class Asignaturas_matricula implements Serializable {

	@Id
	private Long id;
	private Integer Calificacion;
	
	@ManyToOne(targetEntity=Matricula.class)
	private List<Matricula> matriculas;
	
	@ManyToOne
	private List<Asignatura> asignatura;
	
	@ManyToOne
	private List<Grupo> grupo;
	
	private static final long serialVersionUID = 1L;

	public Asignaturas_matricula() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Integer getCalificacion() {
		return this.Calificacion;
	}

	public void setCalificacion(Integer Calificacion) {
		this.Calificacion = Calificacion;
	}
	
	public List<Asignatura> getAsignatura () {
		return asignatura;
	}
	
	public void setAsignatura (List<Asignatura> asignatura) {
		this.asignatura = asignatura;
	}
	
	public List<Grupo> getGrupo () {
		return grupo;
	}
	
	public void setGrupo (List<Grupo> grupo) {
		this.grupo = grupo;
	}
	
	public List<Matricula> getMatricula () {
		return matriculas;
	}
	
	public void setMatricula (List<Matricula> matricula) {
		this.matriculas = matricula;
	}
}
