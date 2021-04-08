package tarea1.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Expediente
 *
 */
@Entity

public class Expediente implements Serializable {

	   
	@Id
	private Long num_expediente;
	private Boolean activo;
	private Long nota_media_provisional;
	
	private static final long serialVersionUID = 1L;

	public Expediente() {

	}   
	public long getNum_expediente() {
		return this.num_expediente;
	}

	public void setNum_expediente(long num_expediente) {
		this.num_expediente = num_expediente;
	}   
	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}   
	public long getNota_media_provisional() {
		return this.nota_media_provisional;
	}

	public void setNota_media_provisional(long nota_media_provisional) {
		this.nota_media_provisional = nota_media_provisional;
	}
   
}
