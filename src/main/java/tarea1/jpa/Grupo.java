package tarea1.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Grupo implements Serializable {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String curso;
	@Column(nullable = false)
	private String letra;
	private String turno_mañana_tarde;
	private Boolean ingles;
	private Boolean visible;
	private Boolean asignar;
	private Long plazas;
	
	@ManyToOne
	private Grupo_asignatura grupo_asignatura;
	
	@ManyToOne
	private Grupo grupo;
	
	@OneToMany(targetEntity=Grupo.class)
	private List<Grupo> grupos;
	
	@OneToMany(targetEntity=Titulacion.class)
	private List<Titulacion> titulacion;
	
	private static final long serialVersionUID = 1L;
	
	public Grupo(Long id, String curso, String letra, String turno_mañana_tarde, Boolean ingles, Boolean visible,
			Boolean asignar, Long plazas) {
		super();
		this.id = id;
		this.curso = curso;
		this.letra = letra;
		this.turno_mañana_tarde = turno_mañana_tarde;
		this.ingles = ingles;
		this.visible = visible;
		this.asignar = asignar;
		this.plazas = plazas;
	}
	
	public Grupo() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getTurno_mañana_tarde() {
		return turno_mañana_tarde;
	}
	public void setTurno_mañana_tarde(String turno_mañana_tarde) {
		this.turno_mañana_tarde = turno_mañana_tarde;
	}
	public Boolean getIngles() {
		return ingles;
	}
	public void setIngles(Boolean ingles) {
		this.ingles = ingles;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public Boolean getAsignar() {
		return asignar;
	}
	public void setAsignar(Boolean asignar) {
		this.asignar = asignar;
	}
	public Long getPlazas() {
		return plazas;
	}
	public void setPlazas(Long plazas) {
		this.plazas = plazas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignar == null) ? 0 : asignar.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingles == null) ? 0 : ingles.hashCode());
		result = prime * result + ((letra == null) ? 0 : letra.hashCode());
		result = prime * result + ((plazas == null) ? 0 : plazas.hashCode());
		result = prime * result + ((turno_mañana_tarde == null) ? 0 : turno_mañana_tarde.hashCode());
		result = prime * result + ((visible == null) ? 0 : visible.hashCode());
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
		Grupo other = (Grupo) obj;
		if (asignar == null) {
			if (other.asignar != null)
				return false;
		} else if (!asignar.equals(other.asignar))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingles == null) {
			if (other.ingles != null)
				return false;
		} else if (!ingles.equals(other.ingles))
			return false;
		if (letra == null) {
			if (other.letra != null)
				return false;
		} else if (!letra.equals(other.letra))
			return false;
		if (plazas == null) {
			if (other.plazas != null)
				return false;
		} else if (!plazas.equals(other.plazas))
			return false;
		if (turno_mañana_tarde == null) {
			if (other.turno_mañana_tarde != null)
				return false;
		} else if (!turno_mañana_tarde.equals(other.turno_mañana_tarde))
			return false;
		if (visible == null) {
			if (other.visible != null)
				return false;
		} else if (!visible.equals(other.visible))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", curso=" + curso + ", letra=" + letra + ", turno_mañana_tarde="
				+ turno_mañana_tarde + ", ingles=" + ingles + ", visible=" + visible + ", asignar=" + asignar
				+ ", plazas=" + plazas + "]";
	}
	
}
