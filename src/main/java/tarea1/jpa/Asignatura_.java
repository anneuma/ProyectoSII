package tarea1.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-08T13:04:36.101-0700")
@StaticMetamodel(Asignatura.class)
public class Asignatura_ {
	public static volatile SingularAttribute<Asignatura, Long> referencia;
	public static volatile SingularAttribute<Asignatura, Long> codigo;
	public static volatile SingularAttribute<Asignatura, Integer> creditos_totales;
	public static volatile SingularAttribute<Asignatura, Integer> creditos_practicos;
	public static volatile SingularAttribute<Asignatura, Integer> creditos_teoricos;
	public static volatile SingularAttribute<Asignatura, Integer> oferta;
	public static volatile SingularAttribute<Asignatura, String> nombre;
	public static volatile SingularAttribute<Asignatura, String> curso;
	public static volatile SingularAttribute<Asignatura, String> caracter;
	public static volatile SingularAttribute<Asignatura, String> duracion;
	public static volatile SingularAttribute<Asignatura, String> unidad_temporal;
	public static volatile SingularAttribute<Asignatura, String> idiomas;
	public static volatile SingularAttribute<Asignatura, Grupo_asignatura> grupo_asignatura;
	public static volatile SingularAttribute<Asignatura, Clase> clases;
	public static volatile SingularAttribute<Asignatura, Asignaturas_matricula> asignatura_matricula;
}
