package tarea1.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-08T09:28:28.199-0700")
@StaticMetamodel(Expediente.class)
public class Expediente_ {
	public static volatile SingularAttribute<Expediente, Long> num_expediente;
	public static volatile SingularAttribute<Expediente, Boolean> activo;
	public static volatile SingularAttribute<Expediente, Long> nota_media_provisional;
	public static volatile SingularAttribute<Expediente, Matricula> matricula;
}
