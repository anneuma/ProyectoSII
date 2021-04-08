  
package tarea1.jpa;

import java.io.Serializable;
import javax.persistence.*;


@Entity

public class Optativa extends Asignatura implements Serializable {

	@Column(nullable = false)
	private int Plazas;
	private String Mencion;
	private static final long serialVersionUID = 1L;
	
	public Optativa(int plaz, String menc)
	{
		super();
		this.Plazas = plaz;
		this.Mencion = menc;
	}

	public Optativa() {
		super();
	}   
	public int getPlazas() {
		return this.Plazas;
	}

	public void setPlazas(int Plazas) {
		this.Plazas = Plazas;
	}   
	public String getMencion() {
		return this.Mencion;
	}

	public void setMencion(String Mencion) {
		this.Mencion = Mencion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Mencion == null) ? 0 : Mencion.hashCode());
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
		if (Mencion == null) {
			if (other.Mencion != null)
				return false;
		} else if (!Mencion.equals(other.Mencion))
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
		builder.append(", Mencion=");
		builder.append(Mencion);
		builder.append("]");
		return builder.toString();
	}
   
}
