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
	private Grupo_asignatura grupo_asignatura;
	
	@ManyToOne 
	private Clase clases;
	
	@ManyToOne 
	private Asignaturas_matricula asignatura_matricula;
	
	@ManyToOne
	private Titulacion titulacion;
	
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
	
	public Asignaturas_matricula getAsignatura_Matricula() {
		return this.asignatura_matricula;
	}

	public void setAsignatura_Matricula(Asignaturas_matricula asg) {
		this.asignatura_matricula = asg;
	}
	
	public Grupo_asignatura getGrupo_asignatura() {
		return this.grupo_asignatura;
	}

	public void setGrupo_asignatura(Grupo_asignatura grup) {
		this.grupo_asignatura = grup;
	}
	
	public Clase getClase() {
		return this.clases;
	}

	public void setClases(Clase clases) {
		this.clases = clases;
	}
	
	
	public Asignaturas_matricula getAsignatura_matricula() {
		return asignatura_matricula;
	}

	public void setAsignatura_matricula(Asignaturas_matricula asignatura_matricula) {
		this.asignatura_matricula = asignatura_matricula;
	}

	public Clase getClases() {
		return clases;
	}

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignatura_matricula == null) ? 0 : asignatura_matricula.hashCode());
		result = prime * result + ((caracter == null) ? 0 : caracter.hashCode());
		result = prime * result + ((clases == null) ? 0 : clases.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((creditos_practicos == null) ? 0 : creditos_practicos.hashCode());
		result = prime * result + ((creditos_teoricos == null) ? 0 : creditos_teoricos.hashCode());
		result = prime * result + ((creditos_totales == null) ? 0 : creditos_totales.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((grupo_asignatura == null) ? 0 : grupo_asignatura.hashCode());
		result = prime * result + ((idiomas == null) ? 0 : idiomas.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((oferta == null) ? 0 : oferta.hashCode());
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		result = prime * result + ((titulacion == null) ? 0 : titulacion.hashCode());
		result = prime * result + ((unidad_temporal == null) ? 0 : unidad_temporal.hashCode());
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
		if (asignatura_matricula == null) {
			if (other.asignatura_matricula != null)
				return false;
		} else if (!asignatura_matricula.equals(other.asignatura_matricula))
			return false;
		if (caracter == null) {
			if (other.caracter != null)
				return false;
		} else if (!caracter.equals(other.caracter))
			return false;
		if (clases == null) {
			if (other.clases != null)
				return false;
		} else if (!clases.equals(other.clases))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (creditos_practicos == null) {
			if (other.creditos_practicos != null)
				return false;
		} else if (!creditos_practicos.equals(other.creditos_practicos))
			return false;
		if (creditos_teoricos == null) {
			if (other.creditos_teoricos != null)
				return false;
		} else if (!creditos_teoricos.equals(other.creditos_teoricos))
			return false;
		if (creditos_totales == null) {
			if (other.creditos_totales != null)
				return false;
		} else if (!creditos_totales.equals(other.creditos_totales))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (grupo_asignatura == null) {
			if (other.grupo_asignatura != null)
				return false;
		} else if (!grupo_asignatura.equals(other.grupo_asignatura))
			return false;
		if (idiomas == null) {
			if (other.idiomas != null)
				return false;
		} else if (!idiomas.equals(other.idiomas))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (oferta == null) {
			if (other.oferta != null)
				return false;
		} else if (!oferta.equals(other.oferta))
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		if (titulacion == null) {
			if (other.titulacion != null)
				return false;
		} else if (!titulacion.equals(other.titulacion))
			return false;
		if (unidad_temporal == null) {
			if (other.unidad_temporal != null)
				return false;
		} else if (!unidad_temporal.equals(other.unidad_temporal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asignatura [referencia=" + referencia + ", codigo=" + codigo + ", creditos_totales=" + creditos_totales
				+ ", creditos_practicos=" + creditos_practicos + ", creditos_teoricos=" + creditos_teoricos
				+ ", oferta=" + oferta + ", nombre=" + nombre + ", curso=" + curso + ", caracter=" + caracter
				+ ", duracion=" + duracion + ", unidad_temporal=" + unidad_temporal + ", idiomas=" + idiomas
				+ ", grupo_asignatura=" + grupo_asignatura + ", clases=" + clases + ", asignatura_matricula="
				+ asignatura_matricula + ", titulacion=" + titulacion + "]";
	}
	
}
