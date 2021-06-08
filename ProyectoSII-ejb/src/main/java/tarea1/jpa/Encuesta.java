package tarea1.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */
@Entity

public class Encuesta implements Serializable {

	   
	@Id
	private Integer id;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha_envio;
	
	@ManyToMany(mappedBy = "encuestas")
	private List<Grupo_asignatura> grupo_asignaturas;
	
	@ManyToOne
	private Expediente expedientes;
	
	private static final long serialVersionUID = 1L;

	public Encuesta(Integer id, Date fecha_envio, List<Grupo_asignatura> grupo_asignaturas,
			Expediente expedientes) {
		super();
		this.id = id;
		this.fecha_envio = fecha_envio;
		this.grupo_asignaturas = grupo_asignaturas;
		this.expedientes = expedientes;
	}
	public Encuesta() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Date getFecha_envio() {
		return this.fecha_envio;
	}

	public void setFecha_envio(Date fecha_envio) {
		this.fecha_envio = fecha_envio;
	}
	
	public Expediente getExpedientes () {
		return expedientes;
	}
	
	public void setExpedientes (Expediente expedientes) {
		this.expedientes = expedientes;
	}
	
	public List<Grupo_asignatura> getGrupos_Por_Asignatura () {
		return grupo_asignaturas;
	}
	
	public void setGrupo_Asignatura (List<Grupo_asignatura> grupo_asignatura) {
		this.grupo_asignaturas = grupo_asignatura;
	}
	
	public List<Grupo_asignatura> getGrupo_asignaturas() {
		return grupo_asignaturas;
	}
	public void setGrupo_asignaturas(List<Grupo_asignatura> grupo_asignaturas) {
		this.grupo_asignaturas = grupo_asignaturas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
		result = prime * result + ((fecha_envio == null) ? 0 : fecha_envio.hashCode());
		result = prime * result + ((grupo_asignaturas == null) ? 0 : grupo_asignaturas.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Encuesta other = (Encuesta) obj;
		if (expedientes == null) {
			if (other.expedientes != null)
				return false;
		} else if (!expedientes.equals(other.expedientes))
			return false;
		if (fecha_envio == null) {
			if (other.fecha_envio != null)
				return false;
		} else if (!fecha_envio.equals(other.fecha_envio))
			return false;
		if (grupo_asignaturas == null) {
			if (other.grupo_asignaturas != null)
				return false;
		} else if (!grupo_asignaturas.equals(other.grupo_asignaturas))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Encuesta [id=" + id + ", fecha_envio=" + fecha_envio + ", grupo_asignaturas=" + grupo_asignaturas
				+ ", expedientes=" + expedientes + "]";
	}
  
	
}
