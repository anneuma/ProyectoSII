package tarea1.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Asignatura implements Serializable {
	
	@Id
	private Long referencia;
	@Column(nullable = false)
	private Long codigo;
	@Column(nullable = false)
	private Integer creditos_totales;
	@Column(nullable = false)
	private Integer creditos_practicos;
	@Column(nullable = false)
	private Integer creditos_teoricos;
	@Column(nullable = false)
	private Integer oferta;
	@Column(nullable = false)
	private String nombre;
	private String curso;
	private String caracter;
	private String duracion;
	private String unidad_temporal;
	private String idiomas;
	
	@ManyToOne 
	private List<Grupo_asignatura> grupo_asignatura;
	
	private List<Clase> clases;
	
	private List<Asignaturas_matricula> asignatura_matricula;
	
	private static final long serialVersionUID = 1L;
	
	public Asignatura(Long ref, Long cod, Integer credtot, Integer credprac, Integer credteo, Integer ofer, String nomb)
	{
		super();
		this.referencia = ref;
		this.codigo = cod;
		this.creditos_totales = credtot;
		this.creditos_practicos = credprac;
		this.creditos_teoricos = credteo;
		this.oferta = ofer;
		this.nombre = nomb;
	}
	
	public Asignatura(){
		
	}
	
	public Long getReferencia()
	{
		return this.referencia;
	}
	
	public void setReferencia(Long referencia)
	{
		this.referencia = referencia;
	}
	
	public Long getCodigo()
	{
		return this.codigo;
	}
	
	public void setCodigo(Long codigo)
	{
		this.codigo = codigo;
	}
	
	public Integer getCreditos_totales() {
		return this.creditos_totales;
	}

	public void setCreditos_totales(Integer Creditos_totales) {
		this.creditos_totales = Creditos_totales;
	}   
	public Integer getCreditos_practicos() {
		return this.creditos_practicos;
	}

	public void setCreditos_practicos(Integer Creditos_practicos) {
		this.creditos_practicos = Creditos_practicos;
	}   
	public Integer getCreditos_teoricos() {
		return this.creditos_teoricos;
	}

	public void setCreditos_teoricos(Integer Creditos_teoricos) {
		this.creditos_teoricos = Creditos_teoricos;
	}
	
	public Integer getOferta() {
		return this.oferta;
	}

	public void setOferta(Integer Oferta) {
		this.oferta = Oferta;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}   
	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String Curso) {
		this.curso = Curso;
	}   
	public String getCaracter() {
		return this.caracter;
	}

	public void setCaracter(String Caracter) {
		this.caracter = Caracter;
	}   
	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String Duracion) {
		this.duracion = Duracion;
	}   
	public String getUnidad_temporal() {
		return this.unidad_temporal;
	}

	public void setUnidad_temporal(String unidad_temporal) {
		this.unidad_temporal = unidad_temporal;
	}   
	public String getIdiomas() {
		return this.idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}
	
	public List<Asignaturas_matricula> getAsignatura_Matricula() {
		return this.asignatura_matricula;
	}

	public void setAsignatura_Matricula(List<Asignaturas_matricula> asg) {
		this.asignatura_matricula = asg;
	}
	
	public List<Grupo_asignatura> getGrupo_asignatura() {
		return this.grupo_asignatura;
	}

	public void setGrupo_asignatura(List<Grupo_asignatura> grup) {
		this.grupo_asignatura = grup;
	}
	
	public List<Clase> getClase() {
		return this.clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + codigo);
		result = prime * result + creditos_practicos;
		result = prime * result + creditos_teoricos;
		result = prime * result + creditos_totales;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + oferta;
		result = (int) (prime * result + referencia);
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
		Asignatura other = (Asignatura) obj;
		if (codigo != other.codigo)
			return false;
		if (creditos_practicos != other.creditos_practicos)
			return false;
		if (creditos_teoricos != other.creditos_teoricos)
			return false;
		if (creditos_totales != other.creditos_totales)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (oferta != other.oferta)
			return false;
		if (referencia != other.referencia)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Asignatura [Referencia=");
		builder.append(referencia);
		builder.append(", Codigo=");
		builder.append(codigo);
		builder.append(", Creditos_totales=");
		builder.append(creditos_totales);
		builder.append(", Creditos_practicos=");
		builder.append(creditos_practicos);
		builder.append(", Creditos_teoricos=");
		builder.append(creditos_teoricos);
		builder.append(", Oferta=");
		builder.append(oferta);
		builder.append(", Nombre=");
		builder.append(nombre);
		builder.append("]");
		return builder.toString();
	}
}
