package tarea1.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-08T12:53:30.010-0700")
@StaticMetamodel(Titulacion.class)
public class Titulacion_ {
	public static volatile SingularAttribute<Titulacion, Long> Codigo;
	public static volatile SingularAttribute<Titulacion, String> Nombre;
	public static volatile SingularAttribute<Titulacion, Integer> Creditos;
	public static volatile ListAttribute<Titulacion, Centro> centros;
	public static volatile ListAttribute<Titulacion, Expediente> expedientes;
	public static volatile SingularAttribute<Titulacion, Titulacion> titulacion;
	public static volatile ListAttribute<Titulacion, Grupo> grupos;
	public static volatile ListAttribute<Titulacion, Asignatura> asignaturas;
}
