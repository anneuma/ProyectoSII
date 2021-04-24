package tarea2.ejb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
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


public class TestAsignaturas {
	private static final Logger LOG = Logger.getLogger(TestAsignaturas.class.getCanonicalName());
	
	private static final String ASIGNATURA_EJB = "java:global/classes/AsignaturaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "ProyectoSII_Test";

	private GestionAsignatura gestionAsignatura;
	
	@Before
	public void setup() throws NamingException, ParseException  {
		gestionAsignatura = (GestionAsignatura) SuiteTest.ctx.lookup(ASIGNATURA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF-004"})
	@Test
	public void testAsignaturaExistente() {
		
		Asignatura asignatura1 = new Asignatura();
			try {
				gestionAsignatura.insertarAsignatura(asignatura1);
			} catch (AsignaturaEncontradaException e) {
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de asignatura encontrada"); 
			}
	}
	
	@Requisitos({"RF-004"})
	@Test
	public void testEliminarAsignaturaNoExiste() {
		try {
			Asignatura asignatura1 = new Asignatura();
			
			gestionAsignatura.eliminarAsignatura(asignatura1);

		} catch (AsignaturaNoEncontradaException e) {
			// OK
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de asignatura no encontrada");
		}
	}
	
	@Requisitos({"RF-004"})
	@Test
	public void testActualizarAsignaturaNoExiste() {
		try {
			Asignatura asignatura1 = new Asignatura();

			gestionAsignatura.actualizarAsignatura(asignatura1);

		} catch (AsignaturaEncontradaException e){
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de asignatura no encontrada");
		}
}
