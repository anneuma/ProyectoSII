package tarea1.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-08T12:53:29.863-0700")
@StaticMetamodel(Alumno.class)
public class Alumno_ {
	public static volatile SingularAttribute<Alumno, Long> id;
	public static volatile SingularAttribute<Alumno, String> DNI;
	public static volatile SingularAttribute<Alumno, String> nombre;
	public static volatile SingularAttribute<Alumno, String> apellido1;
	public static volatile SingularAttribute<Alumno, String> apellido2;
	public static volatile SingularAttribute<Alumno, String> email_i;
	public static volatile SingularAttribute<Alumno, String> email_p;
	public static volatile SingularAttribute<Alumno, Long> telefono;
	public static volatile SingularAttribute<Alumno, Long> movil;
	public static volatile SingularAttribute<Alumno, String> direccion;
	public static volatile SingularAttribute<Alumno, String> localidad;
	public static volatile SingularAttribute<Alumno, String> provincia;
	public static volatile SingularAttribute<Alumno, String> CP;
	public static volatile ListAttribute<Alumno, Expediente> expedientes;
}
