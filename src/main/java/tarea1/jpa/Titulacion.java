package tarea1.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity


public class Titulacion implements Serializable {

	@Id
	private Long Codigo;
	private String Nombre;
	private Integer Creditos;
	
	@ManyToMany
	private List<Centro> centros;
	
	@ManyToMany
	private List<Expediente> expedientes;
	
	@ManyToOne
	private Titulacion titulacion;
	
	@ManyToOne
	private List<Grupo> grupos;
	
	@ManyToOne
	private List<Asignatura> asignaturas;
	
	private static final long serialVersionUID = 1L;
	
	public Titulacion(Long codigo, String nombre, Integer creditos) {
		super();
		Codigo = codigo;
		Nombre = nombre;
		Creditos = creditos;
	}
	public Titulacion() {
		
	}   
	public Long getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(Long Codigo) {
		this.Codigo = Codigo;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
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
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((Creditos == null) ? 0 : Creditos.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
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
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		if (Creditos == null) {
			if (other.Creditos != null)
				return false;
		} else if (!Creditos.equals(other.Creditos))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Titulacion [Codigo=" + Codigo + ", Nombre=" + Nombre + ", Creditos=" + Creditos + "]";
	}
	
}
