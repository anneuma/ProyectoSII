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
	
	@OneToMany(targetEntity=Matricula.class)
	private List<Matricula> matriculas;
	
	@OneToMany(targetEntity=Encuesta.class)
	private List<Encuesta> encuestas;
	
	@ManyToOne
	private Titulacion titulacion;
	
	@ManyToOne
	private Alumno alumno;
	
	private static final long serialVersionUID = 1L;

	public Expediente(Long num_expediente, Boolean activo, Long nota_media_provisional, List<Matricula> matriculas,
			List<Encuesta> encuestas) {
		super();
		this.num_expediente = num_expediente;
		this.activo = activo;
		this.nota_media_provisional = nota_media_provisional;
		this.matriculas = matriculas;
		this.encuestas = encuestas;
	}
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
	
	public void setNum_expediente(Long num_expediente) {
		this.num_expediente = num_expediente;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public void setNota_media_provisional(Long nota_media_provisional) {
		this.nota_media_provisional = nota_media_provisional;
	}
	
	public Titulacion getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activo == null) ? 0 : activo.hashCode());
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((encuestas == null) ? 0 : encuestas.hashCode());
		result = prime * result + ((matriculas == null) ? 0 : matriculas.hashCode());
		result = prime * result + ((nota_media_provisional == null) ? 0 : nota_media_provisional.hashCode());
		result = prime * result + ((num_expediente == null) ? 0 : num_expediente.hashCode());
		result = prime * result + ((titulacion == null) ? 0 : titulacion.hashCode());
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
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (encuestas == null) {
			if (other.encuestas != null)
				return false;
		} else if (!encuestas.equals(other.encuestas))
			return false;
		if (matriculas == null) {
			if (other.matriculas != null)
				return false;
		} else if (!matriculas.equals(other.matriculas))
			return false;
		if (nota_media_provisional == null) {
			if (other.nota_media_provisional != null)
				return false;
		} else if (!nota_media_provisional.equals(other.nota_media_provisional))
			return false;
		if (num_expediente == null) {
			if (other.num_expediente != null)
				return false;
		} else if (!num_expediente.equals(other.num_expediente))
			return false;
		if (titulacion == null) {
			if (other.titulacion != null)
				return false;
		} else if (!titulacion.equals(other.titulacion))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Expediente [num_expediente=" + num_expediente + ", activo=" + activo + ", nota_media_provisional="
				+ nota_media_provisional + ", matriculas=" + matriculas + ", encuestas=" + encuestas + ", titulacion="
				+ titulacion + ", alumno=" + alumno + "]";
	}
	

	
   
}
