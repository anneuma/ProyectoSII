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



public class TestTitulacion {
	
	private static final Logger LOG = Logger.getLogger(TestTitulacion.class.getCanonicalName());

	private static final String TITULACION_EJB = "java:global/classes/TitulacionEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "ProyectoSII_Test";

	private GestionTitulacion gestionTitulacion;

	@Before
	public void setup() throws NamingException  {
		gestionTitulacion = (GestionTitulacion) SuiteTest.ctx.lookup(TITULACION_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Requisitos({"RF-005"})
	@Test
	public void testTitulacionExistente() {
		
		Titulacion titulacion1 = new Titulacion((long) 1, "Ingenieria Informática",240);
			try {
				gestionTitulacion.insertarTitulacion(titulacion1);
			} catch (TitulacionExisteException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de titulacion existente"); 
			}
	}
	@Requisitos({"RF-005"})
	@Test
	public void testObtenerExpedienteTitulacionNoExiste() {
				
			try {
				Titulacion titulacion1 = new Titulacion((long) 1, "Ingenieria Informática",240);
				gestionTitulacion.obtenerExpedientes(titulacion1);
			} catch (TitulacionNoExisteException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de titulacion no existente"); 
			}
	}
	
	@Requisitos({"RF-005"})
	@Test
	public void testObtenerGruposTitulacionNoExiste() {
				
			try {
				Titulacion titulacion1 = new Titulacion((long) 1, "Ingenieria Informática",240);
				gestionTitulacion.obtenerGrupos(titulacion1);
			} catch (TitulacionNoExisteException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de titulacion no existente"); 
			}
	}
	
	@Requisitos({"RF-005"})
	@Test
	public void testObtenerCentrosTitulacionNoExiste() {
				
			try {
				Titulacion titulacion1 = new Titulacion((long) 1, "Ingenieria Informática",240);
				gestionTitulacion.obtenerCentros(titulacion1);
			} catch (TitulacionNoExisteException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de titulacion no existente"); 
			}
	}
	
	@Requisitos({"RF-005"})
	@Test
	public void testObtenerAsignaturasTitulacionNoExiste() {
				
			try {
				Titulacion titulacion1 = new Titulacion((long) 1, "Ingenieria Informática",240);
				gestionTitulacion.obtenerAsignaturas(titulacion1);
			} catch (TitulacionNoExisteException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de titulacion no existente"); 
			}
	}
	
	@Requisitos({"RF-005"})
	@Test
	public void testEliminarTitulacionNoExiste() {
		try {
			Titulacion titulacion1 = new Titulacion((long) 1, "Ingenieria Informática",240);
			
			gestionTitulacion.eliminarTitulacion(titulacion1);

		} catch (TitulacionNoExisteException e) {
			// OK
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de titulacion no existente");
		}
	}
	
	@Requisitos({"RF-005"})
	@Test
	public void testActualizarTitulacionNoExiste() {
		try {
			Titulacion titulacion1 = new Titulacion((long) 1, "Ingenieria Informática",240);
			
			gestionTitulacion.actualizarTitulacion(titulacion1);

		} catch (TitulacionNoExisteException e){
			//OK
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de titulacion no existente");
		}
	}
	
	
}