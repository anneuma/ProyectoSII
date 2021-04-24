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
	
	@OneToMany(targetEntity=Asignatura.class)
	private List<Asignatura> asignatura;
	
	@OneToMany(targetEntity=Grupo.class)
	private List<Grupo> grupo;
	
	private static final long serialVersionUID = 1L;

	
	public Asignaturas_matricula(Long id, Integer calificacion, List<Matricula> matriculas, List<Asignatura> asignatura,
			List<Grupo> grupo) {
		super();
		this.id = id;
		Calificacion = calificacion;
		this.matriculas = matriculas;
		this.asignatura = asignatura;
		this.grupo = grupo;
	}
	
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
	
	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Calificacion == null) ? 0 : Calificacion.hashCode());
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matriculas == null) ? 0 : matriculas.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignaturas_matricula other = (Asignaturas_matricula) obj;
		if (Calificacion == null) {
			if (other.Calificacion != null)
				return false;
		} else if (!Calificacion.equals(other.Calificacion))
			return false;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matriculas == null) {
			if (other.matriculas != null)
				return false;
		} else if (!matriculas.equals(other.matriculas))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Asignaturas_matricula [id=" + id + ", Calificacion=" + Calificacion + ", matriculas=" + matriculas
				+ ", asignatura=" + asignatura + ", grupo=" + grupo + "]";
	}
	
	
	
}
