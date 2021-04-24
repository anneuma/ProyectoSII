package tarea2.ejb;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tarea1.jpa.*;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Grupo grupo1A = new Grupo((long) 1, "primero", "A", "mañana", false, true, true, (long) 42);
		Grupo grupo2C = new Grupo((long) 2, "segundo", "C", "tarde", true, true, true, (long) 30);
		em.persist(grupo1A);
		em.persist(grupo2C);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
