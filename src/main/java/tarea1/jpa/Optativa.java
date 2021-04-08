package es.informatica.uma.ProyectoGrupo;

import es.informatica.uma.ProyectoGrupo.Asignatura;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Optativa
 *
 */
@Entity

public class Optativa extends Asignatura implements Serializable {

	
	private int Plazas;
	private String Mención;
	private static final long serialVersionUID = 1L;

	public Optativa() {
		super();
	}   
	public int getPlazas() {
		return this.Plazas;
	}

	public void setPlazas(int Plazas) {
		this.Plazas = Plazas;
	}   
	public String getMención() {
		return this.Mención;
	}

	public void setMención(String Mención) {
		this.Mención = Mención;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Mención == null) ? 0 : Mención.hashCode());
		result = prime * result + Plazas;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Optativa other = (Optativa) obj;
		if (Mención == null) {
			if (other.Mención != null)
				return false;
		} else if (!Mención.equals(other.Mención))
			return false;
		if (Plazas != other.Plazas)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Optativa [Plazas=");
		builder.append(Plazas);
		builder.append(", Mención=");
		builder.append(Mención);
		builder.append("]");
		return builder.toString();
	}
   
}
