package tarea1.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-08T12:08:33.920-0700")
@StaticMetamodel(Clase.class)
public class Clase_ {
	public static volatile SingularAttribute<Clase, String> dia;
	public static volatile SingularAttribute<Clase, String> hora_inicio;
	public static volatile SingularAttribute<Clase, String> hora_fin;
	public static volatile SingularAttribute<Clase, String> aula;
	public static volatile SingularAttribute<Clase, List> asignatura;
	public static volatile SingularAttribute<Clase, List> grupo;
}
