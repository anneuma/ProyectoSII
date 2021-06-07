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


public class TestExpediente {
	private static final Logger LOG = Logger.getLogger(TestExpediente.class.getCanonicalName());
	
	private static final String EXPEDIENTE_EJB = "java:global/classes/ExpedienteEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "ProyectoSII_Test";

	private GestionExpediente gestionExpediente;
	
	@Before
	public void setup() throws NamingException, ParseException  {
		gestionExpediente = (GestionExpediente) SuiteTest.ctx.lookup(EXPEDIENTE_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF-006"})
	@Test
	public void testExpedienteExistente() {
		
		Expediente expediente1 = new Expediente();
			try {
				gestionExpediente.insertarExpediente(expediente1);
			} catch (ExpedienteEncontradoException e) {
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de expediente encontrado"); 
			}
	}
	
	@Requisitos({"RF-006"})
	@Test
	public void testEliminarExpedienteNoExiste() {
		try {
			Expediente expediente1 = new Expediente();
			
			gestionExpediente.eliminarExpediente(expediente1);

		} catch (ExpedienteNoEncontradoException e) {
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de expediente no encontrado");
		}
	}
	
	@Requisitos({"RF-006"})
	@Test
	public void testActualizarExpedienteNoExiste() {
		try {
			Expediente expediente1 = new Expediente();

			gestionExpediente.actualizarExpediente(expediente1);

		} catch (ExpedienteEncontradoException e){
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de expediente no encontrado");
		}
	}
}
