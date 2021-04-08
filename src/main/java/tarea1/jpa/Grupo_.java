package tarea1.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-08T09:25:10.677-0700")
@StaticMetamodel(Grupo.class)
public class Grupo_ {
	public static volatile SingularAttribute<Grupo, Long> id;
	public static volatile SingularAttribute<Grupo, String> curso;
	public static volatile SingularAttribute<Grupo, String> letra;
	public static volatile SingularAttribute<Grupo, String> turno_mañana_tarde;
	public static volatile SingularAttribute<Grupo, Boolean> ingles;
	public static volatile SingularAttribute<Grupo, Boolean> visible;
	public static volatile SingularAttribute<Grupo, Boolean> asignar;
	public static volatile SingularAttribute<Grupo, Long> plazas;
	public static volatile SingularAttribute<Grupo, Grupo_asignatura> grupo_asignatura;
	public static volatile SingularAttribute<Grupo, Grupo> grupo;
	public static volatile ListAttribute<Grupo, Grupo> grupos;
	public static volatile ListAttribute<Grupo, Titulacion> titulacion;
}
