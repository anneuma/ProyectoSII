package tarea1.jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-08T12:59:57.223-0700")
@StaticMetamodel(Encuesta.class)
public class Encuesta_ {
	public static volatile SingularAttribute<Encuesta, Integer> id;
	public static volatile SingularAttribute<Encuesta, Date> fecha_envio;
	public static volatile ListAttribute<Encuesta, Grupo_asignatura> grupo_asignaturas;
	public static volatile ListAttribute<Encuesta, Expediente> expedientes;
}
