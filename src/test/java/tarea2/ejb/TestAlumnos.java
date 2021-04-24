package tarea2.ejb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.anotaciones.Requisitos;
import tarea1.jpa.*;
import tarea2.exception.*;


public class TestAlumnos {
	
	private static final Logger LOG = Logger.getLogger(TestAlumnos.class.getCanonicalName());

	private static final String ALUMNO_EJB = "java:global/classes/AlumnoEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "ProyectoSII_Test";

	private GestionAlumno gestionAlumno;

	@Before
	public void setup() throws NamingException  {
		gestionAlumno = (GestionAlumno) SuiteTest.ctx.lookup(ALUMNO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Requisitos({"RF-003"})
	@Test
	public void testAlumnoExistente() {
		
		Alumno alumno1 = new Alumno("95115697E", "Carmelita", "Enríquez", "Navarro", "06104200001@uma.es", "CarmelitaEnriquezNavarro@gustr.com", (long) 795115697, (long) 795115697, "Ventanilla de Beas 72", "Ourol", "MÁLAGA", "27865");
			try {
				gestionAlumno.insertarAlumno(alumno1);
			} catch (AlumnoExisteException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de alumno existente"); 
			}
	}
	@Requisitos({"RF-003"})
	@Test
	public void testObtenerExpedienteAlumnoNoExiste() {
				
			try {
				Alumno alumno1 = new Alumno("95115697E", "Carmelita", "Enríquez", "Navarro", "06104200001@uma.es", "CarmelitaEnriquezNavarro@gustr.com", (long) 795115697, (long) 795115697, "Ventanilla de Beas 72", "Ourol", "MÁLAGA", "27865");
				gestionAlumno.obtenerExpedientes(alumno1);
			} catch (AlumnoNoExisteException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de alumno no existente"); 
			}
	}
	
	@Requisitos({"RF-003"})
	@Test
	public void testEliminarAlumnoNoExiste() {
		try {
			Alumno alumno1 = new Alumno("95115697E", "Carmelita", "Enríquez", "Navarro", "06104200001@uma.es", "CarmelitaEnriquezNavarro@gustr.com", (long) 795115697, (long) 795115697, "Ventanilla de Beas 72", "Ourol", "MÁLAGA", "27865");
			
			gestionAlumno.eliminarAlumno(alumno1);

		} catch (AlumnoNoExisteException e) {
			// OK
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de alumno no existente");
		}
	}
	
	@Requisitos({"RF-003"})
	@Test
	public void testActualizarAlumnoNoExiste() {
		try {
			Alumno alumno1 = new Alumno("95115697E", "Carmelita", "Enríquez", "Navarro", "06104200001@uma.es", "CarmelitaEnriquezNavarro@gustr.com", (long) 795115697, (long) 795115697, "Ventanilla de Beas 72", "Ourol", "MÁLAGA", "27865");

			gestionAlumno.actualizarAlumno(alumno1);

		} catch (AlumnoNoExisteException e){
			//OK
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de alumno no existente");
		}
	}
	
	@Requisitos({"RF-013"})
	@Test
	public void testSolicitarCambioHorario()
	{
		try {
			Alumno alumno1 = new Alumno("95115697E", "Carmelita", "Enríquez", "Navarro", "06104200001@uma.es", "CarmelitaEnriquezNavarro@gustr.com", (long) 795115697, (long) 795115697, "Ventanilla de Beas 72", "Ourol", "MÁLAGA", "27865");
			new String documento;
			gestionAlumno.solicitarCambioHorario(al1, documento);

		} catch (AlumnoNoExisteException|DocumentoNoExisteException e){
			//OK
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de alumno no existente");
		}
	}
	
}
