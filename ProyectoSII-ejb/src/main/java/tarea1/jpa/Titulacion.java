package tarea1.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Titulacion implements Serializable {

	@Id
	private Long codigo;
	private String nombre;
	private Integer Creditos;
	
	@ManyToMany
	private List<Centro> centros;
	
	@OneToMany(targetEntity=Expediente.class)
	private List<Expediente> expedientes;
	
	@OneToMany(targetEntity=Grupo.class)
	private List<Grupo> grupos;
	
	@OneToMany(targetEntity=Asignatura.class)
	private List<Asignatura> asignaturas;
	
	private static final long serialVersionUID = 1L;
	
	public Titulacion(Long codigo, String nombre, Integer creditos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.Creditos = creditos;
	}
	public Titulacion() {
		super();
	}   
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long Codigo) {
		this.codigo = Codigo;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public Integer getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(Integer Creditos) {
		this.Creditos = Creditos;
	}
	
	public List<Centro> getCentros()
	{
		return this.centros;
	}
	
	public void setCentros(List<Centro> lista)
	{
		this.centros = lista;
	}
	
	public List<Grupo> getGrupos()
	{
		return this.grupos;
	}
	
	public void setGrupos(List<Grupo> lista)
	{
		this.grupos = lista;
	}
	
	public List<Expediente> getExpedientes()
	{
		return this.expedientes;
	}
	
	public void setExpedientes(List<Expediente> lista)
	{
		this.expedientes = lista;
	}
	
	public List<Asignatura> getAsignaturas()
	{
		return this.asignaturas;
	}
	
	public void setAsignaturas(List<Asignatura> lista)
	{
		this.asignaturas = lista;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((Creditos == null) ? 0 : Creditos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((asignaturas == null) ? 0 : asignaturas.hashCode());
		result = prime * result + ((centros == null) ? 0 : centros.hashCode());
		result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
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
		Titulacion other = (Titulacion) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false; 
		if (Creditos == null) {
			if (other.Creditos != null)
				return false;
		} else if (!Creditos.equals(other.Creditos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (asignaturas == null) {
			if (other.asignaturas != null)
				return false;
		} else if (!asignaturas.equals(other.asignaturas))
			return false;
		if (centros == null) {
			if (other.centros != null)
				return false;
		} else if (!centros.equals(other.centros))
			return false;
		if (expedientes == null) {
			if (other.expedientes != null)
				return false;
		} else if (!expedientes.equals(other.expedientes))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Titulacion [codigo=" + codigo + ", nombre=" + nombre + ", Creditos=" + Creditos + ", centros=" + centros
				+ ", expedientes=" + expedientes + ", grupos=" + grupos + ", asignaturas=" + asignaturas + "]";
	}
	
}
