import java.io.Serializable;
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
	private List<Expedientes> expedientes;
	
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
	
	public Expedientes getExpedientes () {
		return expedientes;
	}
	
	public void setExpedientes (Expedientes expedientes) {
		this.expedientes = expedientes;
	}
}
