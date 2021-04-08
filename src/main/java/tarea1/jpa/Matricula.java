package tarea1.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
public class Matricula implements Serializable {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String curso_academico;
	private String estado;
	private Long num_archivo;
	private String turno_preferente;
	@Temporal(TemporalType.DATE)
	private Date fecha_matricula;
	private Boolean nuevo_ingreso;
	private List<Asignatura> listado_asignaturas;
	
	@OneToMany (targetEntity=Expediente.class)
	private List<Expediente> expedientes;
	
	@ManyToOne
	private Asignaturas_matricula asignaturas_matricula;
	
	private static final long serialVersionUID = 1L;
	
	public Matricula(Long id, String curso_academico, String estado, Long num_archivo, String turno_preferente,
			Date fecha_matricula, Boolean nuevo_ingreso, List<Asignatura> listado_asignaturas) {
		super();
		this.id = id;
		this.curso_academico = curso_academico;
		this.estado = estado;
		this.num_archivo = num_archivo;
		this.turno_preferente = turno_preferente;
		this.fecha_matricula = fecha_matricula;
		this.nuevo_ingreso = nuevo_ingreso;
		this.listado_asignaturas = listado_asignaturas;
	}
	public Matricula() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurso_academico() {
		return curso_academico;
	}
	public void setCurso_academico(String curso_academico) {
		this.curso_academico = curso_academico;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getNum_archivo() {
		return num_archivo;
	}
	public void setNum_archivo(Long num_archivo) {
		this.num_archivo = num_archivo;
	}
	public String getTurno_preferente() {
		return turno_preferente;
	}
	public void setTurno_preferente(String turno_preferente) {
		this.turno_preferente = turno_preferente;
	}
	public Date getFecha_matricula() {
		return fecha_matricula;
	}
	public void setFecha_matricula(Date fecha_matricula) {
		this.fecha_matricula = fecha_matricula;
	}
	public Boolean getNuevo_ingreso() {
		return nuevo_ingreso;
	}
	public void setNuevo_ingreso(Boolean nuevo_ingreso) {
		this.nuevo_ingreso = nuevo_ingreso;
	}
	public List<Asignatura> getListado_asignaturas() {
		return listado_asignaturas;
	}
	public void setListado_asignaturas(List<Asignatura> listado_asignaturas) {
		this.listado_asignaturas = listado_asignaturas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso_academico == null) ? 0 : curso_academico.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha_matricula == null) ? 0 : fecha_matricula.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listado_asignaturas == null) ? 0 : listado_asignaturas.hashCode());
		result = prime * result + ((nuevo_ingreso == null) ? 0 : nuevo_ingreso.hashCode());
		result = prime * result + ((num_archivo == null) ? 0 : num_archivo.hashCode());
		result = prime * result + ((turno_preferente == null) ? 0 : turno_preferente.hashCode());
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
		Matricula other = (Matricula) obj;
		if (curso_academico == null) {
			if (other.curso_academico != null)
				return false;
		} else if (!curso_academico.equals(other.curso_academico))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fecha_matricula == null) {
			if (other.fecha_matricula != null)
				return false;
		} else if (!fecha_matricula.equals(other.fecha_matricula))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listado_asignaturas == null) {
			if (other.listado_asignaturas != null)
				return false;
		} else if (!listado_asignaturas.equals(other.listado_asignaturas))
			return false;
		if (nuevo_ingreso == null) {
			if (other.nuevo_ingreso != null)
				return false;
		} else if (!nuevo_ingreso.equals(other.nuevo_ingreso))
			return false;
		if (num_archivo == null) {
			if (other.num_archivo != null)
				return false;
		} else if (!num_archivo.equals(other.num_archivo))
			return false;
		if (turno_preferente == null) {
			if (other.turno_preferente != null)
				return false;
		} else if (!turno_preferente.equals(other.turno_preferente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", curso_academico=" + curso_academico + ", estado=" + estado + ", num_archivo="
				+ num_archivo + ", turno_preferente=" + turno_preferente + ", fecha_matricula=" + fecha_matricula
				+ ", nuevo_ingreso=" + nuevo_ingreso + ", listado_asignaturas=" + listado_asignaturas + "]";
	}

}
