package tarea1.jpa;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Asignatura implements Serializable {
	
	@Id
	private Long referencia;
	@Column(nullable = false)
	private Long codigo;
	@Column(nullable = false)
	private Integer creditos_totales;
	@Column(nullable = false)
	private Integer creditos_practicos;
	@Column(nullable = false)
	private Integer creditos_teoricos;
	@Column(nullable = false)
	private Integer oferta;
	@Column(nullable = false)
	private String nombre;
	private String curso;
	private String caracter;
	private String duracion;
	private String unidad_temporal;
	private String idiomas;
	
	@ManyToOne 
	private Grupo_asignatura grupo_asignatura;
	
	private static final long serialVersionUID = 1L;
	
	public Asignatura(){
		
	}

	public Long getReferencia() {
		return referencia;
	}

	public void setReferencia(Long referencia) {
		this.referencia = referencia;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getCreditos_totales() {
		return creditos_totales;
	}

	public void setCreditos_totales(Integer creditos_totales) {
		this.creditos_totales = creditos_totales;
	}

	public Integer getCreditos_practicos() {
		return creditos_practicos;
	}

	public void setCreditos_practicos(Integer creditos_practicos) {
		this.creditos_practicos = creditos_practicos;
	}

	public Integer getCreditos_teoricos() {
		return creditos_teoricos;
	}

	public void setCreditos_teoricos(Integer creditos_teoricos) {
		this.creditos_teoricos = creditos_teoricos;
	}

	public Integer getOferta() {
		return oferta;
	}

	public void setOferta(Integer oferta) {
		this.oferta = oferta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCaracter() {
		return caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getUnidad_temporal() {
		return unidad_temporal;
	}

	public void setUnidad_temporal(String unidad_temporal) {
		this.unidad_temporal = unidad_temporal;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public Grupo_asignatura getGrupo_asignatura() {
		return grupo_asignatura;
	}

	public void setGrupo_asignatura(Grupo_asignatura grupo_asignatura) {
		this.grupo_asignatura = grupo_asignatura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caracter == null) ? 0 : caracter.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((creditos_practicos == null) ? 0 : creditos_practicos.hashCode());
		result = prime * result + ((creditos_teoricos == null) ? 0 : creditos_teoricos.hashCode());
		result = prime * result + ((creditos_totales == null) ? 0 : creditos_totales.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((grupo_asignatura == null) ? 0 : grupo_asignatura.hashCode());
		result = prime * result + ((idiomas == null) ? 0 : idiomas.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((oferta == null) ? 0 : oferta.hashCode());
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		result = prime * result + ((unidad_temporal == null) ? 0 : unidad_temporal.hashCode());
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
		Asignatura other = (Asignatura) obj;
		if (caracter == null) {
			if (other.caracter != null)
				return false;
		} else if (!caracter.equals(other.caracter))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (creditos_practicos == null) {
			if (other.creditos_practicos != null)
				return false;
		} else if (!creditos_practicos.equals(other.creditos_practicos))
			return false;
		if (creditos_teoricos == null) {
			if (other.creditos_teoricos != null)
				return false;
		} else if (!creditos_teoricos.equals(other.creditos_teoricos))
			return false;
		if (creditos_totales == null) {
			if (other.creditos_totales != null)
				return false;
		} else if (!creditos_totales.equals(other.creditos_totales))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (grupo_asignatura == null) {
			if (other.grupo_asignatura != null)
				return false;
		} else if (!grupo_asignatura.equals(other.grupo_asignatura))
			return false;
		if (idiomas == null) {
			if (other.idiomas != null)
				return false;
		} else if (!idiomas.equals(other.idiomas))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (oferta == null) {
			if (other.oferta != null)
				return false;
		} else if (!oferta.equals(other.oferta))
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		if (unidad_temporal == null) {
			if (other.unidad_temporal != null)
				return false;
		} else if (!unidad_temporal.equals(other.unidad_temporal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asignatura [referencia=" + referencia + ", codigo=" + codigo + ", creditos_totales=" + creditos_totales
				+ ", creditos_practicos=" + creditos_practicos + ", creditos_teoricos=" + creditos_teoricos
				+ ", oferta=" + oferta + ", nombre=" + nombre + ", curso=" + curso + ", caracter=" + caracter
				+ ", duracion=" + duracion + ", unidad_temporal=" + unidad_temporal + ", idiomas=" + idiomas
				+ ", grupo_asignatura=" + grupo_asignatura + "]";
	}
	
	
}
