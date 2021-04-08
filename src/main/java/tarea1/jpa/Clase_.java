package tarea1.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-08T13:06:35.849-0700")
@StaticMetamodel(Clase.class)
public class Clase_ {
	public static volatile SingularAttribute<Clase, String> dia;
	public static volatile SingularAttribute<Clase, String> hora_inicio;
	public static volatile SingularAttribute<Clase, String> hora_fin;
	public static volatile SingularAttribute<Clase, String> aula;
	public static volatile ListAttribute<Clase, Asignatura> asignatura;
	public static volatile ListAttribute<Clase, Grupo> grupo;
}
