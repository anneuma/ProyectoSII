package tarea1.jpa;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Asignatura implements Serializable {
	
	@Id
	private Long referencia;
	private Long codigo;
	private Integer creditos_totales;
	private Integer creditos_practicos;
	private Integer creditos_teoricos;
	private Integer oferta;
	private String nombre;
	private String curso;
	private String caracter;
	private String duracion;
	private String unidad_temporal;
	private String idiomas;
	
	private static final long serialVersionUID = 1L;
	
	public Asignatura(){
		
	}
}
