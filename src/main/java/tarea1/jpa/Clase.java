package tarea1.jpa;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Clase implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String dia;
	@Id
	private String hora_inicio;
	private String hora_fin;
	private String aula;
	@ManyToOne
	private List<Asignatura> asignatura;
	@ManyToOne
	private List<Grupo> grupo;
	
	public String getDia () {
		return dia;
	}
	
	public void setDia (String dia) {
		this.dia = dia;
	}
	
	public String getHora_Inicio () {
		return hora_inicio;
	}
	
	public void setHora_Inicio (String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	
	public String getHora_Fin () {
		return hora_fin;
	}
	
	public void setHora_Fin (String hora_fin) {
		this.hora_fin = hora_fin;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((aula == null) ? 0 : aula.hashCode());
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((hora_fin == null) ? 0 : hora_fin.hashCode());
		result = prime * result + ((hora_inicio == null) ? 0 : hora_inicio.hashCode());
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
		Clase other = (Clase) obj;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (aula == null) {
			if (other.aula != null)
				return false;
		} else if (!aula.equals(other.aula))
			return false;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (hora_fin == null) {
			if (other.hora_fin != null)
				return false;
		} else if (!hora_fin.equals(other.hora_fin))
			return false;
		if (hora_inicio == null) {
			if (other.hora_inicio != null)
				return false;
		} else if (!hora_inicio.equals(other.hora_inicio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Clase [dia=" + dia + ", hora_inicio=" + hora_inicio + ", hora_fin=" + hora_fin + ", aula=" + aula
				+ ", asignatura=" + asignatura + ", grupo=" + grupo + "]";
	}
	
}
