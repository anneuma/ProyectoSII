package tarea1.jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-08T09:04:40.765-0700")
@StaticMetamodel(Matricula.class)
public class Matricula_ {
	public static volatile SingularAttribute<Matricula, Long> id;
	public static volatile SingularAttribute<Matricula, String> curso_academico;
	public static volatile SingularAttribute<Matricula, String> estado;
	public static volatile SingularAttribute<Matricula, Long> num_archivo;
	public static volatile SingularAttribute<Matricula, String> turno_preferente;
	public static volatile SingularAttribute<Matricula, Date> fecha_matricula;
	public static volatile SingularAttribute<Matricula, Boolean> nuevo_ingreso;
	public static volatile ListAttribute<Matricula, Asignatura> listado_asignaturas;
}
