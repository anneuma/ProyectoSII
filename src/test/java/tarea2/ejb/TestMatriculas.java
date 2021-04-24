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


public class TestMatriculas {
	
	private static final Logger LOG = Logger.getLogger(TestAlumnos.class.getCanonicalName());

	private static final String Matricula_EJB = "java:global/classes/MatriculaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "ProyectoSII_Test";

	private GestionMatricula gestionMatricula;

	@Before
	public void setup() throws NamingException  {
		gestionMatricula = (GestionMatricula) SuiteTest.ctx.lookup(Matricula_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Requisitos({"RF-007"})
	@Test
	public void testAlumnoExistente() {
		
		Matricula matr1 = new Matricula((long) 00001, "2020/2021", "Activa", (long) 306000001, "Mañana", 22/09/2020, false, new List<Asignatura> asignaturas );
			try {
				gestionMatricula.insertarMatricula(matr1);
			} catch (MatriculaExisteException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de matricula existente"); 
			}
	}
	
	@Requisitos({"RF-007"})
	@Test
	public void testEliminarMatriculaNoExiste() {
		try {
			Matricula matr1 = new Matricula((long) 00001, "2020/2021", "Activa", (long) 306000001, "Mañana", 22/09/2020, false, new List<Asignatura> asignaturas );
			
			gestionMatricula.eliminarMatricula(matr1);

		} catch (MatriculaNoExisteException e) {
			// OK
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de matricula no existente");
		}
	}
	
	@Requisitos({"RF-007"})
	@Test
	public void testActualizarMatriculaNoExiste() {
		try {
			Matricula matr1 = new Matricula((long) 00001, "2020/2021", "Activa", (long) 306000001, "Mañana", 22/09/2020, false, new List<Asignatura> asignaturas );

			gestionMatricula.actualizarMatricula(matr1);

		} catch (MatriculaNoExisteException e){
			//OK
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de matricula no existente");
		}
	}
	
	@Requisitos({"RF-007"})
	@Test
	public Asignaturas_matricula testObtenerAsignaturaMatriculaMatriculaNoEncontrada() {
				
			try {
				Matricula matr1 = new Matricula((long) 00001, "2020/2021", "Activa", (long) 306000001, "Mañana", 22/09/2020, false, new List<Asignatura> asignaturas );

				gestionMatricula.obtenerAsignaturaMatricula(matr1);
				
			} catch (MatriculaNoEncontradaException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de matricula no encontrada"); 
			}
	}
	@Requisitos({"RF-007"})
	@Test
	public List<Expediente> testObtenerExpedientesMatriculaNoEncontrada() {
		try {
			Matricula matr1 = new Matricula((long) 00001, "2020/2021", "Activa", (long) 306000001, "Mañana", 22/09/2020, false, new List<Asignatura> asignaturas );

			gestionMatricula.obtenerExpedientes(matr1);
			
		} catch (MatriculaNoEncontradaException e) {
			//OK
		} catch (ProyectoException e) {
			fail("Debe lanzar excepción de matricula no encontrada"); 
		}
		
	}
	
}