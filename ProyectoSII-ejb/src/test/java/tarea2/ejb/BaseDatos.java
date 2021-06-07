package tarea2.ejb;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tarea1.jpa.*;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) throws ParseException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Grupo grupo1A = new Grupo((long) 1, "primero", "A", "mañana", false, true, true, (long) 42);
		Grupo grupo2C = new Grupo((long) 2, "segundo", "C", "tarde", true, true, true, (long) 30);
		Alumno alumno1 = new Alumno((long) 1, "95115697E", "Carmelita", "Enríquez", "Navarro", "06104200001@uma.es", "CarmelitaEnriquezNavarro@gustr.com", (long) 795115697, (long) 795115697, "Ventanilla de Beas 72", "Ourol", "MÁLAGA", "27865");
		SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = (Date) dateformat3.parse("22/09/2020");
		Matricula matr1 = new Matricula((long) 00001, "2020/2021", "Activa", (long) 306000001, "Mañana", date1, false, "101-,102-,105");
		Titulacion titulacion1 = new Titulacion((long) 1, "Ingenieria Informática",240);

		em.persist(grupo1A);
		em.persist(grupo2C);
		em.persist(alumno1);
		em.persist(matr1);
		em.persist(titulacion1);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
