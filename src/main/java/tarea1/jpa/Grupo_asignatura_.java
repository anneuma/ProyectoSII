package tarea1.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-08T09:37:25.503-0700")
@StaticMetamodel(Grupo_asignatura.class)
public class Grupo_asignatura_ {
	public static volatile SingularAttribute<Grupo_asignatura, String> curso_academico;
	public static volatile SingularAttribute<Grupo_asignatura, String> oferta;
	public static volatile ListAttribute<Grupo_asignatura, Grupo> grupo;
	public static volatile ListAttribute<Grupo_asignatura, Encuesta> encuestas;
	public static volatile ListAttribute<Grupo_asignatura, Asignatura> asignatura;
}
