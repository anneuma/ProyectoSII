package tarea1.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-08T13:04:19.744-0700")
@StaticMetamodel(Asignaturas_matricula.class)
public class Asignaturas_matricula_ {
	public static volatile SingularAttribute<Asignaturas_matricula, Long> id;
	public static volatile SingularAttribute<Asignaturas_matricula, Integer> Calificacion;
	public static volatile SingularAttribute<Asignaturas_matricula, Matricula> matriculas;
	public static volatile ListAttribute<Asignaturas_matricula, Asignatura> asignatura;
	public static volatile ListAttribute<Asignaturas_matricula, Grupo> grupo;
}
