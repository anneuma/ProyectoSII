package tarea1.jpa;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String DNI;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String apellido1;
	private String apellido2;
	@Column(nullable=false)
	private String email_i;
	private String email_p;
	private Long telefono;
	private Long movil;
	private String direccion;
	private String localidad;
	private String provincia;
	private String CP;
	@OneToMany
	private List<Expediente> expedientes;

	public Long getId () {
   return id;
	}
	
	public String getNombre () {
		return nombre;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido1 () {
		return apellido1;
	}
	
	public void setApellido1 (String apellido1) {
		this.apellido1 = apellido1;
	}
	
	public String getApellido2 () {
		return apellido2;
	}
	
	public void setApellido2 (String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public String getEmail_i () {
		return email_i;
	}
	
	public void setEmail_i (String email_i) {
		this.email_i = email_i;
	}
	
	public String getEmail_p () {
		return email_p;
	}
	
	public void setEmail_p (String email_p) {
		this.email_p = email_p;
	}
	
	public Long getTelefono () {
		return telefono;
	}
	
	public void setTelefono (Long telefono) {
		this.telefono = telefono;
	}
	
	public Long getMovil () {
		return movil;
	}
	
	public void setMovil (Long movil) {
		this.movil = movil;
	}
	
	public String getDireccion () {
		return direccion;
	}
	
	public void setDireccion (String direccion) {
		this.direccion = direccion;
	}
	
	public String getLocalidad () {
		return localidad;
	}
	
	public void setLocalidad (String localidad) {
		this.localidad = localidad;
	}
	
	public String getProvincia () {
		return provincia;
	}
	
	public void setProvincia (String provincia) {
		this.provincia = provincia;
	}
	
	public String getCP () {
		return CP;
	}
	
	public void setCP (String CP) {
		this.CP = CP;
	}
	
	public List<Expediente> getExpedientes () {
		return expedientes;
	}
	
	public void setExpedientes (List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CP == null) ? 0 : CP.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((apellido1 == null) ? 0 : apellido1.hashCode());
		result = prime * result + ((apellido2 == null) ? 0 : apellido2.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((email_i == null) ? 0 : email_i.hashCode());
		result = prime * result + ((email_p == null) ? 0 : email_p.hashCode());
		result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((movil == null) ? 0 : movil.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Alumno other = (Alumno) obj;
		if (CP == null) {
			if (other.CP != null)
				return false;
		} else if (!CP.equals(other.CP))
			return false;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (apellido1 == null) {
			if (other.apellido1 != null)
				return false;
		} else if (!apellido1.equals(other.apellido1))
			return false;
		if (apellido2 == null) {
			if (other.apellido2 != null)
				return false;
		} else if (!apellido2.equals(other.apellido2))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (email_i == null) {
			if (other.email_i != null)
				return false;
		} else if (!email_i.equals(other.email_i))
			return false;
		if (email_p == null) {
			if (other.email_p != null)
				return false;
		} else if (!email_p.equals(other.email_p))
			return false;
		if (expedientes == null) {
			if (other.expedientes != null)
				return false;
		} else if (!expedientes.equals(other.expedientes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (movil == null) {
			if (other.movil != null)
				return false;
		} else if (!movil.equals(other.movil))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", DNI=" + DNI + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", email_i=" + email_i + ", email_p=" + email_p + ", telefono=" + telefono + ", movil="
				+ movil + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia + ", CP="
				+ CP + ", expedientes=" + expedientes + "]";
	}
	
}
