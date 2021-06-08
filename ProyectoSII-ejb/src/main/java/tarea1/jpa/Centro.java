package tarea1.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Centro implements Serializable {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String direccion;
	private Long TLF_Conserjeria;
	
	@ManyToMany(mappedBy = "centros")
	private List<Titulacion> titulaciones;
	
	private static final long serialVersionUID = 1L;
	
	public Centro(Long id, String nombre, String direccion, Long tLF_Conserjeria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.TLF_Conserjeria = tLF_Conserjeria;
	}
	
	public Centro() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getTLF_Conserjeria() {
		return TLF_Conserjeria;
	}
	public void setTLF_Conserjeria(Long tLF_Conserjeria) {
		TLF_Conserjeria = tLF_Conserjeria;
	}
	
	public List<Titulacion> getTitulaciones() {
		return titulaciones;
	}

	public void setTitulaciones(List<Titulacion> titulaciones) {
		this.titulaciones = titulaciones;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TLF_Conserjeria == null) ? 0 : TLF_Conserjeria.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((titulaciones == null) ? 0 : titulaciones.hashCode());
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
		Centro other = (Centro) obj;
		if (TLF_Conserjeria == null) {
			if (other.TLF_Conserjeria != null)
				return false;
		} else if (!TLF_Conserjeria.equals(other.TLF_Conserjeria))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (titulaciones == null) {
			if (other.titulaciones != null)
				return false;
		} else if (!titulaciones.equals(other.titulaciones))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Centro [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", TLF_Conserjeria="
				+ TLF_Conserjeria + ", titulaciones=" + titulaciones + "]";
	}
	
}
