package tarea1.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Expediente
 *
 */
@Entity

public class Expediente implements Serializable {

	   
	@Id
	private Long num_expediente;
	private Boolean activo;
	private Long nota_media_provisional;
	
	@ManyToOne
	private List<Matricula> matriculas;
	
	private List<Encuesta> encuestas;
	
	private static final long serialVersionUID = 1L;

	public Expediente() {

	}   
	public long getNum_expediente() {
		return this.num_expediente;
	}

	public void setNum_expediente(long num_expediente) {
		this.num_expediente = num_expediente;
	}   
	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}   
	public long getNota_media_provisional() {
		return this.nota_media_provisional;
	}

	public void setNota_media_provisional(long nota_media_provisional) {
		this.nota_media_provisional = nota_media_provisional;
	}
	
	public List<Matricula>  getMatriculas()
	{
		return this.matriculas;
	}
	
	public void setMatriculas (List<Matricula> matr)
	{
		this.matriculas = matr;
	}
	
	public List<Encuesta>  getEncuestas()
	{
		return this.encuestas;
	}
	
	public void setEncuestas (List<Encuesta> enc)
	{
		this.encuestas = enc;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activo ? 1231 : 1237);
		result = (int) (prime * result + nota_media_provisional);
		result = (int) (prime * result + num_expediente);
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
		Expediente other = (Expediente) obj;
		if (activo != other.activo)
			return false;
		if (nota_media_provisional != other.nota_media_provisional)
			return false;
		if (num_expediente != other.num_expediente)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Expediente [Numero_expediente=");
		builder.append(num_expediente);
		builder.append(", Activo=");
		builder.append(activo);
		builder.append(", Nota_Media_Provisional=");
		builder.append(nota_media_provisional);
		builder.append("]");
		return builder.toString();
	}
   
}
