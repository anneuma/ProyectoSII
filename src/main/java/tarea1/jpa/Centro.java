package tarea1.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Centro {

	@Id @GeneratedValue
	private Long id;
	
}
