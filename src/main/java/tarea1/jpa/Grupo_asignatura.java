package tarea1.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Grupo_asignatura implements Serializable {

	@Id
	private String curso_academico;
	private String oferta;
	
	@OneToMany(targetEntity=Grupo.class)
	private List<Grupo> grupo;
	
	@ManyToMany
	private List<Encuesta> encuestas;
	
	@OneToMany(targetEntity=Asignatura.class)
	private List<Asignatura> asignatura;
	
	
	private static final long serialVersionUID = 1L;
	
	public Grupo_asignatura(String curso_academico, String oferta, List<Grupo> grupo, List<Encuesta> encuestas,
			List<Asignatura> asignatura) {
		super();
		this.curso_academico = curso_academico;
		this.oferta = oferta;
		this.grupo = grupo;
		this.encuestas = encuestas;
		this.asignatura = asignatura;
	}
	
	public Grupo_asignatura() {
		super();
	}
	
	public String getCurso_academico() {
		return curso_academico;
	}
	public void setCurso_academico(String curso_academico) {
		this.curso_academico = curso_academico;
	}
	public String getOferta() {
		return oferta;
	}
	public void setOferta(String oferta) {
		this.oferta = oferta;
	}
	
	public List<Grupo> getGrupo() {
		return grupo;
	}
	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}
	public List<Encuesta> getEncuestas() {
		return encuestas;
	}
	public void setEncuestas(List<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}
	public List<Asignatura> getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(List<Asignatura> asignatura) {
		this.asignatura = asignatura;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((curso_academico == null) ? 0 : curso_academico.hashCode());
		result = prime * result + ((encuestas == null) ? 0 : encuestas.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((oferta == null) ? 0 : oferta.hashCode());
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
		Grupo_asignatura other = (Grupo_asignatura) obj;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (curso_academico == null) {
			if (other.curso_academico != null)
				return false;
		} else if (!curso_academico.equals(other.curso_academico))
			return false;
		if (encuestas == null) {
			if (other.encuestas != null)
				return false;
		} else if (!encuestas.equals(other.encuestas))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (oferta == null) {
			if (other.oferta != null)
				return false;
		} else if (!oferta.equals(other.oferta))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Grupo_asignatura [curso_academico=" + curso_academico + ", oferta=" + oferta + ", grupo=" + grupo
				+ ", encuestas=" + encuestas + ", asignatura=" + asignatura + "]";
	}
	
}
