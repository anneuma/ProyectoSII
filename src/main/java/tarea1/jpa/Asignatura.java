package tarea1.jpa;

import java.io.Serializable;
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
	
	private static final long serialVersionUID = 1L;
	
	public Asignatura(){
		
	}
}
