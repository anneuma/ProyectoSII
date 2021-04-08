package tarea1.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-08T09:04:40.763-0700")
@StaticMetamodel(Centro.class)
public class Centro_ {
	public static volatile SingularAttribute<Centro, Long> id;
	public static volatile SingularAttribute<Centro, String> nombre;
	public static volatile SingularAttribute<Centro, String> direccion;
	public static volatile SingularAttribute<Centro, Long> TLF_Conserjeria;
	public static volatile ListAttribute<Centro, Titulacion> titulaciones;
}
